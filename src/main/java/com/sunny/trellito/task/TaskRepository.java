package com.sunny.trellito.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> getTasksByAssignee(Long assignee);

    List<Task> getTasksBySprint(Long sprint);
}
