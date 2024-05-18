package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@Controller
@RequestMapping("withdraw/{id}/{password}")
public class WithdrawController {


    @Autowired
    private WithdrawService service1;


    @Autowired
    private UserService service2;

    @GetMapping("/{period}")
    public String getAll(Model model, @PathVariable("id") String userId,
                         @PathVariable("password") String password, @PathVariable("period") Period period) {
        if (!service2.get(userId, password)) {
            return "unregistered";
        }


        var all = service1.get(userId, period);
        long plus = 0;
        long minus = 0;

        HashMap<Category, Long> withdraws = new HashMap();
        for (DTO d : all) {
            if (d.type == WITHDRAW) {
                if (withdraws.containsKey(d.category)) {
                    withdraws.put(d.category, withdraws.get(d.category) + d.sum);
                } else {
                    withdraws.put(d.category, d.sum);
                }
                plus +=d.sum;
            } else minus += d.sum;
        }
        model.addAttribute("balance", plus - minus);
        if (period == Period.WEEK){
            model.addAttribute("period","31");
        }
        else {
            model.addAttribute("period","7");
        }
        model.addAttribute("withdraws",withdraws);
        return "information";
    }

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
