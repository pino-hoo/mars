package com.mars.user.ui;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// example : please delete me
@Controller
public class HomeController {


    @GetMapping
    public String hello() {
        return "hello";
    }

}
