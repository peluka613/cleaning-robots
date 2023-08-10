package com.poc.cleaningrobots.ports.input.web;

import com.poc.cleaningrobots.ports.input.model.FloorInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface WebInputPort {

    @PostMapping("/process")
    ResponseEntity<String> process(@RequestBody FloorInput input);
}
