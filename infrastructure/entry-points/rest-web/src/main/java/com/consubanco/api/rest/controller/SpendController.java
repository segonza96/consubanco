package com.consubanco.api.rest.controller;

import com.consubanco.api.rest.dto.ErrorResponseDto;
import com.consubanco.api.rest.dto.SpendDto;
import com.consubanco.api.rest.dto.mapper.SpendMapper;
import com.consubanco.entity.Spend;
import com.consubanco.exception.BadRequestException;
import com.consubanco.usecase.spend.SpendUseCase;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/spend")
public class SpendController {
    private final SpendUseCase useCase;
    private final SpendMapper mapper;
    private final Validator validator;
    @Autowired
    SpendController(SpendUseCase spendUseCase, SpendMapper mapper, Validator validator) {
        this.useCase = spendUseCase;
        this.mapper = mapper;
        this.validator = validator;
    }
    Logger log = LoggerFactory.getLogger(SpendController.class);
    @PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<Spend> createSpend(@RequestBody @Valid SpendDto spendDto) {
        return Optional.ofNullable(spendDto)
                .map(mapper::toDomainEntity)
                .map(useCase::createSpend)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }
    @PatchMapping(value = "/status/{rfc}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Spend> updateStatusSpend(@PathVariable("rfc") String rfc, @RequestBody SpendDto dto) {

        return Optional.ofNullable(dto)
                .filter(nonNullDto -> validator.validateProperty(dto, "state").isEmpty())
                .map(validDto -> useCase.updateStateSpend(rfc, dto.getState()))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BadRequestException("Invalid parameters in update state request"));
    }

    @GetMapping
    public ResponseEntity<List<Spend>> getSpends() {
            return Optional.ofNullable(useCase.getSpends())
                    .filter(spendList -> !spendList.isEmpty())
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.noContent().build());
    }
    @GetMapping(value = "/groupedByState")
    public ResponseEntity<Map<String, List<Spend>>> getGroupedSpends() {
            return Optional.ofNullable(useCase.getSpendsGroupingByState())
                    .filter(spendList -> !spendList.isEmpty())
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
