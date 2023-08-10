package com.poc.cleaningrobots.adapter.output.log;

import com.poc.cleaningrobots.domain.Position;
import com.poc.cleaningrobots.ports.output.SendResponsePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LogOutput implements SendResponsePort {
    @Override
    public void sendResponse(List<Position> results) {
        log.info("########### RESULTS ###########");
        results.forEach(position -> log.info("{} {} {}", position.getX(), position.getY(), position.getDirection().name()));
    }
}
