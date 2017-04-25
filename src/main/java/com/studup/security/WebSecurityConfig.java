package com.studup.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthSuccessHandler authSuccessHandler;
	
	@Autowired
	private AuthFailureHandler authFailureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//			.antMatchers("/app/**","/fonts/**").permitAll()
		.antMatchers("/**").permitAll()
		
//			.anyRequest().fullyAuthenticated()
		.and()
			.formLogin().defaultSuccessUrl("/", true)
			.successHandler(authSuccessHandler)
			.failureHandler(authFailureHandler)
			.loginPage("/login").permitAll()
		.and()
			.logout().addLogoutHandler(new LogoutHandler() {
				@Override
				public void logout(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) {
					request.getSession().invalidate();
				}
			}).permitAll()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.invalidateHttpSession(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).deleteCookies("JSESSIONID")
		.and().csrf().disable().headers().frameOptions().disable();
//			.sessionManagement().maximumSessions(1);
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("abhinabkanrar@gmail.com").password("password").roles("STUDENT");
    }

}
