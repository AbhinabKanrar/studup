package com.studup.repository;

import org.springframework.data.repository.CrudRepository;

import com.studup.model.entity.UniversityCollege;

public interface UniversityCollegeRepository extends CrudRepository<UniversityCollege, Integer> {
	
	UniversityCollege findByUnivorcollegename(String univorcollegename);

}
