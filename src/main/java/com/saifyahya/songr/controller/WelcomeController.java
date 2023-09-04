package com.saifyahya.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String home() {
        return "home.html";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello "+name;
    }

    @GetMapping("/capitalize/{sentence}")
    public String captialize(Model m, @PathVariable String sentence) {
        String result = sentence.toUpperCase();
        m.addAttribute("sentence",result);
        return "capitalize.html";

    }
}
