package com.flytxt.grapho.config.oauth2.authserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 
 * @author shiju.john
 *
 */

@Configuration
@EnableConfigurationProperties
public class AuthenticationBuilderConfig {
    @Value("${authentication.AuthenticationBuilder}")
    private String authenticationBuilder;
    
    @Bean
    @Primary
    public AuthenticationType getAuthenticationType() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
    		return (AuthenticationType) Class.forName(authenticationBuilder).newInstance();
    }
}