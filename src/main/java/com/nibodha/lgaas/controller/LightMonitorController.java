package com.nibodha.lgaas.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nibodha.lgaas.entity.Light;
import com.nibodha.lgaas.entity.User;
import com.nibodha.lgaas.service.LightActionService;

@RestController
@RequestMapping("/monitor")
public class LightMonitorController {
	@Autowired
	LightActionService lightActionService;
	
	@RequestMapping("/getinfo/{lightid}/{activationkey}")
	public String getInfo(@PathVariable("lightid") Long lightid,@PathVariable("activationkey") String activationkey) throws JsonGenerationException, JsonMappingException, IOException{
		Light light = lightActionService.getLightInfo(lightid, activationkey);
		ObjectMapper oMapper = new ObjectMapper();
		 return oMapper.writeValueAsString(light);
	}
	
	@RequestMapping("/getmoreinfo/{lightid}/{activationkey}")
	public String getMoreInfo(@PathVariable("lightid") Long lightid,@PathVariable("activationkey") Long activationkey){
		return null;
	}
	
	@RequestMapping("/allight/{activationkey}")
	public String getAllLightInfo(@PathVariable("activationkey") String activationkey) throws JsonGenerationException, JsonMappingException, IOException{
		List<Light> lightList = lightActionService.getAllLight(activationkey);
		ObjectMapper oMapper = new ObjectMapper();
		 return oMapper.writeValueAsString(lightList);
	}
	
	@RequestMapping(value = "/createlightdata", method = RequestMethod.POST)
	public String createLightData(@RequestBody Light light) throws JsonProcessingException{
		String apikey = lightActionService.createlightdata(light);
		System.out.println("Add User "+apikey);
		return apikey;
	}
}
