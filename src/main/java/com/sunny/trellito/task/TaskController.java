package com.sunny.trellito.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("saveTask")
    public String saveTask(Task task){
        service.saveTask(task);
        return "redirect/task/all";
    }

    @GetMapping("/addTask")
    public String addTaskForm(Model model){
        model.addAttribute("task", new Task());
        return "task/new-task-form";
    }


    @GetMapping("/delete/id={id}")
    public String deleteTask(@PathVariable("id") long id){
        service.deleteTask(id);
        return "redirect:/task/all";
    }

    @GetMapping("/edit/id={id}")
    public  String editTaskForm(@PathVariable("id") long id, Model model){
        Task task =service.findById(id);
        model.addAttribute("task", task);
        return "task/update-user-form";
    }

    @PostMapping("/updateTask")
    public String updateTask(Task task){
        service.saveTask(task);
        return "redirect:/task/all";
    }
}
