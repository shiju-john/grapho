package com.flytxt.grapho.config.oauth2.authserver;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
/**
 * 
 * @author shiju.john
 *
 */

@Configuration
public class DBAuthenticationBuilder implements AuthenticationType{

	
	@Autowired
	DataSource dataSource;
	
	@Override
	public void setAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
		
	}

}