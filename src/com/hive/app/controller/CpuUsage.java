package com.hive.app.controller;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

interface ICpuUsage {

	public double getCpuUsage();

}

public class CpuUsage implements ICpuUsage {
	
	 private static CpuUsage instance;
	    
	    private CpuUsage() {}
	    
	    public static synchronized CpuUsage getInstance() {
	        if (instance == null) {
	            instance = new CpuUsage();
	        }
	        return instance;
	    }
	
	
	@Override
	public double getCpuUsage() {
		OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
		return osBean.getSystemLoadAverage();
	}
}
