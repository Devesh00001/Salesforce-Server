package com.example.demo.contoller;


import com.example.demo.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.example.demo.login.*;


@Controller
public class register {





    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String saveUser(Model model) {
       // System.out.println(user.toString());
       // model.addAttribute("massage","hello world!");
        return "login"; // redirect to success page
    }

    @RequestMapping(value = "/loginfail",method = RequestMethod.GET)
    public String saveUser() {
        // System.out.println(user.toString());

        return "loginfail"; // redirect to success page
    }

    @RequestMapping("/login")
    public ModelAndView userReistration(@RequestParam("email") String email, @RequestParam("password") String password,
                                        @RequestParam("clientid") String clientid, @RequestParam("clientsecret") String clientsecret,Model model){


        conn.setEmail(email);
        conn.setPassword(password);
        conn.setClientId(clientid);
        conn.setClientSecret(clientsecret);
        String projectUrl  = "http://localhost:8080/leadsstatus";

        String[] result = aoth();
        if(result[0] != null) {
            return new ModelAndView("redirect:" + projectUrl);
        }

        else  {
//            StringBuilder sb = new StringBuilder();
//            if(clientid.length()<52){
//                sb.append("you enter wrong client id");
//            }else if (clientsecret.length() <32) {
//                sb.append("your clientsecret is wrong");
//
//            }else{
//                sb.append("pls check you email and password");
//            }


            model.addAttribute("data",response.getStatusLine().toString());
            return new ModelAndView("login");
        }




    }

    @RequestMapping("/my-page")
    public String myPage(Model model) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, world!");
        sb.append("<br>");
        sb.append("This is my StringBuilder content.");
        model.addAttribute("content", sb.toString());
        return "my-page";
    }

}
