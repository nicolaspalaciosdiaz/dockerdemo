package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DockerDemoController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "showform";
    }

    @RequestMapping("/processFormV3")
    public String processFormV3(@RequestParam("firstName") String theFirstName, @RequestParam("lastName") String theLastName, Model model) {

        // convert the data all caps
        theFirstName = theFirstName.toUpperCase();
        theLastName = theLastName.toUpperCase();

        // create the message to the model
        String result = "Homie! " + theFirstName + " " + theLastName;

        // add message to the model
        // "Name" = message, "Value" = result.
        // Name,value pair.
        model.addAttribute("message", result);

        return "formresult";
    }
}
