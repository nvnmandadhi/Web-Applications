/**
 * 
 */
package com.naveen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author Naveen
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService studentService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

	//@formatter:off
	
	http
	
		.authorizeRequests()

			.antMatchers("/login","/register","/","/contact","/about").permitAll()

			.antMatchers("/resources/**").permitAll()
			
			.antMatchers("/users").hasAuthority("ROLE_ADMIN")
		        
			.anyRequest().authenticated()
			
		        	.and()
		        
		        .formLogin()
		        
		                .loginPage("/login")
		                
		                .permitAll()
		        
		                .and()
		                
		        .logout()
		        
		        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

	//formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	     
	auth.userDetailsService(studentService).passwordEncoder(passwordEncoder);
    }
 
}
