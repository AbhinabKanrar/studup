package com.studup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studup.model.entity.Department;
import com.studup.model.entity.UniversityCollege;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

	List<Department> findByUniversityCollege(UniversityCollege universityCollege);
	
	List<Department> findByDepttname(String Depttname);
	
}
