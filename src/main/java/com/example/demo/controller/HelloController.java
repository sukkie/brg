package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index : <br>" + DemoApplication.RESULT_SET;
    }
}
