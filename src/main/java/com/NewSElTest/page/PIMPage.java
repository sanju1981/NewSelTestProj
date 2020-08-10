package com.NewSElTest.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.NewSElTest.Base.TestBase;

public class PIMPage extends TestBase {
	//Object repository
	@FindBy(xpath="//ul[@id='mainMenuFirstLevelUnorderedList']//a[@id='menu_pim_viewPimModule']")
	WebElement PIMbtn;
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement PIMempList;
	@FindBy(id="empsearch_employee_name_empName")
	WebElement empName;
	@FindBy(id="empsearch_id")
	WebElement empId;
	@FindBy(id="searchBtn")
	WebElement searchBtn;
	@FindBy(xpath="//a[text()='Hello']")
	WebElement clikHello;
	@FindBy(xpath="//h1[text()='Personal Details']")
	WebElement personDet;
	@FindBy(id="btnAddAttachment")
	WebElement btnAdd;
	@FindBy(id="ufile")
	WebElement chooseFile;
	@FindBy(id="btnSaveAttachment")
	WebElement saveAttched;
	@FindBy(xpath="//a[@href='/index.php/pim/viewAttachment/empNumber/34/attachId/1']")
	WebElement attachedFileLink;
	@FindBy(xpath="//input[@name='chkattdel[]' and @value='1']")
	WebElement checkBtn;
	@FindBy(id="btnDeleteAttachment")
	WebElement Deldisbled;
	
	//page intialization
	public PIMPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//page operation
	public void verifyPIM() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PIMbtn.click();
		Thread.sleep(2000);
		PIMempList.click();
		Thread.sleep(2000);
		empName.sendKeys("Hello world");
		Thread.sleep(2000);
		List<WebElement> empList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		empList.size();
		for(int i=0;i<empList.size();i++)
		{
			String empSelName = empList.get(i).getText();
			if(empSelName.contains("Hello world"))
			{
				empList.get(i).click();
				break;
			}
		}
		empId.sendKeys("0066");
		searchBtn.click();
		
	}
	public void verifyClikHello() throws InterruptedException
	{
		clikHello.click();
		Thread.sleep(2000);
		boolean personre = personDet.isDisplayed();
		if(personre == true)
		{
			System.out.println("Person details page are visible");
		}
		else
		{
			System.out.println("Person details page are not opend");
		}
		
		JavascriptExecutor JS=(JavascriptExecutor) driver;
		JS.executeScript("arguments[0].scrollIntoView();", btnAdd);
		btnAdd.click();
				chooseFile.sendKeys("C:/Users/rajam/uploadFileTest.txt");
		Thread.sleep(1000);
		saveAttched.click();
		
		boolean attchFile=attachedFileLink.isDisplayed();
		if(attchFile == true)
		{
			System.out.println("File attached properly");
		}
		else
		{
			System.out.println("File didnt attached ");
		}
		
		checkBtn.click();
		boolean chBox=checkBtn.isSelected();
		if(chBox == true)
		{
			Deldisbled.click();
			System.out.println("Opload file is delet suucessfully");
		}
		else {
			System.out.println("Delete button is disabled");
		}
		
	
		 
		
		
	}

	
}
