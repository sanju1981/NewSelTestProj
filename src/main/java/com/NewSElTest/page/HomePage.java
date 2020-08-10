package com.NewSElTest.page;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.NewSElTest.Base.TestBase;

public class HomePage extends TestBase {
	//page repository
	@FindBy(xpath="//ul[@id='mainMenuFirstLevelUnorderedList']/li[@class='main-menu-first-level-list-item']/a[@id='menu_admin_viewAdminModule']")
	WebElement adminClk;
	@FindBy(id="searchSystemUser_userName")
	WebElement sysUser;
	@FindBy(id="searchSystemUser_userType")
	WebElement sysType;
	@FindBy(id="searchSystemUser_employeeName_empName")
	WebElement employeeName;
	@FindBy(id="searchSystemUser_status")
	WebElement ststus;
	@FindBy(id="searchBtn")
	WebElement searchBtn;
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")
	WebElement serchName;
	//Add user repository
	@FindBy(id="btnAdd")
	WebElement btAdd;
	@FindBy(id="systemUser_userType")
	WebElement userRole;
	@FindBy(id="systemUser_employeeName_empName")
	WebElement empName;
	@FindBy(id="systemUser_userName") 
	WebElement useName;
	@FindBy(id="systemUser_status")
	WebElement sysStsts;
	@FindBy(id="btnSave")
	WebElement btSave;
	@FindBy(id="btnCancel")
	WebElement btCancel;
	@FindBy(id="systemUser_password")
	WebElement passowrd;
	@FindBy(id="systemUser_confirmPassword")
	WebElement Confirmpassowrd;
	
	
	//initialization 
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action of repository class
	public PIMPage verifySysUser(String sysUser1,String empName1) throws InterruptedException
	{
		adminClk.click();
		//sysUser.sendKeys("Denial1");
		sysUser.sendKeys(sysUser1);
		sysType.click();
		Select roleList= new Select(sysType);
		roleList.selectByIndex(2);
		String sysName = sysType.getAttribute("value");
		System.out.println("sysName value is==>" +sysName);
		if(sysName.equalsIgnoreCase("2"))
		{
			System.out.println("Selected role is correct");
		}
		else
		{
			System.out.println("Selected role is not correct");
		}
		//employeeName.sendKeys("Hello world");
		employeeName.sendKeys(empName1);
		ststus.click();
		Select stsList=new Select(ststus);
		stsList.selectByIndex(1);
		String stat = ststus.getAttribute("value");
		if(stat.equalsIgnoreCase("1"))
		{
			System.out.println("Selected ststus is correct");
		}
		else
		{
			System.out.println("Selected status is not correct");
		}
		
		searchBtn.click();
		Thread.sleep(2000);
		serchName.click();
		Thread.sleep(2000);
		btCancel.click();
		return new PIMPage();
	}
	
	public void verifyAddUsers(String sysUser1,String empName1) throws InterruptedException
	{
		adminClk.click();
		btAdd.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		userRole.click();
		Select userlist=new Select(userRole);
		userlist.selectByIndex(1);
		//empName.sendKeys("Hello world");		
		empName.sendKeys(empName1);
		//useName.sendKeys("Denial1");
		useName.sendKeys(sysUser1);
		useName.clear();		
		//useName.sendKeys("Denial1");
		useName.sendKeys(sysUser1);
		Thread.sleep(1000);
		useName.click();		
		sysStsts.click();		
		Select stList=new Select(sysStsts);
		stList.selectByIndex(0);
		sysStsts.click();
		
		int errorDis = driver.findElements(By.xpath("//input[@class='formInputText validation-error']")).size();
		System.out.println("error messgage"+errorDis);
		boolean err = errorDis > 0;
			System.out.println("error value"+err);
			if(err == true)
			{
				btCancel.click();
			}
			else
			{
				btSave.click();
			/*	int pasErr = driver.findElements(By.xpath("//input[@class='formInputText password validation-error']")).size();
				boolean rep = pasErr>0;
				if(rep == true)
				{
					//passowrd.sendKeys("Denial@123");
					passowrd.sendKeys("Denial@123");
				}
				else {
					btSave.click();
				}
				Confirmpassowrd.click();
				btSave.click();
				int conErr = driver.findElements(By.xpath("//input[@class='formInputText password validation-error']")).size();
				boolean CON = conErr >0;
				if(CON == true)
				{
					//Confirmpassowrd.sendKeys("Denial@123");
					Confirmpassowrd.sendKeys("Denial@123");
				}
				else {
					
					btSave.click();
				}*/
			//	btSave.click();
			}
			
		
	}
	


}
