package com.consubanco.entity.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Objects;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence> {
    private Class<? extends Enum<?>> enumClass;
    @Override
    public void initialize(ValueOfEnum annotation) {
        enumClass = annotation.enumClass();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return isValid(enumClass, value);
    }
    public static boolean isValid(Class<? extends Enum<?>> enumClass, CharSequence value) {

        return Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::name)
                .filter(names -> Objects.nonNull(value))
                .anyMatch(nameEnum -> nameEnum.equalsIgnoreCase(value.toString()));
    }
}
