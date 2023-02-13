package com.apress.apicatalog.service;

import com.apress.apicatalog.ApiMapper;
import com.apress.apicatalog.dto.CountryDTO;
import com.apress.apicatalog.entity.Country;
import com.apress.apicatalog.entity.State;
import com.apress.apicatalog.repository.CountryRepository;
import com.apress.apicatalog.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository, StateRepository stateRepository) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
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

    @Transactional
    public void delete(Long id) throws InterruptedException{
        Optional<Country> country = countryRepository.findById(id);
        List<State> states = stateRepository.findAllByCountryId(id);
        if (country.isPresent()) {
            country.get().setEnabled(Boolean.FALSE);
            countryRepository.save(country.get());

            Thread.sleep(2000L);//for testing isolation problems

            for (State state: states) {
                state.setEnabled(Boolean.FALSE);
                stateRepository.save(state);
            }
        }
    }
}
