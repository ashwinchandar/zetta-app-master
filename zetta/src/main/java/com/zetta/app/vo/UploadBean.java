package com.zetta.app.vo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;
@ConfigurationProperties
public class UploadBean {
	private Integer file_id;
	private String title;
	private String filepath;
	public Integer getFile_id() {
		return file_id;
	}
	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}  
}
