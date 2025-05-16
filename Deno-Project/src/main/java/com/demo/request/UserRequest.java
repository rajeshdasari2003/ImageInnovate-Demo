package com.demo.request;

import java.util.List;
import java.util.Map;

//[{ "name" : "abdul", "plays" : [{
//"cricket": 20, "football": 50]}, { "name" : "Rajesh", "plays" : [{
//"hockey": 20, "football": 50]}]
public class UserRequest {
	
	private String name;
	
    private Map<String, Integer> plays;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getPlays() {
		return plays;
	}

	public void setPlays(Map<String, Integer> plays) {
		this.plays = plays;
	}

	
	

}
