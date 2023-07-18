package com.easyfactory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.feb.controller.FebController;
import com.feb.service.FebService;

@Configuration
public class ControllerConfig {

	@Autowired
	private FebService febService;
	
	@Bean
	public FebController febController() {
		FebController febController = new FebController();
		febController.setFebService(febService);
		return febController;
	}

}
