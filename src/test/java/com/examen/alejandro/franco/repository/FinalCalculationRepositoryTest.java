package com.examen.alejandro.franco.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.examen.alejandro.franco.entity.FinalCalculationEntity;
import com.examen.alejandro.franco.entity.RegisterCalculationEntity;

@DataJpaTest
public class FinalCalculationRepositoryTest {

	@Autowired
	private FinalCalculationRepository finalCalculationRepository;

	@Test
	void testSaveFinalCalculation() {
		FinalCalculationEntity entity = new FinalCalculationEntity();
		List<RegisterCalculationEntity> register = new ArrayList<RegisterCalculationEntity>();

		register.add(new RegisterCalculationEntity(0, 0.0,0.0,0.0,0.0));
		entity.setFinal_amount((double) 0);
		entity.setReturn_investment((double) 0);
		entity.setRegisters_calculation(register);

		FinalCalculationEntity response = finalCalculationRepository.save(entity);

		assertThat(response).isNotNull();
	}

}
