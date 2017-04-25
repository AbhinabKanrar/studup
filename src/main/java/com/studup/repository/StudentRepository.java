package com.studup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studup.model.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findByEmailId(String emailId);
	
}
