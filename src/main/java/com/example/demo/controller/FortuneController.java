package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.FortuneService;

@Controller
public class FortuneController {

	@GetMapping("/fortune")
	public String getFortune() {

		// fortune.htmlに遷移する
		return "fortune";
	}

	@PostMapping("/fortune")
	public String postFortune(@RequestParam("name") String name, Model model) {
		
		// inputで入力された名前を表示
		model.addAttribute("name", name);

		FortuneService.date(model);
		FortuneService.fortuneTelling(model);

		// fortune-response.htmlに遷移する
		return "fortune/fortune-response";
	}
	
}
