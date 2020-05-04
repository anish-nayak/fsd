package com.spring.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.UserCredentialsEntity;
import com.spring.entity.UserEntity;
import com.spring.json.Application;
import com.spring.json.User;
import com.spring.json.UserCredentials;
import com.spring.json.Voter;
import com.spring.service.VoterService;

@RestController
@RequestMapping("/evs")
public class VoterController {

	@Autowired
	private VoterService voterService;

	private String sessionId = null;

	@PostMapping("/register")
	public Object registerVoter(@RequestBody Voter voter) {
		return voterService.registerVoter(voter);
	}

	@PutMapping(value = "/voter/{userid}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object addVoterRequest(@RequestBody Application application,@RequestHeader(name = "sessionId") String sessionId, 
			@PathVariable(value = "userid") Long userid) {
		return voterService.sendRequest(application,userid,sessionId);
	}
}
