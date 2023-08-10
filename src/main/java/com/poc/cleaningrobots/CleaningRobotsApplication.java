package com.poc.cleaningrobots;

import com.poc.cleaningrobots.application.services.RobotCleanerService;
import com.poc.cleaningrobots.application.services.RobotCleanerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CleaningRobotsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleaningRobotsApplication.class, args);
    }

    @Bean
    public RobotCleanerService service(){
        return new RobotCleanerServiceImpl();
    }

}
