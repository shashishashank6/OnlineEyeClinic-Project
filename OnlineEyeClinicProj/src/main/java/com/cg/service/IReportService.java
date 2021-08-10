package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Report;

@Service
public interface IReportService {
	//method for creating a report
	public Report addReport(int patientId, int testId, Report report);
	//method for updating a report
    public Report updateReport(Report report);
  //method for deleting a report
    public Report removeReport(int reportId);
  //method for viewing report by individual id
    public Report viewReport(int reportId);
  //method for viewing the report by date
    public List<Report> viewReportsByDate(String date);
}
