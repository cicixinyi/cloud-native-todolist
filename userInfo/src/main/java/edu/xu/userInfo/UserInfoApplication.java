package edu.xu.userInfo;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.*;

@SpringBootApplication
@RestController
public class UserInfoApplication {



	public static void main(String[] args) {
		SpringApplication.run(UserInfoApplication.class, args);
	}
}