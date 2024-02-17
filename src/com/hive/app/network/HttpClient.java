package com.hive.app.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

	@SuppressWarnings("deprecation")
	public void postData(String url, Request request) {
		try {
			URL serverUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			String jsonPayload = request.toString();

			System.out.println("Response from server:" + jsonPayload);
			DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
			outputStream.writeBytes(jsonPayload);
			outputStream.flush();
			outputStream.close();

			int responseCode = conn.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				in.close();

				System.out.println("Response from server:");
				System.out.println(response.toString());
			} else {
				System.out.println("Failed to upload data to server. Response code: " + responseCode);
			}

			conn.disconnect();
		} catch (Exception e) {
			System.out.println("Error occurred while sending data: " + e.getMessage());
		}
	}
}
