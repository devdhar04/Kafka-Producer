package com.hive.app.model;

public class CpuUsageViewModel implements CpuUsageModelInterface{
	

	private final CpuUsageModel cpuUsageModel;

	public CpuUsageViewModel() {
		cpuUsageModel = new CpuUsageModel();
	}

	public double getCPUUsage() {
		return cpuUsageModel.getCPUUsage();
	}
    
	@Override
	public void reportCPUUsage(String clientId, String groupId, double cpuUsage) {
		cpuUsageModel.reportCPUUsage(clientId, groupId, cpuUsage);
	}
}


interface CpuUsageModelInterface {
	
	void reportCPUUsage(String clientId, String groupId, double cpuUsage);
}