package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= "user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {

        return "/user/add";
    }

    @PostMapping("user")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
             if(User.getPassword() == verify) {
                 return "/user/index";
             } else {
                 model.addAttribute("error", "Passwords should match");
                 model.addAttribute("username", User.getUsername());
                 model.addAttribute("email", User.getEmail());
                 return "/user/add";
             }
    }
}
