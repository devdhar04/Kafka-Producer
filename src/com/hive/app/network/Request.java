package com.hive.app.network;

import com.google.gson.Gson;

public class Request {

	private String clientId;
	
	private double cpuUsage;

	private String groupId;
	
	public double getCpuUsage() {
		return cpuUsage;
	}

	
	public Request(String clientId, String groupId, double cpuUsage) {
		this.clientId = clientId;
		this.cpuUsage = cpuUsage;
		this.groupId = groupId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public String getClientId() {
		return clientId;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
