package com.consubanco.postgres.repository;

import com.consubanco.postgres.dto.SpendDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendJPARepository extends JpaRepository<SpendDto, Long> {
    SpendDto save(SpendDto spendDto);
}
