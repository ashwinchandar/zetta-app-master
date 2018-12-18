package com.zetta.app.vo;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;*/

/*@Indexed
@Entity*/
public class KnowledgeBean {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private Integer knowledgeid; 
	/*@Field*/
	private String category;
	/*@Field*/
	private String topic;
	/*@Field*/
	private String subject;
	/*@Field*/
	private String createdDate;
	/*@Field*/
	private String createdBy;
	/*@Field*/
	private String updatedDate;
	/*@Field*/
	private String updatedBy;
	public Integer getKnowledgeid() {
		return knowledgeid;
	}
	public void setKnowledgeid(Integer knowledgeid) {
		this.knowledgeid = knowledgeid;
	}
	public String getCategory() {
		return category;
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
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}


/*public String getCategory() {
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
public String getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(String updatedDate) {
	this.updatedDate = updatedDate;
}
public String getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}*/