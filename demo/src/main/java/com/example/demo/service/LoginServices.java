package com.example.demo.service;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {

    public boolean validateUser(String Email, String password,String clientid ,String clientsecret) {
        // in28minutes, dummy
        return Email.equalsIgnoreCase("in28minutes")
                && password.equalsIgnoreCase("dummy")
                &&  clientid.equalsIgnoreCase("32456")
                && clientsecret.equalsIgnoreCase("4656");
    }

}