package com.cg.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.Exceptions.DoctorIdNotFoundException;
import com.cg.Exceptions.PatientIdNotFoundException;
import com.cg.Exceptions.ReportIdNotFoundException;
import com.cg.Exceptions.TestIdNotFoundException;
import com.cg.model.Report;
import com.cg.model.Spectacles;
import com.cg.model.Test;

@Service
public interface IReportService {
	//method for creating a report
	public Report addReport(Report report);
	//method for updating a report
    public Report updateReport(Report report);
  //method for deleting a report
    public Report removeReport(int reportId)throws ReportIdNotFoundException;
  //method for viewing report by individual id
    public Report viewReport(int reportId)throws ReportIdNotFoundException;
  //method for viewing the report by date
    public List<Report> viewReportsByDate(Date date);
    //viewing all spectacles
    public List<Spectacles> viewSpectacles();
    public List<Report> getAllReports();
    public List<Report> viewReportByTest(int testId)throws TestIdNotFoundException;
    public List<Report> viewReportByPatient(int patientId) throws PatientIdNotFoundException;
}
