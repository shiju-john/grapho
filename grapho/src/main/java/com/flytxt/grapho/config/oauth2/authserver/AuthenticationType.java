package com.flytxt.grapho.config.oauth2.authserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * 
 * @author shiju.john
 *
 */
@Configuration
public interface AuthenticationType { 
	
	/**
	 * For setting the authentication type 
	 * @throws Exception
	 */
	public void setAuthenticationManager(AuthenticationManagerBuilder auth)  throws Exception;

}