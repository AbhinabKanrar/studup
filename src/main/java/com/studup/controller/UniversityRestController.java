package com.studup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studup.service.UniversityService;

@RestController
@RequestMapping("/api/university")
public class UniversityRestController {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private UniversityService universityService;

	@PostMapping(value = "/v0.1/ListUniversity", headers = "Accept=application/xml", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> getStudentByEmailId() throws JsonProcessingException{
		return new ResponseEntity<String>(mapper.writeValueAsString(universityService.retrieveUniversities()),HttpStatus.OK);
	}
	
}
