
package com.NewSElTest.TestPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NewSElTest.Base.TestBase;
import com.NewSElTest.page.LoginPage;
import com.NewSElTest.util.XLutils;
import com.NewSElTest.util.utilOperation;



//@Listeners(com.NewSElTest.utility.NewUtilResult.class)
@Listeners(com.NewSElTest.utility.Reporting.class)
public class LoginTest extends TestBase{
	
	LoginPage lopo;
	utilOperation utioOp;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		lopo = new LoginPage();
		utioOp=new utilOperation();
	}
	
	@Test
	public void validatePageTitle() throws Exception
	{
		logger1.info("Page title is validating");
		String pageTitle=utilOperation.getPageTitle();
		Assert.assertEquals(pageTitle, "OrangeHRM");
	}
	@Test(dataProvider="LoginData")
	public void validateAccont(String uname,String paswd) throws InterruptedException, IOException
	{
		logger1.info("Login data is passing");
		lopo.clicksignIn(uname,paswd);
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path="C:/Users/rajam/eclipse-workspace/com.org.NewSelTestProj/src/main/java/com/NewSElTest/TestData/testData.xlsx";
		int rownum=XLutils.getRowCount(path, "Sheet1");
		int colcount=XLutils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String [rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLutils.getCellData(path, "Sheet1", i, j);
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
