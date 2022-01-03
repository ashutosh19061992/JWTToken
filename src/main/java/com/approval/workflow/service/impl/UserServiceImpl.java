package com.approval.workflow.service.impl;

import com.approval.workflow.model.User;
import com.approval.workflow.repository.UserRepository;
import com.approval.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveRegisteredUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String emailId) {
        return this.userRepository.findByEmail(emailId);
    }

    @Override
    public User findUserById(Integer id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
