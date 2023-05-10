package com.cuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/yhqt")
    public String viewpage(){
        return "yhqt";
    }

    @RequestMapping("/stht")
    public String viewpage1(){
        return "stht";
    }

    @RequestMapping("/dpht")
    public String viewpage2(){
        return "dpht";
    }
}
