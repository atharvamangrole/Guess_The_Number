package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.InitialDAO;
import com.example.demo.model.Initial;

@RestController
public class InitialController {
	
	@Autowired
	private InitialDAO IDAO;
	
	@GetMapping("/initial")
	private List<Initial> getInitials(){
		return IDAO.getALL();
	}
	
	@PostMapping("/initial")
	public String saveInitial(@RequestBody Initial initial) {
		return IDAO.save(initial)+"Saved";
	}
	@GetMapping("/initial/{id}")
	public Initial getInitialById(@PathVariable int id) {
		return IDAO.getById(id);
	}
	
}
