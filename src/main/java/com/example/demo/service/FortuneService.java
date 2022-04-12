package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FortuneService {

	public static void date(Model model) {
		// 今日の日付を表示する
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String now = date.format(formatter);
		model.addAttribute("datetime", now);
	}

	public static void fortuneTelling(Model model) {
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
	}

}
