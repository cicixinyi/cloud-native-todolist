package edu.xu.history;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/history")
public class HistoryApplication {

	private final List<Tuple<String, LocalDateTime>> historyList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> addHistory(@RequestBody String task) {
        LocalDateTime dateTime = LocalDateTime.now();
        Tuple<String, LocalDateTime> historyTuple = new Tuple<>(task, dateTime);
        historyList.add(historyTuple);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Tuple<String, LocalDateTime>> getHistory() {
        return historyList;
    }

	public static void main(String[] args) {
		SpringApplication.run(HistoryApplication.class, args);
	}

}
