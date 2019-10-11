package com.spoors.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.spoors")
@EnableWebMvc
public class WebMvcConfig {
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	@Bean("valid")
	public MessageSource createResourceBundleMessageSource() {
		ResourceBundleMessageSource rbms=null;
		rbms=new ResourceBundleMessageSource();
		//rbms.setBasename("com.spoors.commons.validation");
		rbms.setBasename("validation");
		return rbms;
		
	}
}
