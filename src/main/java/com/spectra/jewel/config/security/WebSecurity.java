package com.spectra.jewel.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spectra.jewel.service.impl.DefaultUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	DefaultUserDetailsService userDetailsService;

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic();
		http.authorizeRequests().antMatchers("/**/resources/**", "/**/resources/**").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/**").permitAll();
		http.authorizeRequests().and().formLogin().loginPage("/login").loginProcessingUrl("/login")
				.failureUrl("/login?error").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/");
		http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");
	}
	
	@Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     

	@Bean
	public AuthenticationProvider getProvider() {
		SpectraAuthProvider provider = new SpectraAuthProvider();
		 provider.setUserDetailsService(userDetailsService);
		 provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

}
