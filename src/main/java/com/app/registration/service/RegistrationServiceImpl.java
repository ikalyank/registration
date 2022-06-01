package com.app.registration.service;

import com.app.registration.Repository.RegistrationRepository;
import com.app.registration.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository repo;
    RegistrationService res;

    public RegistrationServiceImpl(RegistrationRepository repo) {
        this.repo = repo;
    }

    @Override
    public User saveUser(User user) {
       return repo.save(user);
    }
    @Override
    public User fetchUserByEmailid(String email)
    {
        return repo.findByEmailId(email);
    }
    @Override
    public User fetchUserByEmailIdAndPassword(String email,String password)
    {
        return repo.findByEmailIdAndPassword(email,password);
    }
    @Override
    public void updateUser(User user)
    {
         repo.delete(user);
    }
}
