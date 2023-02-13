package com.apress.apicatalog.repository;

import com.apress.apicatalog.entity.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StateRepository extends CrudRepository<State, Long> {
    List<State> findAllByCountryId(Long id);
}
