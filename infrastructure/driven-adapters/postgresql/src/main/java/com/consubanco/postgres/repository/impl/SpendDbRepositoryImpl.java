package com.consubanco.postgres.repository.impl;

import com.consubanco.entity.Spend;
import com.consubanco.exception.DatabaseException;
import com.consubanco.ports.SpendDbPort;
import com.consubanco.postgres.dto.mapper.SpendDtoDbMapper;
import com.consubanco.postgres.repository.SpendJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SpendDbRepositoryImpl implements SpendDbPort {

    private SpendJpaRepository spendJPARepository;
    private SpendDtoDbMapper mapper;
    Logger log = LoggerFactory.getLogger(SpendDbRepositoryImpl.class);
    @Autowired
    SpendDbRepositoryImpl(SpendJpaRepository spendJPARepository, SpendDtoDbMapper mapper) {
        this.spendJPARepository = spendJPARepository;
        this.mapper = mapper;
    }
    @Override
    public Spend save(Spend spend) {
       try {
           return Optional.ofNullable(spend)
                   .map(domainEntity -> mapper.toDtoDb(domainEntity))
                   .map(dto -> spendJPARepository.save(dto))
                   .map(savedDto -> mapper.toDomainEntity(savedDto))
                   .orElseThrow();
       } catch (Exception exception) {
           var errorMessage = String.format("Error caught trying to save spend on DB. %s", exception.getLocalizedMessage());
           log.error(errorMessage);
           throw new DatabaseException(errorMessage, exception);
       }
    }

    @Override
    public Spend updateState(String rfc, String state) {
        try {
            return Optional.ofNullable(rfc)
                    .map(dto -> spendJPARepository.updateState(rfc, state))
                    .map(updatedDto -> mapper.toDomainEntity(updatedDto))
                    .orElseThrow();
        }catch (Exception exception) {
            var errorMessage = String.format("Error caught trying to update spend state on DB. %s", exception.getLocalizedMessage());
            log.error(errorMessage);
            throw new DatabaseException(errorMessage, exception);
        }
    }

    @Override
    public List<Spend> getByLastMonth(int month) {
        try {
            return Optional.ofNullable(month)
                    .map(dto -> spendJPARepository.getByMonth(month))
                    .map(retrievedDto -> retrievedDto.stream()
                            .map(dto -> mapper.toDomainEntity(dto))
                            .collect(Collectors.toList())
                    )
                    .orElseThrow();
        }catch (Exception exception) {
            var errorMessage = String.format("Error caught trying to retry spends of the month: %s on DB. %s",month, exception.getLocalizedMessage());
            log.error(errorMessage);
            throw new DatabaseException(errorMessage, exception);
        }
    }
}
