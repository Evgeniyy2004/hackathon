package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/get/{id}/{password}")
public class DataController {
    @Autowired
    private DataService service1;

    @Autowired
    private UserService service2;

    @GetMapping("/")
    public String getAll(Model model,@PathVariable("id") String userId, @PathVariable("password") String password) {
        if (!service2.get(userId,password)){

        }
        return "information";
    }
}
