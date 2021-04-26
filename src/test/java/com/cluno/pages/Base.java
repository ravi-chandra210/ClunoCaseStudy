package com.cluno.pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	private ChromeDriver driver;
	
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}
	public Base() {
		this.driver = new ChromeDriver();
	}
	
	public ChromeDriver getWebDriver() {
		return this.driver;
	}
}
