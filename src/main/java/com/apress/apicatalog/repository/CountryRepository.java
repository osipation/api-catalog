package com.apress.apicatalog.repository;

import com.apress.apicatalog.entity.Country;
import com.apress.apicatalog.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
