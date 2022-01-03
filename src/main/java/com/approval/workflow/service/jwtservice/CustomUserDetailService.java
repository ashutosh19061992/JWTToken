package com.approval.workflow.service.jwtservice;

import com.approval.workflow.model.User;
import com.approval.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userEmailAddress) throws UsernameNotFoundException {

        User user = this.userService.findUserByEmail(userEmailAddress);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email- " + userEmailAddress);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
