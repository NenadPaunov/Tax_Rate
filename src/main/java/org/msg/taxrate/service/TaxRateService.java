package org.msg.taxrate.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.msg.taxrate.dto.VatRatesDTO;
import org.msg.taxrate.vo.TaxRateConstants;
import org.msg.taxrate.dto.VatRateDTO;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class TaxRateService {
	
private VatRateDTO vatRate;
	
	public VatRateDTO getVATRates() {
		if (vatRate == null) {
			try (InputStream inputStream = VatRateDTO.class.getResourceAsStream(TaxRateConstants.RATES_JSON_PATH);
					Reader reader = new InputStreamReader(inputStream)) {
				Gson gson = new Gson();
				vatRate = gson.fromJson(reader, VatRateDTO.class);
			} catch (Exception ex) {
				return null;
			}
		}
		return vatRate;
	}
	
	private double parseDouble(String value) {
	    try {
	        return Double.parseDouble(value);
	    } catch (NumberFormatException e) {
	        return Double.MAX_VALUE;
	    }
	}

	public List<String> getTopCountriesByStandardVatRate(Map<String, VatRatesDTO> rates, int numberOfCountries) {
	    List<Map.Entry<String, VatRatesDTO>> sortedRates = rates.entrySet().stream()
	            .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(vatRatesDTO -> parseDouble(vatRatesDTO.getStandard_rate()))))
	            .collect(Collectors.toList());
	    
	    Collections.reverse(sortedRates);
	    
	    return sortedRates.stream().map(Map.Entry::getValue).map(VatRatesDTO::getCountry)
	            .distinct().limit(numberOfCountries)
	            .collect(Collectors.toList());
	}

	public List<String> getTopCountriesByLowestReducedVatRate(Map<String, VatRatesDTO> rates, int numberOfCountries) {
	    List<Map.Entry<String, VatRatesDTO>> sortedRates = rates.entrySet().stream()
	            .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(vatRatesDTO -> parseDouble(vatRatesDTO.getReduced_rate()))))
	            .collect(Collectors.toList());
	    
	    return sortedRates.stream().map(Map.Entry::getValue).map(VatRatesDTO::getCountry)
	            .distinct().limit(numberOfCountries)
	            .collect(Collectors.toList());
	}

	public List<String> getCountriesWithLowestTax(Integer numberOfCountries) throws Exception {
		VatRateDTO vatRate = getVATRates();
		if (vatRate == null) {
			throw new Exception("Could not get data from rates.json");
		}
		return getTopCountriesByLowestReducedVatRate(vatRate.getRates(),
				numberOfCountries != null ? numberOfCountries : 3);

	}

	public List<String> getCountriesWithHighestTax(Integer numberOfCountries) throws Exception {
		VatRateDTO vatRate = getVATRates();
		if (vatRate == null) {
			throw new Exception("Could not get data from rates.json");
		}
		return getTopCountriesByStandardVatRate(vatRate.getRates(),
				numberOfCountries != null ? numberOfCountries : 3);
	}
}
