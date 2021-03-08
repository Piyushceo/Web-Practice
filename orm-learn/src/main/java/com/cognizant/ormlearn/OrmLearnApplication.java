package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory; 
@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService; 
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	 private static void testGetAllCountries() {

		 LOGGER.info("Start");
		 List<Country> countries = countryService.getAllCountries();
		 LOGGER.debug("countries={}", countries);
		 LOGGER.info("End");

	}
	 
    private static void testGetEmployee()
    {
    	 LOGGER.info("Start");
    	 Employee employee = employeeService.get(1);
    	 LOGGER.debug("Employee:{}", employee);
    	 LOGGER.debug("Department:{}", employee.getDepartment());
    	 LOGGER.debug("Skills:{}",employee.getSkillList());
    	 LOGGER.info("End");
    }
    
    public static void testAddSkillToEmployee()
    {
    	LOGGER.info("start");
		int employeeId = 1;
		Employee employee = employeeService.get(employeeId);
		Set<Skill> skills = new HashSet<Skill>();
		Skill skill = new Skill("JAVA");
		Skill skill2 = new Skill("MySQL");
		skills.add(skill);
		skills.add(skill2);
		skillService.save(skill);
		skillService.save(skill2);
		employee.setSkillList(skills);
		employeeService.save(employee);
		LOGGER.info("end");
    }
    
    private static void testAddDepartment()
    {
    	Department department = new Department();
    	department.setName("PAT");
    	department.setId(1);
    	departmentService.save(department);
    }
    private static void testAddEmployee()
    {
    	Employee employee = new Employee();
    	employee.setName("Piyush");
    	employee.setDepartment(departmentService.get(1));
    	employee.setPermanent(true);
    	employee.setSalary(25000.0);
    	
    	employeeService.save(employee);
    }
    
    public static void testUpdateEmployee()
    {
    	 LOGGER.info("Start");
    	 Employee employee = employeeService.get(1);
    	 Department department = departmentService.get(2);
    	 
    	 employee.setDepartment(department);
    	 LOGGER.debug("Employee:{}", employee);
    	 employeeService.save(employee);
    	 LOGGER.debug("Department:{}", employee.getDepartment());
    	 LOGGER.info("End");
    }
    
    public static void testGetDepartment()
    {
   	    LOGGER.info("Start");
    	Department department = departmentService.get(1);
   	 	LOGGER.debug("Employee:{}", department);
   	 	LOGGER.info("End");
    }
    
	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main"); 
		
		 ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		 countryService = context.getBean(CountryService.class); 
		 employeeService = context.getBean(EmployeeService.class); 
		 departmentService = context.getBean(DepartmentService.class); 
		 skillService = context.getBean(SkillService.class);
		 /**
		  * To Test countries comment out below
		  */
		 //testGetAllCountries();
		 
		 /**
		  * To test employees comment out below
		  */
		// testAddDepartment();
		 testAddEmployee();
		 testGetEmployee();
		 testUpdateEmployee();
		 testGetDepartment();
		 testAddSkillToEmployee();
	}

}
