package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.Exceptions.PatientIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.dao.IAdminRepo;
import com.cg.dao.IPatientRepo;
import com.cg.model.Admin;
import com.cg.model.Patient;
import com.cg.service.AdminServiceImpl;
import com.cg.service.PatientServiceImpl;


@SpringBootTest
@Transactional
class OnlineEyeClinicProjApplicationTests {

	@InjectMocks
	private AdminServiceImpl adminService;
	@InjectMocks
	private PatientServiceImpl patientService;
	@Mock
	private IAdminRepo adminRepo;
	@Mock
	private IPatientRepo patientRepo;
	@Test
	public void viewAllAdminsTest() {
		when(adminRepo.findAll()).thenReturn(Stream
				.of(new Admin(2,"Danile123","USa@123"), new Admin(1,"Huy1234","UKk@1234")).collect(Collectors.toList()));
		assertEquals(2, adminService.getAdmins().size());
	}
	@Test
	public void addAdminTest() throws UserNameAlreadyExistException
	{
		Admin admin = new Admin(2,"shashank","shashank123");
		when(adminRepo.saveAndFlush(admin)).thenReturn(admin);
		assertEquals(admin, adminService.addAdmin(admin));
	}
}

