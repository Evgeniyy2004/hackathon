package com.example.demo;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.BankOperationCategory;
import com.example.demo.model.BankOperationDto;
import com.example.demo.service.BankIntegrationService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserWhereaboutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/{id}/{password}")
public class MoneyController {
    private BankIntegrationService service1;

    private UserService service2;

    @Autowired
    public MoneyController(BankIntegrationService service1, UserService service2){
        this.service1 = service1;
        this.service2 = service2;
    }

    @GetMapping("/{period}")
    public String getAll(Model model, @PathVariable("id") String userId,
                         @PathVariable("password") String password, @PathVariable("period") Period period) {
        try {
            service2.getUserShortDtoById(Long.parseLong(userId));
        } catch (NotFoundException e) {
            return "unregistered";

        }


        var all = service1.getUserBalance(Long.parseLong(userId));
        Map<BankOperationCategory,Long> withdraws = new HashMap<>();
        model.addAttribute("balance", all);
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
    public String pay(Model model, @RequestParam(name = "time") ZonedDateTime DateTime, @PathVariable("id") String userId,
                      @PathVariable("password") String password, @PathVariable("category") BankOperationCategory category,
                      @PathVariable("sum") long sum) {
        try {
            service2.getUserShortDtoById(Long.parseLong(userId));
        } catch (NotFoundException e) {
            return "unregistered";

        }
        var dto = new BankOperationDto();
        dto.setAmount(sum);
        dto.setOperationCategory(category);
        dto.setZonedDateTime(DateTime);
        service1.getBankOperationData(dto);
        return "successoperation";
    }
}
