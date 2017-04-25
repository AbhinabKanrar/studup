package com.studup.repository;

import org.springframework.data.repository.CrudRepository;

import com.studup.model.entity.StudentDegree;

public interface StudentDegreeRepository extends CrudRepository<StudentDegree, Integer> {

}
