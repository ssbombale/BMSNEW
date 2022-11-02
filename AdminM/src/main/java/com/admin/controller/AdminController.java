package com.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.AdminDetail;
import com.admin.entity.AuthResponse;
import com.admin.entity.Login;
import com.admin.entity.OutputModel;
import com.admin.security.jwt.JwtUtils;
import com.admin.service.AdminImplementation;
import com.admin.service.AdminService;

@RestController
@RequestMapping(value = "/api/adminCtrl")
public class AdminController {
	
	@Autowired
	private AdminService customerService;
	
	@GetMapping(value = "/welcome")
	public String test() {
		return "Hello !!!!";
	} 
	
	@PostMapping("/registration")
	Integer createUser(@Valid @RequestBody AdminDetail user) {
		Integer id = customerService.saveUser(user);
		return id;
	}
	
	
	@Autowired
	private JwtUtils jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AdminImplementation useraccountServiceImpl;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody Login login) throws Exception {

		try { 

			AdminDetail useraccount = useraccountServiceImpl.getUseraccountByUsername(login.getUsername());
			if (useraccount != null) {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

				String jwt = jwtUtil.generateToken(login.getUsername());
				AuthResponse auth = new AuthResponse(jwt, useraccount.getUserId(), useraccount.getUserName(), "",
						useraccount.getName(), useraccount.getEmail(),true,"Login Successfully");
				return ResponseEntity.ok(auth);

			} else {
				OutputModel outputModel = new OutputModel(false, "username or password invalid..............");
				return ResponseEntity.ok(outputModel);
			}

		} catch (Exception e) {
			System.err.println(e);
			OutputModel outputModel = new OutputModel(false, "username or password invalid");
			return ResponseEntity.ok(outputModel);
			
		}
	}
	
	/**
	
	
	@GetMapping("/getSession/{token}")
	public ResponseEntity<?> getSession(@PathVariable String token) throws Exception {
		try {
			Useraccount useraccount = useraccountServiceImpl.getUseraccountByUsername(login.getUsername());
			if (useraccount != null) {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
				String jwt = jwtUtil.generateToken(login.getUsername());
				AuthResponse auth = new AuthResponse(jwt, useraccount.getUserId(), useraccount.getUserName(), "",
						useraccount.getFirstName(), useraccount.getLastName());
				return ResponseEntity.ok(auth);
			} else {
				OutputModel outputModel = new OutputModel(false, "username or password invalid");
				return ResponseEntity.ok(outputModel);
			}
		} catch (Exception e) {
			System.err.println(e);
			OutputModel outputModel = new OutputModel(false, "username or password invalid");
			return ResponseEntity.ok(outputModel);
			
		}
	}
**/
	
	
	
	
	
	
	
	

	
}
