package org.Stepdefinition;

import org.base.BaseClass;
import org.pojo.Fbloginpojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class Fblogin extends BaseClass{
	
	
	Fbloginpojo f ;
	@Given("User has To launch the browser and mazimize the window")
	public void user_has_To_launch_the_browser_and_mazimize_the_window() {
	    launchBrowser();
	    WindowMaximize();
	}

	@When("User has To hit the facebook url")
	public void user_has_To_hit_the_facebook_url() {
		
		LaunchUrl("https://www.facebook.com/");
	   
	}

	@When("User has To pass the data {string} in email field")
	public void user_has_To_pass_the_data_in_email_field(String em) {
	 
		f = new Fbloginpojo();
		passtext(em, f.getEmail());
	}

	@When("User has To pass the data {string} in password field")
	public void user_has_To_pass_the_data_in_password_field(String pass) {
	    
		f= new Fbloginpojo();
		passtext(pass, f.getPassword());
	}

	@When("User has To click login button")
	public void user_has_To_click_login_button() {
	   
		f= new Fbloginpojo();
		clickbutton(f.getLoginbtn());
	}


	@Then("User has To close the browser")
	public void user_has_To_close_the_browser() {
		
		closeEntireBrowser();
	   
	}
		
	
}
