package com.flytxt.grapho.config.oauth2.resourceserver;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
public class JwtConfig{
  
	
	
	@Bean
	@Qualifier("tokenStore")
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
    }
    
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
	    final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    final Resource resource = new ClassPathResource("public.cert");
	    String publicKey = null;
	    try {
	        publicKey = IOUtils.toString(resource.getInputStream());
	    } catch (final IOException e) {
	        throw new RuntimeException(e);
	    }
	    converter.setVerifierKey(publicKey);
	    return converter;
    }
}