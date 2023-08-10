package com.poc.cleaningrobots.application.services;

import com.poc.cleaningrobots.domain.Floor;
import com.poc.cleaningrobots.domain.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RobotCleanerService {
    List<Position> perform(Floor floor);
}
