package com.spring.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.ApplicationEntity;

import com.spring.json.Application;

import com.spring.service.ElectoralServices;

@RestController
@RequestMapping("/evs")
public class ElectrolOfficerController {

	
	@Autowired
	private ElectoralServices eoService;
	
	
	
	private String sessionId = null;
	


	
	@GetMapping(value="/application/approved/request")
	public Object getRequest1(@RequestHeader(name = "sessionId") String sessionId){
		return eoService.getApprovedUser(sessionId);
	}
	
	@PostMapping(value="/application/approved/update/{userid}",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object updateRequest2(@RequestBody Application
			application,ApplicationEntity 
			applicationEntity ,@RequestHeader(name = "sessionId") String sessionId,
			@PathVariable(name="userid") String userid
			){
       BeanUtils.copyProperties(application,applicationEntity);
		return eoService.generateVoterId(application,userid,sessionId);
	}

	

}
