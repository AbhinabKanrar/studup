package com.studup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studup.model.entity.Degree;
import com.studup.model.entity.Department;

public interface DegreeRepository extends CrudRepository<Degree, Integer>{

	List<Degree> findByDegreeName(String degreeName);
	List<Degree> findByDepartment(Department department);
	
}
