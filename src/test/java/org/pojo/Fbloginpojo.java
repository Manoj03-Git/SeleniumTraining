package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fbloginpojo extends BaseClass {

	// 1 Non parametrized Constructor
	public Fbloginpojo() {
		
		PageFactory.initElements(driver, this);

	}

	// 2.Private WebElement

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginbtn;

	// 3. getter to access webelements outside the class

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

}
