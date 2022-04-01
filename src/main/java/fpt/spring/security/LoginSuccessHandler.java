package fpt.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import fpt.spring.model.Account;
import fpt.spring.service.AccountService;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	AccountService accountService;
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
    	authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	Account account = accountService.getAccountByUsername(username);
    	String role = account.getRole();
    	
		String redirectURL = "/myspring/home";
		if (role.contains("ADMIN")) {
            redirectURL = "/myspring/manage";
        } 
         
        response.sendRedirect(redirectURL);
    }
}