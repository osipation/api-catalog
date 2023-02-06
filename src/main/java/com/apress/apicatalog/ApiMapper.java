package com.apress.apicatalog;

import com.apress.apicatalog.dto.CountryDTO;
import com.apress.apicatalog.dto.CurrencyDTO;
import com.apress.apicatalog.dto.StateDTO;
import com.apress.apicatalog.entity.Country;
import com.apress.apicatalog.entity.Currency;
import com.apress.apicatalog.entity.State;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApiMapper {
    ApiMapper INSTANCE = Mappers.getMapper(ApiMapper.class);

    CurrencyDTO entityToDTO(Currency currency);

    Currency DTOToEntity(CurrencyDTO currencyDTO);

    CountryDTO entityToDTO(Country country);

    Country DTOToEntity(CountryDTO countryDTO);

    @Mapping(target="country", ignore = true)
    StateDTO stateToStateDTO(State state);

    State stateDTOToState(StateDTO state);


}
