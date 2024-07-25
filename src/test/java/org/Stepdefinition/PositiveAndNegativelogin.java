package org.Stepdefinition;

import org.base.BaseClass;
import org.pojo.Fbloginpojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PositiveAndNegativelogin extends BaseClass {

	Fbloginpojo f ;
	@Given("To launch the Browser and Maximize the window")
	public void to_launch_the_Browser_and_Maximize_the_window() {
	   
		launchBrowser();
		WindowMaximize();
	}

	@When("To launch the URL of the facebook Application")
	public void to_launch_the_URL_of_the_facebook_Application() {
	    
		LaunchUrl("https://www.facebook.com/");
	}

	@When("To pass Valid username in email field")
	public void to_pass_Valid_username_in_email_field() {
	   
		f= new Fbloginpojo();
		passtext("manochan@gmail.com", f.getEmail());
		
	}

	@When("To pass valid Password in password field")
	public void to_pass_valid_Password_in_password_field() {
	   
		f= new Fbloginpojo();
		passtext("manojkumar", f.getPassword());
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
	   
		clickbutton(f.getLoginbtn());
	}

	@When("To check Whether the page Navigate to home page or Not")
	public void to_check_Whether_the_page_Navigate_to_home_page_or_Not() {
	   System.out.println("Check the credentials");
	}

	@Then("To Close the Browser")
	public void to_Close_the_Browser() {
		
		closeEntireBrowser();
	   
	}
}
