package com.cluno.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cluno.utils.utils;


public class clunoPages {
	utils ob = new utils();
	fileReader flRdr = new fileReader();

	public static String addDamage = "//span[@class='new-issue-text']";
	public static String photoLink = "//div[@class='photo-section']/input";
	public static String damageDesc = "//input[@class='damage-text-input']"; //two elements are observed
	public static String uploadButton = "//div[@class='base-button']"; //two elements are observed
	public static String removeLink = "//div[@class='trash-container-tablet']"; //two elements are observed
	public static String closePage = "//*[@class='close-cross icon sprite-icons']";
	public static String damageDesc2 = "(//input[@class='damage-text-input'])[3]";
	public static String uploadButton2 = "(//div[@class='base-button'])[3]";
	public static String ext_BackBtn = "//span[@class='go-back-text']";
	public static String ext_chkbx = "//label[@class='label-container']";
	public static String check_sub_btn = "//div[@class='base-button long-button']";
	public static String yes_conf = "//div[@class='yes-confirmation']";
	public static String no_conf = "//div[@class='yes-confirmation']";
	public static String error_Text = "//div[@class='error-text']";
	public static String multipleDmg = "//div[@class='row issue-feature']";

	protected static WebDriver driver;

	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
	}
	public WebDriver launchBrowser(String browser) throws InterruptedException {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
			ob.waitForElm(5);
			driver.get(flRdr.getURL());		
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public void navigateTocluno(){
		try {
			launchBrowser(flRdr.getBrowser());
		} catch (InterruptedException e) {
			System.out.println("Error occured while navogating to cluno url on browser");
			e.printStackTrace();
		}
	}

	public void userClicksonAddDmg(){
		ob.clickElm(ob.selectElement(driver,addDamage));
	}

	public void addDmgforRearViewMirror() {
		addInteriorDamage("1", "Rear View Mirror is missing");
	}

	public void addDmgforBackSeatTear() {
		userClicksonAddDmg();
		addInteriorDamage("3", "Tear in the backseat");
	}

	public void closeAddIntrDamage() {
		ob.clickElm(ob.selectElement(driver,closePage));
	}

	public void addDentOnDoor() {
		addExteriorDamage("9", "1", "Delle","1", "Driver's door has a dent");
	}

	public void clickOnBackBtn() {
		ob.clickElm(ob.selectElement(driver,ext_BackBtn));
	}

	public void addScratchOnDoor() {
		addExteriorDamage("9", "2", "Kratzer","3", "Driver's door has a big Scratch");
	}

	public void addScratchOnRim() {
		addExteriorDamage("18", "1", "Kratzer","1", "Front Rim has a Scratch");
	}

	public void addScratchOnRearRim() {
		addExteriorDamage("18", "1", "Kratzer","3", "Rear Rim has a Scratch");
	}

	public void addScratchOnCorrectRim() {
		addExteriorDamage("21", "1", "Kratzer","1", "Rear Rim has a Scratch");
	}

	public void clickOnPartNum() {
		ob.clickElm(ob.extrElm("18", "1", driver));
	}

	public void userClickDesiredPart(String partNumber) {
		ob.clickElm(ob.extrElm(partNumber, "1", driver));
	}

	public void missingDmgType(String partNumber) {
		addExteriorDamage(partNumber, "1", " " ,"1", "The selected part is missing");
	}

	public void addMultipleDamage() {
		selectDamageType("Kratzer", "three");
		addImage(flRdr.getFilePath());
		addDesc("1", "Selected part has been replaced");
	}

	public void validateError() {
		String error = "wähle mindestens eine Schadensart aus, um einen Schaden zu melden";
		if(ob.getElemText(ob.selectElement(driver, error_Text)).equals(error)) {
			System.out.println("Correct error message is displayed to the user");
		}else {
			System.out.println("Error displayed is not correct");
		}
		clickOnBackBtn();
	}

	public void waitOnScreen () {
		ob.waitForElm(50);
	}

	public void addInteriorDamage(String txtFldIndx, String desc){
		try {
			addImage(flRdr.getFilePath()); 
			addDesc(txtFldIndx , desc);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("Exception occured while eadding interior damage");
		}
	}

	public void addExteriorDamage(String eleNum, String index, String damageType, String txtFldIndx, String desc) {
		try {
			ob.clickElm(ob.extrElm(eleNum, index, driver));
			addImage(flRdr.getFilePath());
			selectDamageType(damageType,"one");
			addDesc(txtFldIndx , desc);
			ob.waitForElm(10);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured while adding external damage");
		}		
	}

	public void selectDamageType(String dmgType, String dmgCase ) {
		try {
			List<WebElement> elem = driver.findElements(By.xpath(ext_chkbx));
			String cb_vl;
			switch(dmgCase) { 
			case "one":
				for(int i=0; i<=elem.size(); i++) {
					cb_vl = ob.getElemText(elem.get(i));
					if (cb_vl.equalsIgnoreCase(dmgType)) {
						elem.get(i).click();
					}else;
					//System.out.println("Select type is different");
				}
			case "two":
				for(int i=0; i<=elem.size(); i++) {
					cb_vl = ob.getElemText(elem.get(i));
					if (cb_vl.equalsIgnoreCase("Delle")||cb_vl.equalsIgnoreCase("Kratzer")){
						elem.get(i).click();
					}else;
					System.out.println("Select Damage type is type is miscllaneous");
				}

			case "three":
				for(int i=0; i<=elem.size(); i++) {
					elem.get(i).click();
				}
			}
		} catch (Exception e) {
			System.out.println("Error occured while selecting damage type");
		}
	}

	public void validateAddedDamage() {
		List<WebElement> elmList = driver.findElements(By.xpath(multipleDmg));
		try {
			ob.waitForElm(3);
			for(int i=0; i<=elmList.size(); i++) {
					System.out.println("Damages are added");
			}
		}
		 catch (Exception e) {
			System.out.println("Error occured while validating multiple damages");
		}
	}

	public void rmvWrongDamage() {
		removeDamage("5");
		removeDamage("4");
	}


	public void removeDamage(String indNum) {
		ob.clickElm(ob.selectElementIndx(driver,removeLink,indNum));
	}

	public void submit() {
		ob.clickElm(ob.selectElement(driver,check_sub_btn));
	}

	public void yesConf() {
		ob.clickElm(ob.selectElement(driver,yes_conf));
	}

	public void noConf() {
		ob.clickElm(ob.selectElement(driver, no_conf));
	}

	public void addImage(String imgPath) {
		ob.sendInput(ob.selectElement(driver,photoLink), imgPath);
	}

	public void addDesc(String txtFldIndx,String desc) {
		ob.clearInputText(ob.selectElement(driver, damageDesc));
		ob.sendInput(ob.selectElementIndx(driver,damageDesc,txtFldIndx), desc);
		ob.clickElm(ob.selectElementIndx(driver,uploadButton,txtFldIndx));
	}

	public void quitBrowser() {
		driver.quit();
	}



}
