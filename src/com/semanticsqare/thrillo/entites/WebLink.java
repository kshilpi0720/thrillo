package com.semanticsqare.thrillo.entites;

import org.apache.commons.lang3.StringUtils;

import com.semanticsqare.thrillo.partner.Shareable;

public class WebLink extends BookMark implements Shareable{
	private String url;
	private String host;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}
	@Override
	public boolean isKidfreidly() {
		if(url.contains("porn")||getTitle().contains("porn")
				||host.contains("adult"))
		{
			return false;
		}
		return true;
		
	}
	@Override
	public String getItemdata() {
		StringBuilder builder= new StringBuilder();
		builder.append("<item>");
		builder.append("<type>WebLink</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<url>").append(url).append("</url>");
		builder.append("<host>").append(host).append("</host>");
	
		builder.append("</item>");
		return builder.toString();
	}
	

}
