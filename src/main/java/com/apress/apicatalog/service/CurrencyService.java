package com.apress.apicatalog.service;

import com.apress.apicatalog.ApiMapper;
import com.apress.apicatalog.dto.CurrencyDTO;
import com.apress.apicatalog.entity.Currency;
import com.apress.apicatalog.repository.CurrencyRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    private Validator validator;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository, Validator validator) {
        this.currencyRepository = currencyRepository;
        this.validator = validator;
    }

    public CurrencyDTO getById(Long id) {
        CurrencyDTO response = null;
        Optional<Currency> currency = currencyRepository.findById(id);

        if (currency.isPresent()) {
            response = ApiMapper.INSTANCE.entityToDTO(currency.get());
        }

        return response;
    }

    public CurrencyDTO save(CurrencyDTO currencyDTO) {
        return saveInformation(currencyDTO);
    }

    public CurrencyDTO update(CurrencyDTO currencyDTO) {
        return saveInformation(currencyDTO);
    }

    public void delete(Long id) {
        //TODO Auto-generated method stub
    }

    private CurrencyDTO saveInformation(CurrencyDTO currencyDTO) {
        Currency entity = ApiMapper.INSTANCE.DTOToEntity(currencyDTO);
        Set<ConstraintViolation<Currency>> violations = validator.validate(entity);
        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        Currency savedEntity = currencyRepository.save(entity);
        return ApiMapper.INSTANCE.entityToDTO(savedEntity);
    }
}
