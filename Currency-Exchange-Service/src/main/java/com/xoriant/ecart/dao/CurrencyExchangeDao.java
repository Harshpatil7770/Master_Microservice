package com.xoriant.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeDao extends JpaRepository<CurrencyExchange, Long> {

	List<CurrencyExchange> findByFromAndTo(String from, String to);

}
