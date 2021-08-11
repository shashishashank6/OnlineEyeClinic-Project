package com.cg.service;

import java.util.ArrayList;
import java.util.Date;
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
	


	@Override
	public Report addReport(Report report) {
		// TODO Auto-generated method stub
		//patient=patientRepo.getById(patientId);
		//test=testRepo.getById(testId);
		//report.setPatient(patient);
		//report.setTest(test);
		
	     return reportRepo.saveAndFlush(report);
	}

	@Override
	public Report updateReport(Report report) {
		// TODO Auto-generated method stub
		return reportRepo.saveAndFlush(report);
	}

	@Override
	public Report removeReport(int reportId) {
		// TODO Auto-generated method stub
		Optional<Report> r=reportRepo.findById(reportId);
		reportRepo.deleteById(reportId);
		return r.get();
	}

	@Override
	public Report viewReport(int reportId) {
		// TODO Auto-generated method stub
         Optional<Report> r=reportRepo.findById(reportId);
         return r.get();
         
	}

	@Override
	public List<Report> viewReportsByDate(Date date) {
		// TODO Auto-generated method stub
		return reportRepo.findReportsByDate(date);
	}
	
}
