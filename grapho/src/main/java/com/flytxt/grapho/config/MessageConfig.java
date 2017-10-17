package com.flytxt.grapho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author shiju.john
 *			
 */
@Component
public class MessageConfig {
	
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
	  ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
	  messageBundle.setBasename("classpath:messages");
	  messageBundle.setDefaultEncoding("UTF-8");
	  return messageBundle;
	}

}
