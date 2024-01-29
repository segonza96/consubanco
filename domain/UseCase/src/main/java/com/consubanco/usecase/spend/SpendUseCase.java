package com.consubanco.usecase.spend;

import com.consubanco.entity.Spend;
import com.consubanco.ports.SpendDbPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<Spend> getSpends() {
        return Optional.ofNullable(spendRepository.getByLastMonth(LocalDate.now().getMonthValue()))
                .orElse(List.of());
    }

    public Map<String, List<Spend>> getSpendsGroupingByState() {
        return getSpends().stream()
                .collect(Collectors.toMap(Spend::getState, List::of, (list1, list2) -> Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList())));
    }
}
