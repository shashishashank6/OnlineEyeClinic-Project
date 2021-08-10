package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Doctor;
import com.cg.model.Report;
import com.cg.service.IReportService;

@RestController
@RequestMapping("/report/api/v1")
public class ReportController {

	@Autowired
	private IReportService rs;
	@PostMapping("/create/{patientId}/{testId}")
	public ResponseEntity<Report> createReport(@PathVariable int patientId,@PathVariable int testId,@RequestBody Report report) 
	{
		return new ResponseEntity<Report>(rs.addReport(patientId, testId, report),HttpStatus.CREATED);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/reports/{reportId}")
	public ResponseEntity<Report> findReport(@PathVariable("reportId")Integer reportId){
		Report report=rs.viewReport(reportId);
		if(report==null) {
			return new ResponseEntity("Sorry! report not found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}
}
