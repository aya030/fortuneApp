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

		return "fortune";
	}

	@PostMapping("/fortune")
	public String postFortune(@RequestParam("name") String name, Model model) {
		
		// inputで入力された名前を表示
		model.addAttribute("name", name);

		FortuneService.currentDate(model);
		FortuneService.fortuneTelling(model);

		// 画面遷移
		return "fortune/fortune-response";
	}
	
}
