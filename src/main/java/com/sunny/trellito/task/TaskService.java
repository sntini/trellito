package com.sunny.trellito.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List<Task> findAll() {
        return repo.findAll();
    }

    public Task findById(Long id) {
        return repo.getReferenceById(id);
    }

    public List<Task> getTasksByAssignee(Long id) {
        return repo.getTasksByAssignee(id);
    }

    public List<Task> getTasksBySprint(Long id) {
        return repo.getTasksBySprintNumber(id);
    }

    public void saveTask(Task task) {
        repo.save(task);
    }

    public void deleteTask(long id) {
        repo.deleteById(id);
    }
}
