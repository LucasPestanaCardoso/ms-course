package com.br.hruser.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.hruser.entities.User;
import com.br.hruser.repositories.UserRepository;

@RefreshScope
@RestController
@RequestMapping( value = "/users")
public class UserResource {

	private static Logger logger = LoggerFactory.getLogger(UserResource.class);
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserRepository repository;

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {	
		
		
		logger.info("PORT: " + env.getProperty("local.server.port"));
		
		User user =  repository.findById(id).get();
		
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {	

		User user =  repository.findByEmail(email.trim());
    	return ResponseEntity.ok(user);
	}
	
	
}
