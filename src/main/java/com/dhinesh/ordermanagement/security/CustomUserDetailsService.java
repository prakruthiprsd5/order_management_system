package com.dhinesh.ordermanagement.security;


import com.dhinesh.ordermanagement.dao.UserRepository;
import com.dhinesh.ordermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName);
        if(user == null) {
        	throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}