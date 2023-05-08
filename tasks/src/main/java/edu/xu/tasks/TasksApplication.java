package edu.xu.tasks;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class TasksApplication {

	private List<String> tasks = new ArrayList<String>();

	@PostMapping("/tasks")
	public String createTask(@RequestBody String task) {
		tasks.add(task);
		return "Task created: " + task;
	}

	@GetMapping("/tasks")
	public String getTasks() {
		if(tasks.isEmpty()) {
			return "Currently no tasks.";
		}			
		else {
			return "Here is your plan: \n" + tasks;
		}		
	}

	@PutMapping("/tasks/{index}")
	public String updateTask(@PathVariable int index, @RequestBody String task) {
		if (index >= 0 && index < tasks.size()) {
			tasks.set(index, task);
			return "Task updated: " + task;
		} 
		else {
			return "Task not found";
		}
	}

	@DeleteMapping("/tasks/{index}")
	public String deleteTask(@PathVariable int index) {
		if (index >= 0 && index < tasks.size()) {
			String task = tasks.remove(index);
			return "Task deleted: " + task;
		} 
		else {
			return "Task not found";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

}
