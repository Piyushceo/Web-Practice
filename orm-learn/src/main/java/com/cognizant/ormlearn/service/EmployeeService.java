package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.EmployeeRepository;
import com.cognizant.ormlearn.model.Employee;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	 @Transactional
	 public Employee get(int id) {
		 LOGGER.info("Start");
		 return this.employeeRepository.findById(id).get();
	 }
	 
	 @Transactional
	 public void save(Employee employee) {
		 LOGGER.info("Start");
		 employeeRepository.save(employee);
		 LOGGER.info("End");
	 }

	 @Transactional
	public List<Employee> getAllPermanentEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepository.findAll();
	}
	 
}
