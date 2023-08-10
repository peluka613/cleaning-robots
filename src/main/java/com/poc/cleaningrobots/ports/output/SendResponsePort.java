package com.poc.cleaningrobots.ports.output;

import com.poc.cleaningrobots.domain.Position;

import java.util.List;

public interface SendResponsePort {
    void sendResponse(List<Position> results);
}
