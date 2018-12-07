package com.zetta.app.vo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;
@ConfigurationProperties
public class UploadBean {
	private String title;
	private MultipartFile[] fileDatas;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile[] getFileDatas() {
		return fileDatas;
	}
	public void setFileDatas(MultipartFile[] fileDatas) {
		this.fileDatas = fileDatas;
	}
}
