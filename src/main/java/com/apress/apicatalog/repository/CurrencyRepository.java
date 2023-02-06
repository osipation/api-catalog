package com.apress.apicatalog.repository;

import com.apress.apicatalog.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {

}
