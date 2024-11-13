package com.simple.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.taskmanagement.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
