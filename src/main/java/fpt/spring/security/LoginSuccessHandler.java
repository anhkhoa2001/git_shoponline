package fpt.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String role = auth.getAuthorities().toString();
		String redirectURL = "/myspring/home";
		if (role.contains("ADMIN")) {
            redirectURL = "/myspring/manage";
        } 
         
        response.sendRedirect(redirectURL);
    }
}