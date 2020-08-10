package com.NewSElTest.TestPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NewSElTest.Base.TestBase;
import com.NewSElTest.page.HomePage;
import com.NewSElTest.page.LoginPage;
import com.NewSElTest.page.PIMPage;

@Listeners(com.NewSElTest.utility.Reporting.class)
public class PIMPageTest extends TestBase {
	LoginPage lopo;
	HomePage hopo;
	PIMPage pimp;
	
	public PIMPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		intialization();
		lopo=new LoginPage();
		lopo.clicksignIn(prop.getProperty("newUser"), prop.getProperty("passw"));
	//	hopo=new HomePage();
	//	hopo.verifySysUser();
		pimp=new PIMPage();
	}
	@Test(priority=1)
	public void validateEmpname() throws InterruptedException
	{
		pimp.verifyPIM();
	}
	@Test(priority=2)
	public void validatePerson() throws InterruptedException
	{
		pimp.verifyPIM();
		pimp.verifyClikHello();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
