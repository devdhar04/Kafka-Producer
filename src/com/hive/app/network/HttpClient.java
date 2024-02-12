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

            String jsonPayload =  request.toString();
          
            System.out.println("Response from server:"+jsonPayload); 
            DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
            outputStream.writeBytes(jsonPayload);
            outputStream.flush();
            outputStream.close();

            int responseCode = conn.getResponseCode();

           if (responseCode == HttpURLConnection.HTTP_OK) {
                // Open an input stream to read the response body
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                // Read the response line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Close the input stream
                in.close();

                // Print the response from the server
                System.out.println("Response from server:");
                System.out.println(response.toString());
            } else {
                // Print an error message if the request was not successful
                System.out.println("Failed to upload data to server. Response code: " + responseCode);
            }

            // Close the connection
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Error occurred while sending data: " + e.getMessage());
        }
    }
}

