package com.droidfire.campfire;

public class Message {
	private String to;
	private String from;
	private String content;
	
	public Message(String to, String from, String content) {
		this.to = to;
		this.from = from;
		this.content = content;
	}
	
	public String getTo() {
		return this.to;
	}
	
	public String getFrom() {
		return this.from;
	}
	
	public String getContent() {
		return this.content;
	}
}
