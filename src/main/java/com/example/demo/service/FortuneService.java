package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FortuneService {

	public String currentDate(Model model) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String currentDate = now.format(formatter);
		return currentDate;
	}

	
	public String[] fortuneTelling(Model model) {
		// 運勢
		String[] fortune = { "★★★★★", "★★★★", "★★★", "★★", "★" };

		// 全体運
		int allFortuneNum = (int) (Math.random() * (fortune.length));
		String allFortune = fortune[allFortuneNum];

		// 健康運
		int healthFortuneNum = (int) (Math.random() * (fortune.length));
		String healthFortune = fortune[healthFortuneNum];

		// 恋愛運
		int loveFortuneNum = (int) (Math.random() * (fortune.length));
		String loveFortune = fortune[loveFortuneNum];

		// 金運
		int moneyFortuneNum = (int) (Math.random() * (fortune.length));
		String moneyFortune = fortune[moneyFortuneNum];

		// ラッキーアイテム
		String[] pointGoods = { "タンブラー", "お菓子", "チューリップ", "画集", "ネックレス" };
		int goodsFortuneNum = (int) (Math.random() * (fortune.length));
		String goodsFortune = pointGoods[goodsFortuneNum];
		
		String[] fortuneTelling = {allFortune,healthFortune,loveFortune,moneyFortune,goodsFortune};
		return fortuneTelling;
	}

}
