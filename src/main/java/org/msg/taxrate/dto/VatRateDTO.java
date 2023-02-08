package org.msg.taxrate.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VatRateDTO {
	@JsonProperty("last_updated")
	private String last_updated;
	private String disclaimer;
	private Map<String, VatRatesDTO> rates;

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	
	public Map<String, VatRatesDTO> getRates() {
		return rates;
	}

	public void setRates(Map<String, VatRatesDTO> rates) {
		this.rates = rates;
	}

}
