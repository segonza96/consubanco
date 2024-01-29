package com.consubanco.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponseDto<T> {
    private T errors;
    private String message;
}
