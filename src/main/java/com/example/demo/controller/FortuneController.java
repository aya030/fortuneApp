package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.FortuneService;

@Controller
public class FortuneController {

	// DI対象
	private final FortuneService fortuneService;

	public FortuneController(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@GetMapping("/fortune")
	public String getFortune() {
		return "fortune";
	}

	@PostMapping("/fortune")
	public String postFortune(@RequestParam("name") String name, Model model) {

		/*----------------------
		 * inputで入力された値
		 ---------------------- */
		model.addAttribute("name", name);

		/*----------------------
		 * 今日の日付
		 ---------------------- */
		model.addAttribute("datetime", fortuneService.currentDate());

		/*----------------------
		 * 運勢一覧
		 ---------------------- */
		// 全体運
		model.addAttribute("result", fortuneService.fortuneTelling()[0]);
		// 健康運
		model.addAttribute("health", fortuneService.fortuneTelling()[1]);
		// 恋愛運
		model.addAttribute("love", fortuneService.fortuneTelling()[2]);
		// 金銭運
		model.addAttribute("money", fortuneService.fortuneTelling()[3]);
		// ラッキーアイテム
		model.addAttribute("goods", fortuneService.fortuneTelling()[4]);

		// 画面遷移
		return "fortune/fortune-response";
	}

}
