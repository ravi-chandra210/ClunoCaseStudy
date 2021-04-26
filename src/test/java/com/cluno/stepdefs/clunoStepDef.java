package com.cluno.stepdefs;

import com.cluno.pages.clunoPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class clunoStepDef {
	clunoPages clunoOb = new clunoPages();
	@Given("Navigate to Cluno url")
	public void navigate_to_Cluno_url() {
		clunoOb.navigateTocluno();
	}

	@When("User navigates to Cluno Homepage and clicks on Add Damage under Interior")
	public void user_navigates_to_Cluno_Homepage_and_clicks_on_Add_Damage_under_Interior() {
	     clunoOb.userClicksonAddDmg();
	}

	@Then("User should Navigate to Add damage page")
	public void user_should_Navigate_to_Add_damage_page() {
	     
	}

	@Then("User should add damage for rear view mirror")
	public void user_should_add_damage_for_rear_view_mirror() {
		clunoOb.addDmgforRearViewMirror();
	}

	@Then("User should add damage for back seat tear")
	public void user_should_add_damage_for_back_seat_tear() {
		clunoOb.addDmgforBackSeatTear();   
	}

	@Then("User clicks on close button and navigates to homepage")
	public void user_clicks_on_close_button_and_navigates_to_homepage() {
		clunoOb.closeAddIntrDamage();	     
	}

	@Then("User should add damage to dent on driver's side door")
	public void user_should_add_damage_to_dent_on_driver_s_side_door() {
		clunoOb.addDentOnDoor();	     
	}

	@Then("User should click back to navigate to home page")
	public void user_should_click_back_to_navigate_to_home_page() {
		clunoOb.clickOnBackBtn();
	}

	@Then("User should add damage to scratch on driver's side door")
	public void user_should_add_damage_to_scratch_on_driver_s_side_door() {
		clunoOb.addScratchOnDoor();	     
	}

	@Then("User should add damage to scratch on driver's side front rim")
	public void user_should_add_damage_to_scratch_on_driver_s_side_front_rim() {
	    clunoOb.addScratchOnRim();	     
	}

	@When("User clicks on Check and Submit")
	public void user_clicks_on_Check_and_Submit() {
		clunoOb.submit();	     
	}

	@Then("User should click yes on confirmation pop-up")
	public void user_should_click_yes_on_confirmation_pop_up() {
		clunoOb.yesConf();
	}

	@Then("User should be able to submit the report")
	public void user_should_be_able_to_submit_the_report() {
	 
	     
	}

	@When("User clicks on entry in eighteen")
	public void user_clicks_on_entry_in_eighteen() {
		clunoOb.waitOnScreen();
		clunoOb.addScratchOnRearRim();
	}

	@Then("User should update damage and clicks back button")
	public void user_should_update_damage_and_clicks_back_button() {	 
		clunoOb.clickOnBackBtn();
	}

	@When("User clicks on entry in eighteen again")
	public void user_clicks_on_entry_in_eighteen_again() {
		clunoOb.clickOnPartNum();	     
	}

	@Then("User removes the damage added and clicks back button")
	public void user_removes_the_damage_added_and_clicks_back_button() {
		clunoOb.rmvWrongDamage();
		clunoOb.clickOnBackBtn();
	}
	
	@When("User clicks on entry in twenty one")
	public void user_clicks_on_entry_in_twenty_one() {
		
	}

	@Then("User updates the damage and clicks back button")
	public void user_updates_the_damage_and_clicks_back_button() {
		clunoOb.addScratchOnCorrectRim();	  
		clunoOb.clickOnBackBtn();
	}
	
	@Then("User should click no on confirmation pop-up")
	public void user_should_click_no_on_confirmation_pop_up() {
		clunoOb.noConf();
	}
	
	@Then("Quit the browser")
	public void quit_the_browser() {
		clunoOb.quitBrowser();
	}
	
	@When("User enters {string} and miss to enter either damage type or image")
	public void user_enters_and_miss_to_enter_either_damage_type_or_image(String partNumber) {
	    clunoOb.missingDmgType(partNumber);
	}

	@Then("click upload button")
	public void click_upload_button() {
	    
	}

	@Then("User should observe error message")
	public void user_should_observe_error_message() {
	    clunoOb.validateError();
	}
	
	@When("User selects any exterior damage {string}")
	public void user_selects_any_exterior_damage(String part) {
		clunoOb.missingDmgType(part);
	}

	@Then("User should be able enter the data by selecting multiple damage options")
	public void user_should_be_able_enter_the_data_by_selecting_multiple_damage_options() {
	    clunoOb.addMultipleDamage();
	}

	@Then("click close button")
	public void click_close_button() {
		clunoOb.clickOnBackBtn();
	}
	
	@Then("User should validate the Damage type and image uploaded")
	public void user_should_validate_the_Damage_type_and_image_uploaded() {
	    clunoOb.validateAddedDamage();
	}

	@Then("User should navigate to home page and close the browser")
	public void user_should_navigate_to_home_page_and_close_the_browser() {
		clunoOb.waitOnScreen();
	}
	
}
