package com.NewSElTest.page;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.NewSElTest.Base.TestBase;

public class LeavePage extends TestBase {
	
	//Object repository
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement LeaveBtn;
	@FindBy(id="menu_leave_viewLeaveList")
	WebElement leaveList;
	@FindBy(id="calFromDate")
	WebElement FromDate;
	@FindBy(id="calToDate")
	WebElement ToDate;
	@FindBy(className="ui-datepicker-month")
	WebElement MonthSel;
	@FindBy(className="ui-datepicker-year")
	WebElement YearSel;
	@FindBy(xpath="//*[@id='ui-datepicker-div']//td")
	List<WebElement> calList;
	@FindBy(id="leaveList_chkSearchFilter_2")
	WebElement checkLeaveStatsu;
	@FindBy(id="leaveList_txtEmployee_empName")
	WebElement empName;
	@FindBy(id="leaveList_cmbSubunit")
	WebElement subUnit;
	@FindBy(id="btnSearch")
	WebElement btnSearch;
	@FindBy(id="menu_leave_Configure")
	WebElement configID;
	@FindBy(id="menu_leave_viewHolidayList")
	WebElement holidayList;
	@FindBy(id="searchHolidayHeading")
	WebElement Holidays;
	
	//intailzation object element
	public LeavePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Object operation
	
	public String validateFormDate() throws InterruptedException
	{
		LeaveBtn.click();
		Thread.sleep(1000);
		leaveList.click();
		Thread.sleep(1000);
		FromDate.click();
		Thread.sleep(1000);
		Select dateList=new Select(MonthSel);
		dateList.selectByIndex(1);	
		Select dateYear=new Select(YearSel);
		dateYear.selectByValue("2020");
		Thread.sleep(1000);
		for(WebElement dateVal:calList)
		{
			String dateAll = dateVal.getText();
			//System.out.println("Date all value is"+dateAll);
			if(dateAll.equalsIgnoreCase("14"))
			{
				dateVal.click();
				break;
			}
		}
		String selDateVal = FromDate.getAttribute("value");
		return selDateVal;
	}
	public String validateToDate() throws InterruptedException
	{
		Thread.sleep(1000);
		ToDate.click();
		Select dateList=new Select(MonthSel);
		dateList.selectByIndex(3);	
		Select dateYear=new Select(YearSel);
		dateYear.selectByValue("2021");
		Thread.sleep(1000);
		for(WebElement calVal:calList)
		{
			String todateList = calVal.getText();
			if(todateList.equalsIgnoreCase("26"))
			{
				calVal.click();
				break;
			}
		}
		String alldateVal = ToDate.getAttribute("value");
		return alldateVal;		
	}
	public void verifyLeaveStatus()
	{
		checkLeaveStatsu.click();
		boolean checSelect = checkLeaveStatsu.isSelected();
		if(checSelect == true)
		{
			System.out.println("Scheduled checkbox is selected");
		}
		else
		{
			System.out.println("Wrong checlbox selected");
		}
		empName.sendKeys("Hello world");
		String empval = empName.getAttribute("value");
		if(empval.equalsIgnoreCase("Hello world"))
		{
			System.out.println("Emp name is correct");
		}
		else
		{
			System.out.println("Emp name is not correct");
		}
		
		subUnit.click();
		Select unitVal=new Select(subUnit);
		unitVal.selectByVisibleText("Sales");
		String unitList = subUnit.getAttribute("value");
		if(unitList.equalsIgnoreCase("4"))
		{
			System.out.println("Selected value are correct");
		}
		else
		{
			System.out.println("Selected values are not coorect");
		}
		btnSearch.click();
	}
	public void verifyConfigure() throws InterruptedException
	{
		LeaveBtn.click();
		Actions act=new Actions(driver);
		act.moveToElement(configID).build().perform();
		holidayList.click();
		Thread.sleep(2000);
		boolean holdDisp = Holidays.isDisplayed();
		if(holdDisp == true)
		{
			System.out.println("Holiday page is displayed");
		}
		else
		{
			System.out.println("Holiday page is not displayed");
		}
	}
}
