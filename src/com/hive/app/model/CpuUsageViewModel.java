package com.hive.app.model;

public class CpuUsageViewModel {

    private final CpuUsageModel cpuUsageModel;

    public CpuUsageViewModel() {
        cpuUsageModel = new CpuUsageModel();
    }

    public double getCPUUsage() {
        return cpuUsageModel.getCPUUsage();
    }

    public void reportCPUUsage(String clientId, String groupId,double cpuUsage) {
        cpuUsageModel.reportCPUUsage(clientId, groupId,cpuUsage);
    }
}
