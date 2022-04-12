package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FortuneService {

	public static void currentDate(Model model) {
		// 今日の日付を表示する
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		model.addAttribute("datetime", now.format(formatter));
	}

	public static void fortuneTelling(Model model) {
		// 運勢
		String[] fortune = { "★★★★★", "★★★★", "★★★", "★★", "★" };

		// 全体運
		int allFortune = (int) (Math.random() * (fortune.length));
		model.addAttribute("result", fortune[allFortune]);

		// 健康運
		int healthFortune = (int) (Math.random() * (fortune.length));
		model.addAttribute("health", fortune[healthFortune]);

		// 恋愛運
		int loveFortune = (int) (Math.random() * (fortune.length));
		model.addAttribute("love", fortune[loveFortune]);

		// 金運
		int moneyFortune = (int) (Math.random() * (fortune.length));
		model.addAttribute("money", fortune[moneyFortune]);

		// ラッキーカラー
		String[] pointGoods = { "タンブラー", "お菓子", "チューリップ", "画集", "ネックレス" };
		int goodsFortune = (int) (Math.random() * (fortune.length));
		model.addAttribute("goods", pointGoods[goodsFortune]);
	}

}
