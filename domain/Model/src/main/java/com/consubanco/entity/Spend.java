package com.consubanco.entity;

import com.consubanco.entity.validators.ValueOfEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.OffsetDateTime;
@Data
@NoArgsConstructor
public class Spend {
    /**
     * (obligatorio - solo caracteres )
     */
    @NotBlank
    private String name;
    /**
    (obligatorio - solo caracteres )
     * */
    @NotBlank
    private String lastName;
    /**
     *  (obligatorio - solo números )
     */
    @NotNull
    private BigInteger phoneNumber;
    /**
     * (obligatorio - validar que sea un email )
     */
    @Email(message = "Email should be valid")
    @NotBlank
    private String email;
    /**
     *  (obligatorio - alfanumérico )
     */
    @NotBlank
    private String curp;

    /**
     * rfc (obligatorio - alfanumérico )
     */
    @NotBlank
    private String rfc;
    /**
     * nombre de la tarea (obligatorio - solo caracteres )
     */
    @NotBlank
    private String nameTask;

    /**
     * (opcional - solo caracteres )
      */
    private String description;
    /**
     * (opcional - fecha )
     */
    private OffsetDateTime initialDate;
    /**
     * (opcional fecha )
     */

    private OffsetDateTime endDate;
    /**
     * (pagado / pendiente )
     */
    @ValueOfEnum(enumClass = State.class)
    private String state;
}
