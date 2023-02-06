package com.apress.apicatalog.service;

import com.apress.apicatalog.ApiMapper;
import com.apress.apicatalog.dto.CurrencyDTO;
import com.apress.apicatalog.entity.Currency;
import com.apress.apicatalog.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
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
        return currencyDTO;
    }

    public CurrencyDTO update(CurrencyDTO currencyDTO) {
        return currencyDTO;
    }

    public void delete(Long id) {
        //TODO Auto-generated method stub
    }
}
