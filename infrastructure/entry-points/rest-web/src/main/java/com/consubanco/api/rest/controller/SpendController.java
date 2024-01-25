package com.consubanco.api.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/spend")

public class SpendController {
    Logger log = LoggerFactory.getLogger(SpendController.class);
    @GetMapping
    public ResponseEntity<String> getSpend() {
        log.info("this is a logs!");
        return ResponseEntity.ok("works!");
    }
}
