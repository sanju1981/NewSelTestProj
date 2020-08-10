package com.NewSElTest.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NewSElTest.Base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory object repository
	@FindBy(id="txtUsername")
	WebElement accountId;
	@FindBy(id="txtPassword")
	WebElement password;
	@FindBy(id="btnLogin")
	WebElement signBtn;
	
	//Page initialzation
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory Actions
	
		
	public HomePage clicksignIn(String uname,String pawd) throws InterruptedException
	{
		accountId.sendKeys(uname);
	//	accountId.sendKeys(prop.getProperty("newUser"));
		Thread.sleep(2000);
		password.sendKeys(pawd);
	//	password.sendKeys(prop.getProperty("passw"));
		Thread.sleep(2000);
		signBtn.click();
		return new HomePage();
	}

}
