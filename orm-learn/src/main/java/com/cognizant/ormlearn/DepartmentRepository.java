package com.cognizant.ormlearn;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
