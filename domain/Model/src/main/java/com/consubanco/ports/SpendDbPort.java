package com.consubanco.ports;

import com.consubanco.entity.Spend;

public interface SpendDbPort {

    Spend save(Spend spend);
    Spend updateState(String rfc, String state);
}
