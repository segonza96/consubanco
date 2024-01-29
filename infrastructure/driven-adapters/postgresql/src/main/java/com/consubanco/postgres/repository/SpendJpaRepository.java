package com.consubanco.postgres.repository;

import com.consubanco.postgres.dto.SpendDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpendJpaRepository extends JpaRepository<SpendDto, Long> {
    SpendDto save(SpendDto spendDto);
    @Query(value = "UPDATE consubanco.pruebatecnica.spend SET state = :state WHERE rfc = :rfc RETURNING *", nativeQuery = true)
    SpendDto updateState(@Param("rfc") String rfc,
                         @Param("state") String state);

    @Query(value = "SELECT * from consubanco.pruebatecnica.spend WHERE EXTRACT(MONTH FROM initial_date) = :month", nativeQuery = true)
    List<SpendDto> getByMonth(@Param("month") int month);
}
