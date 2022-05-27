package com.xoriant.ecart.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
	private String to;

	private BigDecimal multipleConversion;

	private String environment;

	public CurrencyExchange() {
		super();
	}

	public CurrencyExchange(long id, String from, String to, BigDecimal multipleConversion, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.multipleConversion = multipleConversion;
		this.environment = environment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getMultipleConversion() {
		return multipleConversion;
	}

	public void setMultipleConversion(BigDecimal multipleConversion) {
		this.multipleConversion = multipleConversion;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to=" + to + ", multipleConversion="
				+ multipleConversion + ", environment=" + environment + "]";
	}

}
