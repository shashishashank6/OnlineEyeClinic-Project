package com.cg.service;

import java.util.List;

import com.cg.model.Test;

public interface ITestService {
public Test addTest(Test test);
public Test updateTest(Test test);
public Test removeTest(int testId);
public Test viewTest(int testId);
public List<Test> viewAllTests();
public List<Test> viewTestsByDoctor(int doctorId);
}
