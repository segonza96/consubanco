package com.consubanco.ports;

import com.consubanco.entity.Spend;

import java.util.List;

public interface SpendDbPort {

    Spend save(Spend spend);
    Spend updateState(String rfc, String state);

    List<Spend> getByLastMonth(int month);
}
