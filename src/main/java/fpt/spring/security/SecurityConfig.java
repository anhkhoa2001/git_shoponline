package fpt.spring.security;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fpt.spring.model.Account;
import fpt.spring.service.AccountService;

@Configuration
@EnableWebSecurity
@Transactional
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired 
	private LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private AccountService accountService;

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
				.antMatchers("/home", "/resources/**")
				.permitAll()
				.and()
				.formLogin().loginPage("/login").successHandler(loginSuccessHandler)
				.and()
				.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		InMemoryUserDetailsManagerConfigurer imudmc = auth.inMemoryAuthentication();
		
		List<Account> list = accountService.findAll();
        for (int i = 0; i < list.size(); i++) {
            imudmc.withUser(list.get(i).getUsername()).password(list.get(i).getPassword()).roles(list.get(i).getRole());
        }
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
}
