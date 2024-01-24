package com.consubanco.api.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spend")
public class SpendController {

    @GetMapping
    public ResponseEntity<String> getSpend() {
        return ResponseEntity.ok("works!");
    }
}
