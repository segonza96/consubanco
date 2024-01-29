package com.consubanco.usecase.spend;

import com.consubanco.entity.Spend;
import com.consubanco.ports.SpendDbPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SpendUseCase {
    private final SpendDbPort spendRepository;

    SpendUseCase(@Autowired SpendDbPort spendRepository) {
        this.spendRepository = spendRepository;
    }

    public Spend createSpend(Spend spend) {
        return spendRepository.save(spend);
    }

    public Spend updateStateSpend(String rfc, String state) {
        return spendRepository.updateState(rfc, state);
    }
}
