package com.sunny.trellito.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        return "list-user";
    }

    @GetMapping("/id={id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", service.findUserById(id));
        return "user";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {
        logger.info(user.toString());
        service.addUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new-user-form";
    }

}
