package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

//import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

//import com.cg.Exceptions.PatientIdNotFoundException;
import com.cg.Exceptions.UserNameAlreadyExistException;
import com.cg.dao.IAdminRepo;
import com.cg.dao.IPatientRepo;
import com.cg.model.AdminEntity;
import com.cg.model.Patient;
//import com.cg.model.Patient;
import com.cg.service.AdminServiceImpl;
import com.cg.service.PatientServiceImpl;


@SpringBootTest
//@Transactional
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
				.of(new AdminEntity(2,"Danile123","USa@123"), new AdminEntity(1,"Huy1234","UKk@1234")).collect(Collectors.toList()));
		assertEquals(2, adminService.getAdmins().size());
	}
	@Test
	public void addAdminTest() throws UserNameAlreadyExistException
	{
		AdminEntity admin = new AdminEntity(2,"shashank","shashank123");
		when(adminRepo.saveAndFlush(admin)).thenReturn(admin);
		assertEquals(admin, adminService.addAdmin(admin));
	}
	@Test
	public void getAllPatientsTest() throws ParseException {
		DateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
		Date d1=df.parse("06-Aug-1997");
		Date d2=df.parse("12-Aug-1996");
		when(patientRepo.findAll()).thenReturn(Stream
				.of(new Patient(1,"abc",24,983746352,"abc@gmail.com",d1,"abc@6","abc123","Hyderabad"),
						new Patient(2,"def",25,983746123,"def@gmail.com",d2,"def@12","def123","Chennai")
						).collect(Collectors.toList()));
		assertEquals(2, patientService.viewAllPatients().size());
	}
	@Test
	public void addPatientTest() throws ParseException,UserNameAlreadyExistException {
		DateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
		Date d=df.parse("10-Jun-1996");
		Patient patient=new Patient(5,"shashank",25,983542705,"shashank@gmail.com",d,"shashank@10","shashank123","Hyderabad");
		when(patientRepo.saveAndFlush(patient)).thenReturn(patient);
		assertEquals(patient, patientService.addPatient(patient));
	}

	@Autowired
	IPatientRepo repo;
	@Autowired
	IAdminRepo ar;
	@Test
	public void testAdminId() {
		int id=1;
		assertNotNull(ar.findById(id).get());
	}
	@Test
	public void testId() {
		int id=14;
		assertNotNull(repo.findById(id).get());
	}
}

