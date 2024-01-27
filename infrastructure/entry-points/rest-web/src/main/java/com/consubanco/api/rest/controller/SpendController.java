package com.consubanco.api.rest.controller;

import com.consubanco.api.rest.dto.SpendDto;
import com.consubanco.api.rest.dto.mapper.SpendMapper;
import com.consubanco.entity.Spend;
import com.consubanco.usecase.spend.SpendUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@RestController
@RequestMapping("/spend")

public class SpendController {
    private final SpendUseCase useCase;
    private final SpendMapper mapper;
    @Autowired
    SpendController(SpendUseCase spendUseCase, SpendMapper mapper) {
        this.useCase = spendUseCase;
        this.mapper = mapper;
    }
    Logger log = LoggerFactory.getLogger(SpendController.class);
    @GetMapping
    public ResponseEntity<String> getSpend() {
        log.info("this is a logs!");
        log.info(useCase.log());
        return ResponseEntity.ok("works!");
    }
    @PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<Spend> createSpend(@RequestBody @Valid SpendDto spendDto) {
        return Optional.ofNullable(spendDto)
                .map(mapper::toDomainEntity)
                .map(useCase::createSpend)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }
}
