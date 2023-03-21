package com.example.demo.contoller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import static com.example.demo.login.*;


@Controller
public class register {



    @RequestMapping(value = "/")
    public String saveUser() {

        return "login";
    }





    @RequestMapping("/login")
    public ModelAndView userReistration(@RequestParam("email") String email, @RequestParam("password") String password,
                                        @RequestParam("clientid") String clientid, @RequestParam("clientsecret") String clientsecret, Model model) {

        conn.setEmail(email);
        conn.setPassword(password);
        conn.setClientId(clientid);
        conn.setClientSecret(clientsecret);
        String projectUrl = "http://127.0.0.1:5501/index.html";

        String[] result = aoth();
        if (result[0] != null) {

            return new ModelAndView("redirect:" + projectUrl);
        } else {
            model.addAttribute("code", "ErrorCode: 400");
            model.addAttribute("error", "error_description: authentication failure");
            return new ModelAndView("login");
        }



    }

}
