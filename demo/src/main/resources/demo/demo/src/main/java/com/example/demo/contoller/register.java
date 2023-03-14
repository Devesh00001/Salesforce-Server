package com.example.demo.contoller;

import com.example.demo.login;
import com.example.demo.service.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.example.demo.login.aoth;
import static com.example.demo.login.con;


@Controller
public class register {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String saveUser(Model model) {
       // System.out.println(user.toString());
       // model.addAttribute("massage","hello world!");
        return "login"; // redirect to success page
    }

    @RequestMapping("/login")
    public ModelAndView userReistration(@RequestParam("email") String email, @RequestParam("password") String password,
                                        @RequestParam("clientid") String clientid, @RequestParam("clientsecret") String clientsecret){


        con.setEmail(email);
        con.setPassword(password);
        con.setClientId(clientid);
        con.setClientSecret(clientsecret);
        String projectUrl  = "http://localhost:8080/leadsstatus";

        String[] result = aoth();
        if(result[0] != null) {
            return new ModelAndView("redirect:" + projectUrl);
        }
        else{
            return null;
        }
}
}
