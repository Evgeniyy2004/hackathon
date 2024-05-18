package com.example.demo;

import com.example.demo.model.UserWhereaboutsDto;
import com.example.demo.service.UserWhereaboutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/{id}/{password}")
public class UserController {
    @Autowired
    private UserWhereaboutsService service;


    @PostMapping("/")
    public String register(Model model, @PathVariable("id") String userId,
                           @PathVariable("password") String password){
            if (service.getUserWhereabouts(Long.parseLong(userId))!=null) {
                return "already";
            }
            else {
                service.createUserWhereabouts(new UserWhereaboutsDto());
                return "successregistry";
            }

    }
}
