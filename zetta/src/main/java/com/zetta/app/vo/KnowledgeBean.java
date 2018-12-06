package com.zetta.app.vo;

public class KnowledgeBean {
	private Integer knowledgeid;
	private String category;
	private String topic;
	private String subject;
	private String date;
	public String getCategory() {
		return category;
	}
	public Integer getKnowledgeid() {
		return knowledgeid;
	}
	public void setKnowledgeid(Integer knowledgeid) {
		this.knowledgeid = knowledgeid;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
