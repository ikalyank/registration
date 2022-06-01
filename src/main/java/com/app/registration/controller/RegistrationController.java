package com.app.registration.controller;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RegistrationController{
    @Autowired
    private RegistrationServiceImpl register_loginservice;
    @PostMapping("/registeruser")
    @CrossOrigin("http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        if (tempEmailId != null && !"".equals(tempEmailId))
        {
           User userobj = register_loginservice.fetchUserByEmailid(tempEmailId);
           if (userobj !=null)
           {
               throw new Exception("User with this"+ tempEmailId+ "Id already exists");
           }
        }
        User userobj = register_loginservice.saveUser(user);
        return userobj;
    }
    @PostMapping("/loginuser")
    @CrossOrigin("http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception
    {
        String tempEmailId = user.getEmailId();
        String tempPass = user.getPassword();
        User userobj=null;
        if (tempEmailId != null && tempPass != null)
        {
            userobj = register_loginservice.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
        }
        if (userobj==null)
        {
            throw new Exception("The User Does Not Exist");
        }
        return userobj;
    }
    @PostMapping("/password")
    @CrossOrigin("http://localhost:4200")
    public User changePassword(@RequestBody User user) throws Exception
    {
        String tempEmailId= user.getEmailId();
        String tempPassword= user.getPassword();
        User userObj=null;
        if(tempEmailId !=null && tempPassword != null)
            {
                userObj=register_loginservice.fetchUserByEmailid(tempEmailId);
                userObj.setPassword(tempPassword);
                register_loginservice.saveUser(userObj);
            }
        if(userObj==null)
        {
            throw new Exception("User does not exists");
        }
        return userObj;
    }
}
