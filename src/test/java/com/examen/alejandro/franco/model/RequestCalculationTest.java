package com.examen.alejandro.franco.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RequestCalculationTest {

	@Test
	public void testGetterAndSetters() {
		RequestCalculation request = new RequestCalculation();
		
		request.setInitial_investment((double) 5000);
		request.setAnnual_contribution((double) 3000);
		request.setAnnual_increase((double) 1);
		request.setYears_investment(5);
		request.setRate_performance((double) 21);

		assertEquals(5000, request.getInitial_investment());
		assertEquals(3000, request.getAnnual_contribution());
		assertEquals(1, request.getAnnual_increase());
		assertEquals(5, request.getYears_investment());
		assertEquals(21, request.getRate_performance());
	}

}
