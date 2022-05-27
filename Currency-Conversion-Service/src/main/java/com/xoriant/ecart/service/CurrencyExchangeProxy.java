package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.ecart.model.CurrencyExchange;

@FeignClient(name = "currency-exchange", url = "localhost:9090/api/currency-exchange")
public interface CurrencyExchangeProxy {

	@PostMapping("/save")
	public CurrencyExchange saveCurrenyExchangeDetails(@RequestBody CurrencyExchange currencyExchange);

	@GetMapping("/from/{from}/to/{to}")
	public List<CurrencyExchange> getCurrencyExchangeDetails(@PathVariable String from, @PathVariable String to);

	@GetMapping("/{id}")
	public Optional<CurrencyExchange> findById(@PathVariable long id);
}
