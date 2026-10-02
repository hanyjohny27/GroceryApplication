package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	
	public WaitUtility wu=new  WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']") WebElement uname;
	@FindBy(xpath="//input[@name='password']") WebElement pwd;
	@FindBy(xpath="//button[@type='submit']") WebElement loginBtn;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashBoard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginPageText;
	
	
	
	public LoginPage enterUsernameOnUserNameField(String userName)
	{
		uname.sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		pwd.sendKeys(password);
		return this;
	}
	
	public HomePage clickLoginButton()
	{
		wu.waitUntilElementToBeClickable(driver, loginBtn);
		loginBtn.click();
		return new HomePage(driver);
	}
	
	public boolean verifyWhetherDashboardisDisplayed()
	{
		return dashBoard.isDisplayed();
	}
	
	public String verifyLoginPageTextIsDisplayed()
	{
		
		return loginPageText.getText();
	}
	

}
