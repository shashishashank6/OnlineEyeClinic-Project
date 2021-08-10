package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IPatientRepo;
import com.cg.dao.IReportRepo;
import com.cg.dao.ITestRepo;
import com.cg.model.Patient;
import com.cg.model.Report;
import com.cg.model.Test;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private IReportRepo reportRepo;
	
	@Autowired 
	private IPatientRepo patientRepo;
	
	@Autowired
	private ITestRepo testRepo;

	@Override
	public Report addReport(int patientId, int testId, Report report) {
		// TODO Auto-generated method stub
		Patient patient=new Patient();
		Test test=new Test();
		List<Report> reportList=new ArrayList<Report>();
		patient=patientRepo.getById(patientId);
		test=testRepo.getById(testId);
		//report.setPatient(patient);
		//report.setTest(test);
		reportList.add(report);
		return report;
	}

	@Override
	public Report updateReport(Report report) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report removeReport(int reportId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report viewReport(int reportId) {
		// TODO Auto-generated method stub
         Optional<Report> r=reportRepo.findById(reportId);
         return r.get();
         
	}

	@Override
	public List<Report> viewReportsByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
