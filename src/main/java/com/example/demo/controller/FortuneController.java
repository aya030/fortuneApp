package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FortuneController {

	@GetMapping("/fortune")
	public String getFortune() {

		// helloWorld.htmlに遷移する
		return "fortune";
	}

	@PostMapping("/fortune")
	public String postFortune(@RequestParam("nameResponse") String name, Model model) {
		
		// inputで入力された名前を表示
		model.addAttribute("nameResponse", name);

		// 今日の日付を表示する
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String now = date.format(formatter);
		model.addAttribute("datetime", now);
		

		// 運勢
		String[] fortune = { "★★★★★", "★★★★", "★★★", "★★", "★" };
		
		// 全体運
		int allFortune = (int) (Math.random() * (fortune.length));
		model.addAttribute("result", fortune[allFortune]);
		
		// 健康運
		int health = (int) (Math.random() * (fortune.length));
		model.addAttribute("health", fortune[health]);
		
		// 恋愛運
		int love = (int) (Math.random() * (fortune.length));
		model.addAttribute("love", fortune[love]);
		
		// 金運
		int money = (int) (Math.random() * (fortune.length));
		model.addAttribute("money", fortune[money]);

		// ラッキーカラー
		String[] pointGoods = { "タンブラー", "お菓子", "チューリップ", "画集", "ネックレス" };
		int goods = (int) (Math.random() * (fortune.length));
		model.addAttribute("goods", pointGoods[goods]);

		// helloResponse.htmlに遷移する
		return "fortune/fortune-response";
	}
	
}
