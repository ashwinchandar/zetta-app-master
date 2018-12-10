package com.zetta.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


import com.zetta.app.vo.UploadBean;

@SpringBootApplication
@ComponentScan("com.zetta.app")
@EnableConfigurationProperties({
	  UploadBean.class
})
public class ZettaApplication extends SpringBootServletInitializer { 
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZettaApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZettaApplication.class, args);
	} 
	
}
