package com.consubanco.entity;

import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Integer phoneNumber;
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
    private Date initialDate;
    /**
     * (opcional fecha )
     */

    private Date endDate;
    /**
     * (pagado / pendiente )
     */
    private Boolean state;
}
