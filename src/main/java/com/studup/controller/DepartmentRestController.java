package com.studup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studup.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentRestController {
	
	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping(value = "/v0.1/ListDepartmentOfUniversity/{universityCollegeName}", headers = "Accept=application/xml", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> listDepartmentOfUniversity(@PathVariable("universityCollegeName") String universityCollegeName) throws JsonProcessingException{
		return new ResponseEntity<String>(mapper.writeValueAsString(departmentService.findByUniversityCollege(universityCollegeName)),HttpStatus.OK);
	}
	
}
