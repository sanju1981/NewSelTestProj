package com.NewSElTest.TestPage;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NewSElTest.Base.TestBase;
import com.NewSElTest.page.HomePage;
import com.NewSElTest.page.LoginPage;
import com.NewSElTest.util.XLutils;
import com.NewSElTest.util.utilOperation;

//@Listeners(com.NewSElTest.utility.NewUtilResult.class)
@Listeners(com.NewSElTest.utility.Reporting.class)
public class HomeTest extends TestBase {
	
	LoginPage lopo;
	HomePage  hopo;
	utilOperation utilOp;
	
	public HomeTest()
	{
		super();
	}
	
	@BeforeMethod	
	public void setup() throws InterruptedException
	{
		intialization();
		lopo=new LoginPage();
		lopo.clicksignIn(prop.getProperty("newUser"), prop.getProperty("passw"));
		hopo=new HomePage();
		utilOp=new utilOperation();
	}
	@Test(priority=2,dataProvider="HomeData")
	public void validateSearch(String sysUser1,String empName1) throws Exception
	{
		//hopo.verifySysUser();
		hopo.verifySysUser(sysUser1,empName1);
	//	String title=utilOperation.getPageTitle();
	//	Assert.assertEquals(title, prop.getProperty("productTile"));
	}
	@Test(priority=1,dataProvider="HomeData")
	public void ValidateUser(String sysUser1,String empName1) throws InterruptedException
	{
		//hopo.verifyAddUsers();
		hopo.verifyAddUsers(sysUser1,empName1);
			
	}
	
	@DataProvider(name="HomeData")
	String[][] getData() throws IOException
	{
		String path="C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/src/main/java/com/NewSElTest/TestData/testData.xlsx";
		int rownum=XLutils.getRowCount(path, "Sheet2");
		int colcount=XLutils.getCellCount(path, "Sheet2", 1);
		String logindata[][]=new String [rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLutils.getCellData(path, "Sheet2", i, j);
			}
		}
		return logindata;
	}
	
		@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
