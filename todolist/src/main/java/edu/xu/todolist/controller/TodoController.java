package edu.xu.todolist.controller;

import java.util.*;
import edu.xu.todolist.model.Task;
import edu.xu.todolist.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    
    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<Task> findAll(){
        return todoRepo.findAll();
    }

    @PostMapping
    public Task save(@RequestBody Task task) {
        return todoRepo.save(task);
    }

    @PutMapping("/{id}")
    public Task update(@RequestBody Task task) {
        task.setDone(true);
        return todoRepo.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoRepo.deleteById(id);
    }

}

