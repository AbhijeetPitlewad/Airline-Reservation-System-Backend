package com.lti.AirlineBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.AirlineBackend.entity.Admin;
import com.lti.AirlineBackend.service.AdminService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	//http://localhost:8282/admin/abhi@123
	@GetMapping("/{adminUserName}")
	public Admin findAdminByUserName(@PathVariable("adminUserName") String adminUserName) throws Exception {
		Admin admin= adminService.findAdminByUserName(adminUserName);
		if(admin==null){
            throw new Exception("admin not found");
        }
		return admin;
	}
	
	
	//http://localhost:8282/admin/
	@PostMapping("/")
	public String addAdmin(@RequestBody Admin admin) {
		String adminUserName=adminService.addAdmin(admin);
		return adminUserName;
	}

		
}
