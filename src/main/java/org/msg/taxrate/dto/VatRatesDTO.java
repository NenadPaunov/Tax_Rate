package org.msg.taxrate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VatRatesDTO {
	
	private String country;
	private String standard_rate;
	private double standard_rate_parsed;
	private String reduced_rate;
	private double reduced_rate_parsed;
	private String reduced_rate_alt;
	private String super_reduced_rate;
	private String parking_rate;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStandard_rate() {
		return standard_rate;
	}
	public void setStandard_rate(String standard_rate) {
		this.standard_rate = standard_rate;
	}
	public String getReduced_rate() {
		return reduced_rate;
	}
	public void setReduced_rate(String reduced_rate) {
		this.reduced_rate = reduced_rate;
	}
	public double getParsedReduced_rate() {
		return reduced_rate_parsed;
	}
	public void setParsedReduced_rate(double reduced_rate_parsed) {
		this.reduced_rate_parsed = reduced_rate_parsed;
	}
	public String getReduced_rate_alt() {
		return reduced_rate_alt;
	}
	public void setReduced_rate_alt(String reduced_rate_alt) {
		this.reduced_rate_alt = reduced_rate_alt;
	}

	public String getSuper_reduced_rate() {
		return super_reduced_rate;
	}
	public void setSuper_reduced_rate(String super_reduced_rate) {
		this.super_reduced_rate = super_reduced_rate;
	}
	public String getParking_rate() {
		return parking_rate;
	}
	public void setParking_rate(String parking_rate) {
		this.parking_rate = parking_rate;
	}
	
	public double getStandard_rate_parsed() {
		return standard_rate_parsed;
	}
	public void setStandard_rate_parsed(double standard_rate_parsed) {
		this.standard_rate_parsed = standard_rate_parsed;
	}
	public double getReduced_rate_parsed() {
		return reduced_rate_parsed;
	}
	public void setReduced_rate_parsed(double reduced_rate_parsed) {
		this.reduced_rate_parsed = reduced_rate_parsed;
	}
	public VatRatesDTO(String country, String standard_rate, String reduced_rate) {
		this.country = country;
		this.standard_rate = standard_rate;
		this.reduced_rate = reduced_rate;
	}
	
}
