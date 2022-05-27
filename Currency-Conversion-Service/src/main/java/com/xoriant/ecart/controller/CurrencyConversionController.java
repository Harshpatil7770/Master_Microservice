package com.xoriant.ecart.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dao.CurrencyConversionDao;
import com.xoriant.ecart.model.CurrencyConversion;
import com.xoriant.ecart.model.CurrencyExchange;
import com.xoriant.ecart.service.CurrencyExchangeProxy;

@RestController
@RequestMapping("/api/currency-conversion")
public class CurrencyConversionController {

	@Autowired
	CurrencyConversionDao currencyConversionDao;

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("/{id}/quantity/{quantity}")
	public CurrencyConversion findById(@PathVariable long id, @PathVariable BigDecimal quantity) {

		Optional<CurrencyExchange> exchangeCurrency = currencyExchangeProxy.findById(id);

		CurrencyConversion currencyConversion = new CurrencyConversion(id, exchangeCurrency.get().getFrom(),
				exchangeCurrency.get().getTo(), exchangeCurrency.get().getMultipleConversion(), quantity,
				quantity.multiply(exchangeCurrency.get().getMultipleConversion()),
				exchangeCurrency.get().getEnvironment());

		currencyConversionDao.save(currencyConversion);
		return currencyConversion;

	}
}
