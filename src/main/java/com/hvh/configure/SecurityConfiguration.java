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
@EnableWebSecurity//kích hoạt việc tích hợp spring security vs spring mvc
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
		.antMatchers("/cart/**").hasRole("USER")//antMatchers--khai báo đường dẫn trang web.....
		.anyRequest().permitAll()//permitall--cho phép tất cả các user đc truy cập
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/log")
		.usernameParameter("username")
		.passwordParameter("password")
		.failureUrl("/login?error=failed")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/home")
		.and()
		.exceptionHandling()//truy cap ko dung quyen
		.accessDeniedPage("/error")
		;
//		http.sessionManagement().sessionFixation().newSession()
//		.invalidSessionUrl("/login?message=timeout")
//		.maximumSessions(1)
//		.expiredUrl("/login?message=max_session")
//		.maxSessionsPreventsLogin(true);
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");
	}
}
