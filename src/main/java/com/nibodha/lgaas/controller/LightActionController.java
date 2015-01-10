package com.nibodha.lgaas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nibodha.lgaas.service.LightActionService;

@RestController
@RequestMapping("/control")
public class LightActionController {
	@Autowired
	LightActionService lightActionService;
	
	@RequestMapping("/blink/{level}")
	public String startLight(@PathVariable("level") Long level){
		
		
		
		
	}
	

}
