package com.hive.app.controller;

import com.hive.app.model.CpuUsageViewModel;

public class Client {
    public static void main(String[] args) throws Exception {
        // Client ID, replace with actual client ID
    	String clientId = "client1";
        String groupId = "groupId";
        // Server URL to report CPU usage
         
        CpuUsageViewModel viewModel = new CpuUsageViewModel();
        double cpuUsage = new  CpuUsage().getCpuUsage();
        viewModel.reportCPUUsage(clientId,groupId, cpuUsage);
        System.out.println("sending Data");
    }
}