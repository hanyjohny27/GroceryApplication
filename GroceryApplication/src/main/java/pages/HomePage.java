package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='img-circle']") WebElement adminDropdown;
	@FindBy(xpath="//div[contains(@class, 'dropdown-menu')]//a[contains(@href, 'logout')]") WebElement logoutLink;;
	@FindBy(xpath="//div[@class='col-lg-3 col-6']//a[contains(@href, 'admin/list-admin')]") WebElement adminUsersMoreInfo;
	@FindBy(xpath="//div[@class='col-lg-3 col-6']//a[contains(@href, 'admin/list-deliveryboy')]") WebElement manageDeliveryBoyMoreInfo;
	@FindBy(xpath="//div[@class='col-lg-3 col-6']//a[contains(@href, 'admin/list-category')]") WebElement categoryMoreInfo;
	
	public HomePage clickAdminDropdown()
	{
		adminDropdown.click();
		return this;
	}
	
	public LoginPage clickLogoutLink()
	{
		logoutLink.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickAdminUsersMoreInfo()
	{
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageDeliveryBoyPage clickManageDeliveryBoyMoreInfo()
	{
		manageDeliveryBoyMoreInfo.click();
		return new ManageDeliveryBoyPage(driver);
	}
	
	public CategoryPage clickCategoryMoreInfo()
	{
		categoryMoreInfo.click();	
		return new CategoryPage(driver);
	}
}
