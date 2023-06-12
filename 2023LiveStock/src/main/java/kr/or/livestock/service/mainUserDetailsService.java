package kr.or.livestock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.livestock.entity.user_info;
import kr.or.livestock.mapper.user_info_mapper;

public class mainUserDetailsService implements UserDetailsService {

	@Autowired
	user_info_mapper mapper;
	
	@Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
		user_info user = mapper.sign_in(user_id);
//		System.out.println(user.getUser_id() + ","+ user.getUsername() + " " +user.getUser_pw() + ","+ user.getPassword());
        if(user==null) {
            throw new UsernameNotFoundException(user_id);
        }
        return user;
    }
	
}
