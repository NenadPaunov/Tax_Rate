package org.msg.taxrate.controller;

import org.msg.taxrate.service.TaxRateService;
import org.msg.taxrate.vo.SwaggerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/taxRate")
public class TaxRateController {

	@Autowired
	private TaxRateService taxRateService;

	@ApiOperation(value = SwaggerConstants.LOWEST_REDUCED_VAT_VALUE, notes = SwaggerConstants.LOWEST_REDUCED_VAT_NOTES)
	@GetMapping({ "/lowestReduced/{numberOfCountries}", "/lowestReduced/" })
	public ResponseEntity<?> getCountriesWithLowestReducedVatRate(@PathVariable(required = false) Integer numberOfCountries)
			throws Exception {
		return ResponseEntity.ok().body(taxRateService.getCountriesWithLowestTax(numberOfCountries));
	}

	@ApiOperation(value = SwaggerConstants.HIGHEST_STANDARD_VAT_VALUE, notes = SwaggerConstants.LOWEST_REDUCED_VAT_NOTES)
	@GetMapping({ "/highestStandard/{numberOfCountries}", "/highestStandard/" })
	public ResponseEntity<?> getCountriesWithHighestStandardVatRate(@PathVariable(required = false) Integer numberOfCountries)
			throws Exception {
		return ResponseEntity.ok().body(taxRateService.getCountriesWithHighestTax(numberOfCountries));
	}
}
