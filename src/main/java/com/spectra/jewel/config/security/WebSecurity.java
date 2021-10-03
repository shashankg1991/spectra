
package com.spectra.jewel.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableJpaRepositories("com.spectra.jewel.repository")
@EnableSolrRepositories(basePackages = "com.spectra.jewel.repository")
@EntityScan("com.spectra.jewel.model")
@ComponentScan(basePackages = "com.spectra.jewel")
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService defautUserDetailsService;

	@Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     

	@Bean
	public AuthenticationProvider getProvider() {
		SpectraAuthProvider provider = new SpectraAuthProvider();
		 provider.setUserDetailsService(defautUserDetailsService);
		 provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(defautUserDetailsService);
    }

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic();
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/**").permitAll();
		http.authorizeRequests().antMatchers("/**/resources/**", "/**/resources/**").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/test/**").permitAll();
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		http.authorizeRequests().and().formLogin().loginPage("/login").loginProcessingUrl("/login")
				.failureUrl("/login?error").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/");
		http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");
		
		//Added for H2 database console to work
		http.headers().frameOptions().sameOrigin();
	}
	
}
