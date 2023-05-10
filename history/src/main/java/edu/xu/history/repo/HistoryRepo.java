package edu.xu.history.repo;

import edu.xu.history.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<Task, Long>{

}

