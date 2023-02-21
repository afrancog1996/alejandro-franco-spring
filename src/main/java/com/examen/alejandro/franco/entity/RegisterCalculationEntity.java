package com.examen.alejandro.franco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "register_calculation")
public class RegisterCalculationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@NotNull
	@Column(name="calculation_year")
	public Integer calculation_year;
	@NotNull
	@Column(name="initial_Balance")
	public Double initial_Balance;
	@NotNull
	@Column(name="contribution")
	public Double contribution;
	@NotNull
	@Column(name="yield")
	public Double yield;
	@NotNull
	@Column(name="final_balance")
	public Double final_balance;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Integer getCalculation_year() {
		return calculation_year;
	}

	public void setCalculation_year(Integer calculation_year) {
		this.calculation_year = calculation_year;
	}

	public Double getInitial_Balance() {
		return initial_Balance;
	}

	public void setInitial_Balance(Double initial_Balance) {
		this.initial_Balance = initial_Balance;
	}

	public Double getContribution() {
		return contribution;
	}

	public void setContribution(Double contribution) {
		this.contribution = contribution;
	}

	public Double getYield() {
		return yield;
	}

	public void setYield(Double yield) {
		this.yield = yield;
	}

	public Double getFinal_balance() {
		return final_balance;
	}

	public void setFinal_balance(Double final_balance) {
		this.final_balance = final_balance;
	}

	public RegisterCalculationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public RegisterCalculationEntity(@NotNull Integer calculation_year, @NotNull Double initial_Balance,
			@NotNull Double contribution, @NotNull Double yield, @NotNull Double final_balance) {
		super();
		this.calculation_year = calculation_year;
		this.initial_Balance = initial_Balance;
		this.contribution = contribution;
		this.yield = yield;
		this.final_balance = final_balance;
	}

	@Override
	public String toString() {
		return "RegisterCalculationEntity [id=" + id + ", calculation_year=" + calculation_year + ", initial_Balance=" + initial_Balance
				+ ", contribution=" + contribution + ", yield=" + yield + ", final_balance=" + final_balance + "]";
	}
	
	

}
