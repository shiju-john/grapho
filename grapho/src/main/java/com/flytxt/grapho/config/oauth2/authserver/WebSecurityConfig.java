package com.flytxt.grapho.config.oauth2.authserver;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 
 * @author shiju.john
 *
 */
@Configuration
@EnableWebSecurity
@Order(4)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);

	@Autowired
	private AuthenticationType authType;
	
	@Override
	@Bean
	@Primary
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}
	

	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling()
				.authenticationEntryPoint(
						(request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and().authorizeRequests().antMatchers("/oauth/**").authenticated().and().httpBasic();
		// .and().authorizeRequests().antMatchers("/grapho/**").permitAll().and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		authType.setAuthenticationManager(auth);
	}
}