package com.cluno.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class utils{
	
	public void clickElm(WebElement elem) {
		try {
			waitForElm(3);
			if(elem.isDisplayed()||elem.isEnabled()) {
				elem.click();
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("The Element user wants to click is not visible or disabled");
		}
	}
	
	public String getElemText(WebElement elem) {
		String txt = null;
		try {
			waitForElm(5);
			if(elem.isDisplayed()==true) {
				txt = elem.getText();
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return txt;
	}
	
	public void sendInput(WebElement elem, String inputValue) {
		try {
			waitForElm(5);
			elem.sendKeys(inputValue);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	public void closeBrowser(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public void clearInputText(WebElement elem) {
		try {
			elem.clear();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public void waitForElm(int wt) {
		try {
			int wait = wt*100;
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
	}
	
	public WebElement selectElement(WebDriver driver, String xPath) {
		WebElement element = null;
		try {
			waitForElm(5);
			element = driver.findElement(By.xpath(xPath));
			if (element.isEnabled() == true && element.isDisplayed() == true)
				return element;
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Element is not displayed or not enabled");
			return null;
		}
		return element;	
}
	
	public WebElement selectElementIndx(WebDriver driver,String xPath,String indx) {
		WebElement element = null;
		try {
			waitForElm(3);
			xPath = "("+ xPath +")["+indx +"]";
			element = driver.findElement(By.xpath(xPath));
			if (element.isEnabled() == true && element.isDisplayed() == true)
				return element;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
		return element;	
}
	
	public WebElement extrElm(String xpNo, String index, WebDriver driver) {
		WebElement element = null;
		String x = "(//*[@class='explosion-part-"+ xpNo +"'])["+ index +"]";
		try {
		waitForElm(5);
			element = driver.findElement(By.xpath(x));
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return element;	
	}
	
}
