package kr.or.livestock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import kr.or.livestock.entity.user_info;

public class mainAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;

	@SuppressWarnings("unchecked")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        
//        System.out.println(username + " : " + password);
        
        user_info user = (user_info) userDetailsService.loadUserByUsername(username);
        
        if(!matchPassword(password, user.getPassword())) {
            throw new BadCredentialsException(username);
        }
 
        if(!user.isEnabled()) {
            throw new BadCredentialsException(username);
        }
        
//        System.out.println(username + " : " + password);
        
        System.out.println(user.getAuthorities());
        
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        
        if(auth != null) {
        	System.out.println("NotNULL");
        }
        
        return auth;
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
    private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }
	
}
