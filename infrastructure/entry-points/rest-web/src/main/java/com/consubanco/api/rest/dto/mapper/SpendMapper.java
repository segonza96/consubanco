package com.consubanco.api.rest.dto.mapper;

import com.consubanco.api.rest.dto.SpendDto;
import com.consubanco.entity.Spend;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SpendMapper {
    Spend toDomainEntity(SpendDto spendDto);
}
