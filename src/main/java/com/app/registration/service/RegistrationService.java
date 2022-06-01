package com.app.registration.service;

import com.app.registration.model.User;

public interface RegistrationService {
    public User saveUser(User user);
    public User fetchUserByEmailid(String email);
    public User fetchUserByEmailIdAndPassword(String email,String password);
    public void updateUser(User user);
}
