package com.example.demo;

import com.example.demo.model.BankOperationCategory;
import com.example.demo.service.BankIntegrationService;
import com.example.demo.service.UserWhereaboutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@Controller
@RequestMapping("/{id}/{password}")
public class MoneyController {


    @Autowired
    private BankIntegrationService service1;


    @Autowired
    private UserWhereaboutsService service2;

    @GetMapping("/{period}")
    public String getAll(Model model, @PathVariable("id") String userId,
                         @PathVariable("password") String password, @PathVariable("period") Period period) {
        if (service2.getUserWhereabouts(Long.parseLong(userId))==null) {
            return "unregistered";
        }


        var all = service1.get(userId, period);
        long plus = 0;
        long minus = 0;

        HashMap<Category, Long> withdraws = new HashMap();
        for (DTO d : all) {
            if (d.type == BankOperationCategory.WITHDRAWAL) {
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
        if (service2.getUserWhereabouts(Long.parseLong(userId))==null) {
            return "unregistered";
        }

        service1.add(userId,category,localDateTime, sum);
        return "successoperation";
    }
}
