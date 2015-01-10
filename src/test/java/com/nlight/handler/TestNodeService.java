package com.nlight.handler;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestNodeService {
	@Test
public void checkTurnOnLight(){
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("hotel", "42");
		vars.put("booking", "21");
		String result = 
		    restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class, vars)
	}
}
