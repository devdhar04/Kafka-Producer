package com.hive.app.controller;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

interface ICpuUsage {

	public double getCpuUsage();

}

public class CpuUsage implements ICpuUsage {
	
	
	@Override
	public double getCpuUsage() {
		OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
		return osBean.getSystemLoadAverage();
	}
}
