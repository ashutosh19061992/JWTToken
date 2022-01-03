package com.approval.workflow.service;

import com.approval.workflow.model.User;

public interface UserService {
    User saveRegisteredUser(User user);

    User findUserByEmail(String emailId);

    User findUserById(Integer id);
}
