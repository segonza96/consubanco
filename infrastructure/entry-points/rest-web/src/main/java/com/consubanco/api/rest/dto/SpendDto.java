package com.consubanco.api.rest.dto;

import com.consubanco.entity.State;
import com.consubanco.entity.validators.ValueOfEnum;
import com.consubanco.entity.validators.ValueOfEnumValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpendDto {
    @NotBlank
    @JsonProperty("name")
    private String name;
    @NotBlank
    @JsonProperty("last_name")
    private String lastName;
    @NotNull
    @JsonProperty("phone_number")
    private BigInteger phoneNumber;
    @NotBlank
    @Email(message = "Email should be valid")
    @JsonProperty("email")
    private String email;
    @NotBlank
    @JsonProperty("curp")
    private String curp;
    @NotBlank
    @JsonProperty("rfc")
    private String rfc;
    @NotBlank
    @JsonProperty("name_task")
    private String nameTask;
    @NotBlank
    @JsonProperty("description")
    private String description;
    @NotNull
    @JsonProperty("initial_date")
    private OffsetDateTime initialDate;
    @NotNull
    @JsonProperty("end_date")
    private OffsetDateTime endDate;
    @NotBlank
    @JsonProperty("state")
    @ValueOfEnum(enumClass = State.class)
    private String state;

}
