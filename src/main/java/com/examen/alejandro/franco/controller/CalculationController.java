package com.examen.alejandro.franco.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.alejandro.franco.entity.FinalCalculationEntity;
import com.examen.alejandro.franco.entity.RegisterCalculationEntity;
import com.examen.alejandro.franco.model.RequestCalculation;
import com.examen.alejandro.franco.repository.FinalCalculationRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/calculation")
public class CalculationController {

	@Autowired
	private FinalCalculationRepository fin_calculation_repository;

	@PostMapping("/")
	public ResponseEntity<FinalCalculationEntity> calculateInvestment(
			@RequestBody @Valid RequestCalculation requestBody) {

		return ResponseEntity.ok(CalculateCompoundInterest(requestBody));
	}

	private FinalCalculationEntity CalculateCompoundInterest(RequestCalculation request) {

		double initial_amount = request.getInitial_investment();
		double contribution = request.getAnnual_contribution();
		double investment_earnings, final_amount, last_amount = 0;
		double performance = request.getRate_performance() / 100;

		List<RegisterCalculationEntity> results = new ArrayList<>();
		FinalCalculationEntity response = new FinalCalculationEntity();

		for (int i = 1; i <= request.getYears_investment(); i++) {

			double current_performance = (initial_amount + contribution) * performance;
			last_amount = initial_amount + contribution + current_performance;
			
			results.add(new RegisterCalculationEntity(request.getYears_investment(), RoundedDouble(initial_amount), RoundedDouble(contribution),
					RoundedDouble(current_performance), RoundedDouble(last_amount)));
			initial_amount = last_amount;
			contribution = contribution * (1 + request.getAnnual_increase() / 100);

		}

		final_amount = initial_amount;
		investment_earnings = last_amount - request.getInitial_investment()
				- (contribution * request.getYears_investment());

		response.setFinal_amount(RoundedDouble(final_amount));
		response.setReturn_investment(RoundedDouble(investment_earnings));
		response.setRegisters_calculation(results);

		fin_calculation_repository.save(response);

		return response;
	}
	
	
	private Double RoundedDouble(Double number) {
		BigDecimal bd = new BigDecimal(number);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
