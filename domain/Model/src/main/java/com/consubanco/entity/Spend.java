package com.consubanco.entity;

import jakarta.validation.constraints.Email;
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
    private String name;
    /**
    (obligatorio - solo caracteres )
     * */
    private String lastName;
    /**
     *  (obligatorio - solo números )
     */
    private BigInteger phoneNumber;
    /**
     * (obligatorio - validar que sea un email )
     */
    @Email(message = "Email should be valid")
    private String email;
    /**
     *  (obligatorio - alfanumérico )
     */

    private String curp;

    /**
     * rfc (obligatorio - alfanumérico )
     */
    private String rfc;
    /**
     * nombre de la tarea (obligatorio - solo caracteres )
     */
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
    private Boolean state;
}
