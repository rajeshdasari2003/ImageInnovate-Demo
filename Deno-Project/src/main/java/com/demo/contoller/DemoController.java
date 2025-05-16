package com.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.request.UserRequest;
import com.demo.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserService userService;

	@GetMapping("/welcome/{name}")
	public String welcomeMessage(@PathVariable String name) {

		return "Welcome " + name;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveDetails(@RequestBody String request) {

		try {
			List<UserRequest> requestList = objectMapper.readValue(request, new TypeReference<List<UserRequest>>() {
			});

			String response = userService.saveDetails(requestList);
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Invalid JSON format", HttpStatus.BAD_REQUEST);

		}
	}

}
