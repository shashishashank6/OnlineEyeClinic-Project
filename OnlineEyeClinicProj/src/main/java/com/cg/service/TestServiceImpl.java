package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ITestRepo;
import com.cg.model.Test;

@Service
public class TestServiceImpl implements ITestService{
	@Autowired
private ITestRepo testRepo;

	@Override
	public Test addTest(Test test) {
		// TODO Auto-generated method stub
		return testRepo.saveAndFlush(test);
	}

	@Override
	public Test updateTest(Test test) {
		// TODO Auto-generated method stub
		return testRepo.saveAndFlush(test);
	}

	@Override
	public Test removeTest(int testId) {
		// TODO Auto-generated method stub
		Optional<Test> t=testRepo.findById(testId);
		testRepo.deleteById(testId);
		return t.get();
	}

	@Override
	public Test viewTest(int testId) {
		// TODO Auto-generated method stub
		Optional<Test> t=testRepo.findById(testId);
		return t.get();
	}

	@Override
	public List<Test> viewAllTests() {
		// TODO Auto-generated method stub
		return testRepo.findAll();
	}

	@Override
	public List<Test> viewTestsByDoctor(int doctorId) {
		// TODO Auto-generated method stub
		return testRepo.getTestsByDoctor(doctorId);
	}
	
}
