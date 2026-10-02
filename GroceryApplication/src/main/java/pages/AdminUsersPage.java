package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pu=new PageUtility();
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=" //a[contains(text(),'New')]") WebElement newAdminUsersButton;
	@FindBy(xpath="//input[@id='username']") WebElement newAdminUName;
	@FindBy(xpath="//input[@id='password']") WebElement newAdminPwd;
	@FindBy(xpath="//select[@id='user_type']") WebElement selectUserType;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement successAlert;
	@FindBy(xpath="//button[@name='Create']") WebElement saveButton;
	@FindBy(xpath="//a[contains(text(),'Search')]") WebElement searchAdminUsersTopButton;
	@FindBy(xpath="//input[@id='un']") WebElement searchAdminUsersUserName;
	@FindBy(xpath="//select[@id='ut']") WebElement searchAdminUsersUserType;
	@FindBy(xpath="//button[@name='Search']") WebElement searchAdminUsers;
	@FindBy(xpath="//table//tbody//tr[1]//td[1]") WebElement adminUsersearchResultTableFirstCell;
		
	public AdminUsersPage clickNewAdminUsersButton()
	{
		newAdminUsersButton.click();
		return this;
	}
	
	public AdminUsersPage typeNewAdminUserName(String uname)
	{
		newAdminUName.sendKeys(uname);
		return this;
	
	}
	
	public AdminUsersPage typeNewAdminPassword(String pwd)
	{
		newAdminPwd.sendKeys(pwd);
		return this;
	}
	
	public AdminUsersPage selectUserType()
	{
		pu.selectDropdownByVisibleText(selectUserType, "Admin");
		return this;
		
	}

	public boolean isSuccessAlertVisible()
	{
		return successAlert.isDisplayed();
	}
	
	public AdminUsersPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public AdminUsersPage clickSearchAdminUsersTopButton()
	{
		searchAdminUsersTopButton.click();
		return this;
	}
	
	public AdminUsersPage TypeSearchAdminUsersUserName(String uname)
	{
		searchAdminUsersUserName.sendKeys(uname);
		return this;
	}
	
	public AdminUsersPage SelectsearchAdminUsersUserType()
	{
		//do here also -use pageutility
		Select select=new Select(searchAdminUsersUserType);
		select.selectByVisibleText("Admin");
		return this;
		
	}
	
	public AdminUsersPage clickAdminUsersSearchButton()
	{
		searchAdminUsers.click();
		return this;
	}
	
	public String adminUserSearchResultTableFirstCellValue()
	{
		return adminUsersearchResultTableFirstCell.getText();
	}
}
