package com.examenA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.examenA.services.RobotService;
import com.examenA.services.SensorService;

@Controller
public class RobotController {
	
	@Autowired
	RobotService robotServicio;
	
	@Autowired 
	SensorService sensorServicio;
	
	@GetMapping("/robots")
	public String index(Model model) {
		model.addAttribute("robots", robotServicio.listarRobots());
		return "robots";
	}
	
	
	//@GetMapping("/robots/sensoresRobot")
	/*public String x(Model model) {
		model.addAttribute("robots", robotServicio.listarRobots());
		return "robots";
	}*/
	
}
