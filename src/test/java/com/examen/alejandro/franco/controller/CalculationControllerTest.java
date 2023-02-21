package com.examen.alejandro.franco.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.examen.alejandro.franco.model.RequestCalculation;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class CalculationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void postCalculateInvestment() throws Exception {

		RequestCalculation request = new RequestCalculation();

		request.setInitial_investment((double) 5000);
		request.setAnnual_contribution((double) 3000);
		request.setAnnual_increase((double) 1);
		request.setYears_investment(5);
		request.setRate_performance((double) 21);

		String json = mapper.writeValueAsString(request);

		ResultActions response = mockMvc
				.perform(post("/calculation/").contentType(MediaType.APPLICATION_JSON).content(json));
		
		response.andDo(print()).andExpect(status().isOk());

	}

}
