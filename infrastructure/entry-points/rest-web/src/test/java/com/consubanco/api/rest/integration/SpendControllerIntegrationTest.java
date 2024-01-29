package com.consubanco.api.rest.integration;

import com.consubanco.api.rest.dto.ErrorResponseDto;
import com.consubanco.api.rest.dto.SpendDto;
import com.consubanco.api.rest.integration.util.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SpendControllerIntegrationTest extends BaseIntegrationTest {

    @Test
    public void should_respond_bad_request_due_incomplete_body() throws Exception {

        var expectedApiErrorResponse = ErrorResponseDto.builder()
                        .errors(Map.ofEntries(Map.entry("lastName", "must not be blank"),
                                        Map.entry("phoneNumber", "must not be null"),
                                        Map.entry("nameTask", "must not be blank"),
                                        Map.entry("endDate", "must not be null"),
                                        Map.entry("name", "must not be blank"),
                                        Map.entry( "description", "must not be blank"),
                                        Map.entry("state", "must not be null"),
                                        Map.entry("curp", "must not be blank"),
                                        Map.entry("rfc", "must not be blank"),
                                        Map.entry("email", "must not be blank"),
                                        Map.entry("initialDate", "must not be null")))
                        .message("Invalid Request contract")
                .build();

        mockMvc.perform(post("/spend")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(serializer.writeValueAsString(buildEmptySpendDto())))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(serializer.writeValueAsString(expectedApiErrorResponse)));
    }
    @Test
    public void should_respond_bad_request_due_missing_email_in_body() throws Exception {

        var expectedApiErrorResponse = ErrorResponseDto.builder()
                .errors(Map.ofEntries(Map.entry("email", "must not be blank")))
                .message("Invalid Request contract")
                .build();

        mockMvc.perform(post("/spend")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(serializer.writeValueAsString(buildSpendDtoWithOutEmail())))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(serializer.writeValueAsString(expectedApiErrorResponse)));
    }
    public static SpendDto buildEmptySpendDto() {
        return SpendDto.builder().build();
    }
    public static SpendDto buildSpendDtoWithOutEmail() {
        return SpendDto.builder()
                .name("sebas")
                .lastName("gonzalez")
                .curp("sadas")
                .rfc("fcasx")
                .description("csdcasa")
                .nameTask("acaasx")
                .phoneNumber(BigInteger.valueOf(30540449143L))
                .initialDate(OffsetDateTime.of(
                        2024, 1, 26, 9, 10, 40,
                        50000, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(
                        2024, 1, 26, 9, 10, 40,
                        50000, ZoneOffset.UTC))
                .state(true)
                .build();
    }
    public static SpendDto buildSpendDtoOK() {
        return SpendDto.builder()
                .name("sebas")
                .lastName("gonzalez")
                .curp("sadas")
                .rfc("fcasx")
                .description("csdcasa")
                .nameTask("acaasx")
                .email("sgonzalezj@unal.edu.co")
                .phoneNumber(BigInteger.valueOf(30540449143L))
                .initialDate(OffsetDateTime.of(
                        2024, 1, 26, 9, 10, 40,
                        50000, ZoneOffset.UTC))
                .endDate(OffsetDateTime.of(
                        2024, 1, 26, 9, 10, 40,
                        50000, ZoneOffset.UTC))
                .state(true)
                .build();
    }
}
