package com.hive.app.model;

import com.hive.app.controller.CpuUsage;
import com.hive.app.controller.ReportingService;

public class CpuUsageViewModel implements CpuUsageModelInterface{
	
	private ReportingService reportingService;

	public CpuUsageViewModel() {
		reportingService = new ReportingService();
	}

	@Override
	public double getCPUUsage() {
		return CpuUsage.getInstance().getCpuUsage();
	}

	@Override
	public void reportCPUUsage(String clientId, String groupId) {
		reportingService.reportCPUUsage(clientId, groupId, getCPUUsage());
	}
}


interface CpuUsageModelInterface {
	
	public double getCPUUsage();
	
	void reportCPUUsage(String clientId, String groupId);
}