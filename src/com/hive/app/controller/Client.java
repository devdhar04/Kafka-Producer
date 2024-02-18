package com.hive.app.controller;

import com.hive.app.model.CpuUsageViewModel;

public class Client {

	public static void main(String[] args) throws Exception {
		// Client ID, replace with actual client ID
		String clientId = "client1";
		String groupId = "groupId";

		new Thread(new Runnable() {

			@Override
			public void run() {

				while(true) {
				try {
					Thread.sleep(6000);
					CpuUsageViewModel viewModel = new CpuUsageViewModel();
					viewModel.reportCPUUsage(clientId, groupId);
					System.out.println("sending Data");

				} catch (InterruptedException e) {
					System.out.println("Thread interrupted");
				}

			}
			}
		}).start();

	}
}