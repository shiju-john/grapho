package com.flytxt.grapho.config.oauth2.resourceserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
/**
 * 
 * @author shiju.john
 *
 */
@Configuration
@EnableResourceServer
@EnableConfigurationProperties
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
    @Autowired
    TokenStore tokenStore;
    
   	@Bean	
	@Qualifier("tokenServices")
   	@Primary
	public DefaultTokenServices tokenServices() {
		final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore);
		return defaultTokenServices;
	}

    @Value("${resource.id}")
    private String id;
    
	@Override
    public void configure(final ResourceServerSecurityConfigurer config) {
		
		config.resourceId(id).tokenStore(tokenStore);
        config.resourceId(id).tokenServices(tokenServices());
        
        
	}
	
	    
    @Override
    public void configure(final HttpSecurity http) throws Exception {
     http
        .csrf().disable()
        .authorizeRequests()        
        //.and().authorizeRequests().antMatchers("/job/**").authenticated()
        //.and().authorizeRequests().antMatchers("/grapho/job/**").authenticated();        
       // .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	    .antMatchers(HttpMethod.GET, "/job/**").hasAnyAuthority("read","write")        
	    .antMatchers(HttpMethod.POST, "/job/**").hasAuthority("write") 
	    .antMatchers(HttpMethod.GET, "/job/executeJob/**").hasAuthority("execute") 
	    .antMatchers(HttpMethod.PUT, "/job/**").hasAuthority("write") 
	    .antMatchers(HttpMethod.DELETE, "/job/**").hasAuthority("write")	    
	    .antMatchers(HttpMethod.GET, "/connector/**").hasAnyAuthority("read","write")        
	    .antMatchers(HttpMethod.POST, "/connector/**").hasAuthority("write")	    
	    .antMatchers(HttpMethod.PUT, "/connector/**").hasAuthority("write") 
	    .antMatchers(HttpMethod.DELETE, "/connector/**").hasAuthority("write");    
    }
    
}
