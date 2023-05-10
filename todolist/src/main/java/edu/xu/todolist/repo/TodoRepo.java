package edu.xu.todolist.repo;

import edu.xu.todolist.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Task, Long> {
    
}