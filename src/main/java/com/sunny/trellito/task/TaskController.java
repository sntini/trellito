package com.sunny.trellito.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService service;


    @GetMapping("/all")
    public String getAllTasks(Model model){
        model.addAttribute("taskList", service.findAll());
        return "task/list-tasks";
    }

    @GetMapping("/id={id}")
    public String getTaskById(@PathVariable("id") long id, Model model){
        model.addAttribute("task", service.findById(id));
        return "task/task-detail";
    }
}
