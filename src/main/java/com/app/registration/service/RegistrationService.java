package com.app.registration.service;

import com.app.registration.Repository.RegistrationRepository;
import com.app.registration.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;
    public User saveUser(User user) {
       return repo.save(user);
    }
    public User fetchUserByEmailid(String email)
    {
        return repo.findByEmailId(email);
    }
    public User fetchUserByEmailIdAndPassword(String email,String password)
    {
        return repo.findByEmailIdAndPassword(email,password);
    }
    public void updateUser(User user)
    {
         repo.delete(user);
    }
}
