package com.app.registration.Repository;

import com.app.registration.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository <User,Integer>{
    
}
