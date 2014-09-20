package com.marketmobile.model.vo;

import java.util.Date;

public class ServerInformation {
	
	private String version;
	private String ip;
	private String hostname;
	private String osinfo;
	private String erro;	
	private Date servertime;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getOsinfo() {
		return osinfo;
	}

	public void setOsinfo(String osinfo) {
		this.osinfo = osinfo;
	}

	public Date getServertime() {
		return servertime;
	}

	public void setServertime(Date servertime) {
		this.servertime = servertime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
	
	





	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServerInformation [version=");
		builder.append(version);
		builder.append(", ip=");
		builder.append(ip);
		builder.append(", hostname=");
		builder.append(hostname);
		builder.append(", osinfo=");
		builder.append(osinfo);
		builder.append(", erro=");
		builder.append(erro);
		builder.append(", servertime=");
		builder.append(servertime);
		builder.append("]");
		return builder.toString();
	}

	
}
