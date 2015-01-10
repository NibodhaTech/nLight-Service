package com.nibodha.lgaas.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
public class LightMonitorController {
	@RequestMapping("/getinfo/{lightid}/{activationkey}")
	public String getInfo(@PathVariable("lightid") Long lightid,@PathVariable("activationkey") Long activationkey){
		return null;
	}
	
	@RequestMapping("/getmoreinfo/{lightid}/{activationkey}")
	public String getMoreInfo(@PathVariable("lightid") Long lightid,@PathVariable("activationkey") Long activationkey){
		return null;
	}
	
	@RequestMapping("/alllight/{activationkey}")
	public String getAllLightInfo(@PathVariable("activationkey") Long activationkey){
		return null;
	}
}
