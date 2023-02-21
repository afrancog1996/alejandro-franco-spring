package com.examen.alejandro.franco.model;

public class RequestCalculation {

	public Double initial_investment;
	public Double annual_contribution;
	public Double annual_increase;
	public Integer years_investment;
	public Double rate_performance;

	public Double getInitial_investment() {
		return initial_investment;
	}

	public void setInitial_investment(Double initial_investment) {
		this.initial_investment = initial_investment;
	}

	public Double getAnnual_contribution() {
		return annual_contribution;
	}

	public void setAnnual_contribution(Double annual_contribution) {
		this.annual_contribution = annual_contribution;
	}

	public Double getAnnual_increase() {
		return annual_increase;
	}

	public void setAnnual_increase(Double annual_increase) {
		this.annual_increase = annual_increase;
	}

	public Integer getYears_investment() {
		return years_investment;
	}

	public void setYears_investment(Integer years_investment) {
		this.years_investment = years_investment;
	}

	public Double getRate_performance() {
		return rate_performance;
	}

	public void setRate_performance(Double rate_performance) {
		this.rate_performance = rate_performance;
	}

	public RequestCalculation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
