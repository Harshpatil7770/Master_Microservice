package com.xoriant.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.model.CurrencyConversion;

@Repository
public interface CurrencyConversionDao extends JpaRepository<CurrencyConversion, Long> {

}
