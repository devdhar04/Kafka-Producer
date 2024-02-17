package com.hive.app.model;

import com.hive.app.controller.CpuUsage;
import com.hive.app.controller.ReportingService;

public class CpuUsageModel {

	private final CpuUsage cpuUsageModule;
	private final ReportingService reportingService;

	public CpuUsageModel() {
		cpuUsageModule = new CpuUsage();
		reportingService = new ReportingService();
	}

	public double getCPUUsage() {
		return cpuUsageModule.getCpuUsage();
	}

	public void reportCPUUsage(String clientId, String groupId, double cpuUsage) {
		reportingService.reportCPUUsage(clientId, groupId, cpuUsage);
	}
}
