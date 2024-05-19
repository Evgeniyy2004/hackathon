package com.example.demo;

import com.example.demo.dto.UserDto;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/{fullname}/{password}/{email}/{phone}")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/")
    public String register(Model model, @PathVariable("email") String email,
                           @PathVariable("password") String password, @PathVariable("fullname") String fullname,
                           @PathVariable("phone") String phone) {
        try {
            var dto = new UserDto();
            dto.setPassword(password);
            dto.setEmail(email);
            dto.setFullName(fullname);
            dto.setPhone(phone);
            var result = service.create(dto);
            model.addAttribute("id", result.getId());
            return "successregistry";
        } catch (NotFoundException e) {
            return "already";
        }

    }


    @DeleteMapping("/")
    public String delete(Model model, @PathVariable("password") String password,
                         @RequestParam("id") String id) {
        try {
            service.delete(Long.parseLong(id),password);
            model.addAttribute("text", "удалены");
            return "successdeleteupdate";
        } catch (NotFoundException e) {
            model.addAttribute("text",e.getMessage());
            return "unregistered";
        }

    }

    @PutMapping("/")
    public String update( Model model, @PathVariable("email") String email,
                         @PathVariable("password") String password, @PathVariable("fullname") String fullname,
                         @PathVariable("phone") String phone) {
        try {
            var dto = new UserDto();
            dto.setPassword(password);
            dto.setEmail(email);
            dto.setFullName(fullname);
            dto.setPhone(phone);
            service.update(password,dto);
            model.addAttribute("text", "изменены");
            return "successdeleteupdate";
        } catch (NotFoundException e) {
            model.addAttribute("text",e.getMessage());
            return "unregistered";
        }

    }


}
