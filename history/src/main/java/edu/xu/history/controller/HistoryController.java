package edu.xu.history.controller;

import java.util.*;
import edu.xu.history.model.*;
import edu.xu.history.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryRepo historyRepo;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Task> getAllTasks() {
        String url = "http://localhost:6080/todo";
        ResponseEntity<List<Task>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Task>>(){});
        historyRepo.saveAll(response.getBody());
        return historyRepo.findAll();
    }
}

