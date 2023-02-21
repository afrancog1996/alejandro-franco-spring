package com.examen.alejandro.franco.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "final_calculation")
public class FinalCalculationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Column(name = "initial_investment")
	public Double final_amount;
	@Column(name = "return_investment")
	public Double return_investment;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "register_id")
	List<RegisterCalculationEntity> registers_calculation = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getFinal_amount() {
		return final_amount;
	}

	public void setFinal_amount(Double initial_investment) {
		this.final_amount = initial_investment;
	}

	public Double getReturn_investment() {
		return return_investment;
	}

	public void setReturn_investment(Double return_investment) {
		this.return_investment = return_investment;
	}

	public List<RegisterCalculationEntity> getRegisters_calculation() {
		return registers_calculation;
	}

	public void setRegisters_calculation(List<RegisterCalculationEntity> registers_calculation) {
		this.registers_calculation = registers_calculation;
	}

	public FinalCalculationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinalCalculationEntity(Double initial_investment, Double return_investment,
			List<RegisterCalculationEntity> registers_calculation) {
		super();
		this.final_amount = initial_investment;
		this.return_investment = return_investment;
		this.registers_calculation = registers_calculation;
	}

	@Override
	public String toString() {
		return "FinalCalculationEntity [id=" + id + ", initial_investment=" + final_amount
				+ ", return_investment=" + return_investment + ", registers_calculation=" + registers_calculation
				+ ", getId()=" + getId() + ", getInitial_investment()=" + getFinal_amount()
				+ ", getReturn_investment()=" + getReturn_investment() + ", getRegisters_calculation()="
				+ getRegisters_calculation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	

}
