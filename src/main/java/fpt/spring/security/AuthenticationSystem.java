package fpt.spring.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationSystem {
	
	public static boolean isLogged() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName() + "");
        return null != authentication && !authentication.getName().equals("anonymousUser");
    }
}
