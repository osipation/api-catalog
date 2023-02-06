package com.apress.apicatalog.service;

import com.apress.apicatalog.ApiMapper;
import com.apress.apicatalog.dto.CountryDTO;
import com.apress.apicatalog.dto.CurrencyDTO;
import com.apress.apicatalog.entity.Country;
import com.apress.apicatalog.entity.Currency;
import com.apress.apicatalog.repository.CountryRepository;
import com.apress.apicatalog.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryDTO getById(Long id) {
        CountryDTO response = null;
        Optional<Country> country = countryRepository.findById(id);

        if (country.isPresent()) {
            response = ApiMapper.INSTANCE.entityToDTO(country.get());
        }

        return response;
    }

    public CountryDTO save(CountryDTO countryDTO) {
        return countryDTO;
    }

    public CountryDTO update(CountryDTO countryDTO) {
        return countryDTO;
    }

    public void delete(Long id) {
        //TODO Auto-generated method stub
    }
}
