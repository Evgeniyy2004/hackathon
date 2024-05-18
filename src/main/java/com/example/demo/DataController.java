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
    private WithdrawService service1;

    @Autowired
    private DepositService service2;

    @Autowired
    private UserService service3;

    @GetMapping("/{period}")
    public String getAll(Model model,@PathVariable("id") String userId,
                         @PathVariable("password") String password, @PathVariable("period") Period period) {
        if (!service3.get(userId,password)){
            return "unregistered";
        }


        var withdraws = service1.get(userId,period);
        model.addAttribute()
        var deposits = service2.get(userId,period);
        return "information";
    }
}
