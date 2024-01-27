package com.consubanco.postgres.dto.mapper;

import com.consubanco.entity.Spend;
import com.consubanco.postgres.dto.SpendDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SpendDtoDbMapper {
    Spend toDomainEntity(SpendDto spendDto);
    SpendDto toDtoDb(Spend spend);

}
