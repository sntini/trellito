package com.sunny.trellito.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        return "user/list-user";
    }

    @GetMapping("/id={id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", service.findUserById(id));
        return "user/user";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {
        service.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/new-user-form";
    }

    @GetMapping("/delete/id={id}")
    public String deleteUser(@PathVariable("id") long id) {
        service.deleteUser(id);
        return "redirect:/user/all";
    }

    @GetMapping("/edit/id={id}")
    public String editUserForm(@PathVariable("id") long id, Model model) {
        User user = service.findUserById(id);
        model.addAttribute("user", user);
        return "user/update-user-form";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        service.saveUser(user);
        return "redirect:/user/all";
    }

}
