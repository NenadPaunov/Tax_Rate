package org.msg.taxrate.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.msg.taxrate.dto.VatRateDTO;
import org.msg.taxrate.dto.VatRatesDTO;
@RunWith(MockitoJUnitRunner.class)
public class TaxRateServiceTest {

	@InjectMocks
private TaxRateService taxRateService;
	
	@Mock
	private VatRateDTO vatRateDTO;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		taxRateService = new TaxRateService();
	}
	
	@Test
	public void getCountriesByStandardVatRateTest() {
		Map<String, VatRatesDTO> rates = new HashMap<>();
		rates.put("country1", new VatRatesDTO("country1", "20.0", "15.0"));
		rates.put("country2", new VatRatesDTO("country2", "10.0", "5.0"));
		
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("country1");
		
		assertEquals(expectedResult, taxRateService.getTopCountriesByStandardVatRate(rates, 1));
	}
	
	@Test
	public void geCountriesByLowestReducedVatRateTest() {
		Map<String, VatRatesDTO> rates = new HashMap<>();
		rates.put("country1", new VatRatesDTO("country1", "20.0", "15.0"));
		rates.put("country2", new VatRatesDTO("country2", "10.0", "5.0"));
		
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("country2");
		
		assertEquals(expectedResult, taxRateService.getTopCountriesByLowestReducedVatRate(rates, 1));
	}
	
	@Test
	public void getpCountriesByStandardVatRate_EmptyMap_ReturnEmptyList() {
	    Map<String, VatRatesDTO> rates = new HashMap<>();
	    
	    List<String> result = taxRateService.getTopCountriesByStandardVatRate(rates, 1);
	    
	    assertTrue(result.isEmpty());
	}
	
	@Test
	public void getCountriesByStandardVatRate_MapWithMultipleElements_RequestedTopCountMoreThanMapSize_ReturnAllElements() {
	    Map<String, VatRatesDTO> rates = new HashMap<>();
	    rates.put("country1", new VatRatesDTO("country1", "20.0", "15.0"));
	    rates.put("country2", new VatRatesDTO("country2", "10.0", "5.0"));
	    
	    List<String> result = taxRateService.getTopCountriesByStandardVatRate(rates, 3);
	    
	    assertEquals(2, result.size());
	    assertTrue(result.contains("country1"));
	    assertTrue(result.contains("country2"));
	}
	
	@Test
	public void getCountriesByStandardVatRate_MultipleCountriesWithSameStandardVatRate_ReturnAllCountries() {
	    Map<String, VatRatesDTO> rates = new HashMap<>();
	    rates.put("country1", new VatRatesDTO("country1", "20.0", "15.0"));
	    rates.put("country2", new VatRatesDTO("country2", "20.0", "5.0"));
	    rates.put("country3", new VatRatesDTO("country3", "20.0", "10.0"));
	    
	    List<String> result = taxRateService.getTopCountriesByStandardVatRate(rates, 3);
	    
	    assertEquals(3, result.size());
	    assertTrue(result.contains("country1"));
	    assertTrue(result.contains("country2"));
	    assertTrue(result.contains("country3"));
	}
	
	@Test
	public void getCountriesByLowestReducedVatRate_EmptyMap_ReturnEmptyList() {
	    Map<String, VatRatesDTO> rates = new HashMap<>();
	    
	    List<String> result = taxRateService.getTopCountriesByLowestReducedVatRate(rates, 1);
	    
	    assertTrue(result.isEmpty());
	}
}
