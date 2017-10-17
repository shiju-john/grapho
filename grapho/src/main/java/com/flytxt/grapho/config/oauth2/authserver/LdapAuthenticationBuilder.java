package com.flytxt.grapho.config.oauth2.authserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
@EnableConfigurationProperties
public class LdapAuthenticationBuilder implements AuthenticationType{
	
	/** LDAP Directory Domain */
	@Value("${authentication.mode.ldap.activeDirectoryDomain}")
    private String activeDirectoryDomain;
	
	/** LDAP Directory URL  */
	@Value("${authentication.mode.ldap.activeDirectoryUrl}")
    private String activeDirectoryUrl;
	
	
	@Override
	public void setAuthenticationManager(AuthenticationManagerBuilder auth) {
		ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(
				activeDirectoryDomain, activeDirectoryUrl);
		provider.setConvertSubErrorCodesToExceptions(true);
	    provider.setUseAuthenticationRequestCredentials(true);		     
		auth.authenticationProvider(provider);		
	}
	
	

}
