package com.nibodha.lgaas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibodha.lgaas.dto.Result;
import com.nibodha.lgaas.service.LightActionService;

@RestController
@RequestMapping("/control")
public class LightActionController {
	@Autowired
	LightActionService lightActionService;
	
	@RequestMapping("/blink/{level}/{lightid}/{activationkey}")
	public String startLight(@PathVariable("level") Long level,@PathVariable("lightid") Long lightid,@PathVariable("activationkey") String activationkey) throws Exception{
		String result = lightActionService.blinkLight(level,lightid,activationkey);
		Result res= new Result();
		res.setResult(result);
		return new ObjectMapper().writeValueAsString(res);
	}
	
	
	

}
