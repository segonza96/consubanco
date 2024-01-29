package com.consubanco.postgres.repository;

import com.consubanco.postgres.dto.SpendDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendJPARepository extends JpaRepository<SpendDto, Long> {
    SpendDto save(SpendDto spendDto);
    @Query(value = "UPDATE consubanco.pruebatecnica.spend SET state = :state WHERE rfc = :rfc RETURNING *", nativeQuery = true)
    SpendDto updateState(@Param("rfc") String rfc,
                         @Param("state") String state);
}
