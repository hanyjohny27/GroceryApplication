package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
//import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	
	HomePage home;
	@Test (priority=1,description="user login with valid credentials")
	//,groups= {"smoke"}
	public void verifyUserLoginWithvalidUsernameAndPassword() throws IOException
	{
	    String usernameValue=ExcelUtility.getStringData(0, 0, "Login");
	    String passwordValue=ExcelUtility.getStringData(0, 1, "Login");
		LoginPage lp=new LoginPage(driver);
		
		lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home=lp.clickLoginButton();
		boolean dashboardValue=lp.verifyWhetherDashboardisDisplayed();
		Assert.assertTrue(dashboardValue,Constant.VALID_CREDENTIAL_ERROR);
		
	}
	@Test (priority=2,description="UserLoginWithinvalidUserNameAndinvalidPassword")
	//,retryAnalyzer=retry.Retry.class
	public void verifyUserLoginWithinvalidUNameAndPwd() throws IOException
	{
		 String usernameValue=ExcelUtility.getStringData(1, 0, "Login");
		    String passwordValue=ExcelUtility.getStringData(1, 1, "Login");
			LoginPage lp=new LoginPage(driver);
			
			lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();
			String actual=lp.verifyLoginPageTextIsDisplayed();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constant.INVALIDUSERNAME_AND_INVALIDPASSWORD_ERROR);
	}
	@Test (priority=3,description="UserLoginWithvalidUserNameAndinvalidPassword")
	public void verifyUserLoginWithvalidUnameAndInvalidPwd() throws IOException
	{
		 String usernameValue=ExcelUtility.getStringData(2, 0, "Login");
		    String passwordValue=ExcelUtility.getStringData(2, 1, "Login");
			LoginPage lp=new LoginPage(driver);
			//chaining pages
			lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();
			String actual=lp.verifyLoginPageTextIsDisplayed();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constant.VALIDUNAME_AND_INVALIDPWD_ERROR);
	}
	@Test (priority=4,description="user login with invalid credentials")
	//,groups= {"smoke"},dataProvider="LoginData"
   public void verifyUserLoginWithinvalidUnameAndValidPwd() throws IOException
   {
		//String usernameValue,String passwordValue--method parameters for taking data from dataprovider
		//when uncomment above code -comment belkow 2 lines of code
		 String usernameValue=ExcelUtility.getStringData(3, 0, "Login");
		    String passwordValue=ExcelUtility.getStringData(3, 1, "Login");
			LoginPage lp=new LoginPage(driver);
			
			lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();
			
			String actual=lp.verifyLoginPageTextIsDisplayed();
			String expected="7rmart supermarket";
			Assert.assertEquals(actual, expected,Constant.INVALIDUNAME_AND_VALIDPWD_ERROR);
   }
	
	@DataProvider(name="LoginData")
	public Object[][] getDataFromDataProvider()
	{
		return new Object[][]
				{
			new Object[] {"admin","admin22"},new Object[] {"admin123","admin123"}
				};
	}
   
  
}
