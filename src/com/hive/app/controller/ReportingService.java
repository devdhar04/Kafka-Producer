package com.hive.app.controller;

import com.hive.app.network.ApiEndPoint;
import com.hive.app.network.HttpClient;
import com.hive.app.network.Request;

public class ReportingService {

    private final HttpClient httpClient;

    public ReportingService() {

        this.httpClient = new HttpClient();
    }

    public void reportCPUUsage(String clientId, String groupId,double cpuUsage) {
        Request data = new Request(clientId, groupId, cpuUsage);
        httpClient.postData(ApiEndPoint.ENDPOINT_SEND_REPORT, data);
    }
}