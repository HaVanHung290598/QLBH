package com.hvh.configure;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from user where username=?")
		.authoritiesByUsernameQuery("select username, role from user where username=?")
		.passwordEncoder(bCryptPasswordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/cart/**").hasRole("USER")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/log")
		.usernameParameter("username")
		.passwordParameter("password")
		.failureUrl("/login?error=failed")
		.permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/login?error=deny");
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");
	}
}