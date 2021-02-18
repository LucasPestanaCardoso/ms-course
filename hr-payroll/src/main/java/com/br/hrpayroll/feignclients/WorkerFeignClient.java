package com.br.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.hrpayroll.entities.Worker;


@Component
@FeignClient(name = "hr-worker", /* url = Não precisa mais registrar a url por causa do Eureka*/   path = "/workers")
public interface WorkerFeignClient {

	@GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
	
	
	
}
