package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("daposit/{id}/{password}")
public class DepositController {

    @Autowired
    private WithdrawService service1;


    @Autowired
    private UserService service2;
    @PostMapping("/{category}/{sum}")
    public String pay(Model model, @RequestParam(name = "time") LocalDateTime localDateTime, @PathVariable("id") String userId,
                      @PathVariable("password") String password, @PathVariable("category") Category category,
                      @PathVariable("sum") long sum) {
        if (!service2.get(userId, password)) {
            return "unregistered";
        }

        service1.add(userId,category,localDateTime, sum);
    }
}
