package com.xoriant.ecart.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dao.CurrencyExchangeDao;
import com.xoriant.ecart.model.CurrencyExchange;

@RestController
@RequestMapping("/api/currency-exchange")
public class CurrencyController {

	@Autowired
	Environment environment;

	@Autowired
	private CurrencyExchangeDao exchangeDao;

	@GetMapping("/from/{from}/to/{to}")
	public List<CurrencyExchange> getCurrencyExchangeDetails(@PathVariable String from, @PathVariable String to) {
//		CurrencyExchange currencyExchange = new CurrencyExchange(1001, from, to, BigDecimal.valueOf(100), to);
//		String port = environment.getProperty("local.server.port");
//		currencyExchange.setEnvironment(port);
		// List<CurrencyExchange> currencyExchangeLists = new
		// ArrayList<CurrencyExchange>();

		List<CurrencyExchange> currencyExchangeLists = exchangeDao.findByFromAndTo(from, to);
		if (currencyExchangeLists.isEmpty() || currencyExchangeLists == null) {
			throw new RuntimeException("Not Present Records In between " + from + " " + to);
		}

		return currencyExchangeLists;

	}

	@PostMapping("/save")
	public CurrencyExchange saveCurrenyExchangeDetails(@RequestBody CurrencyExchange currencyExchange) {
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return exchangeDao.save(currencyExchange);
	}

	@GetMapping("/{id}")
	public Optional<CurrencyExchange> findById(@PathVariable long id) {
		Optional<CurrencyExchange> currencyExchange = exchangeDao.findById(id);
		return currencyExchange;
	}
}
