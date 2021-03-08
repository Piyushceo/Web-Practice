package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	 @Query(value="SELECT e FROM Employee e WHERE e.permanent = 1")
	 List<Employee> getAllPermanentEmployees();
	 
	 @Query(value="select avg(e.salary) from Employee e where e.department.id = :id")
	 double getAverageSalary(@Param("id") int id);
	 
	 @Query(value="select * from employee",nativeQuery = true)
	 List<Employee> getAllEmployeesNative();
}
