
  package pages;
  
  import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import
  org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
  
  public class ManageDeliveryBoyPage {
	  WebDriver driver;
	  
		public ManageDeliveryBoyPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = " //a[contains(text(),'New')]")
		WebElement newManageDeliveryBoyButton;

		@FindBy(xpath = "//input[@id='name']")
		WebElement name;

		@FindBy(xpath = "//input[@id='email']")
		WebElement email;

		@FindBy(xpath = "//input[@id='phone']")
		WebElement mobile;

		@FindBy(xpath = "//textarea[@name='address']")
		WebElement address;

		@FindBy(xpath = "//input[@id='username']")
		WebElement username;

		@FindBy(xpath = "//input[@id='password']")
		WebElement password;
		
		@FindBy(xpath="//button[@name=\"create\"]")
		WebElement saveButton;
		@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement newDeliveryBoysuccessAlert;
		
		@FindBy(xpath="//a[contains(text(),'Search')]") WebElement searchManageDeliveryBoyTopButton;
		
		
		
		@FindBy(xpath="//input[@id='un']") WebElement searchDeliveryBoyName;
		
		@FindBy(xpath="//input[@id='ut']") WebElement searchManageDeliveryBoyEmail;
		
		@FindBy(xpath="//input[@id='ph']") WebElement searchManageDeliveryBoyPhone;
		
				
		@FindBy(xpath="//button[@name='Search']") WebElement searchDeliveryBoy;
		
		@FindBy(xpath="//table//tbody//tr[1]//td[1]") WebElement manageDeliveryBoysearchResultTableFirstCell;
		
		public ManageDeliveryBoyPage ClickOnsearchDeliveryBoyButton()
		{
			searchDeliveryBoy.click();
			return this;
		}
		

		public ManageDeliveryBoyPage clicknewManageDeliveryBoyButton() {
			newManageDeliveryBoyButton.click();
			return this;
		}

		public ManageDeliveryBoyPage typeName(String randomname) {
			name.sendKeys(randomname);
			return this;
		}

		public ManageDeliveryBoyPage typeEmail(String randomEmail) {
			email.sendKeys(randomEmail);
			return this;
		}

		public ManageDeliveryBoyPage typeMobile(String randomPhone) {
			mobile.sendKeys(randomPhone);
			return this;
		}

		public ManageDeliveryBoyPage typeAddress(String randomaddress) {
			address.sendKeys(randomaddress);
			return this;
		}

		public ManageDeliveryBoyPage typeUserName(String randomusername) {
			username.sendKeys(randomusername);
			return this;
		}

		public ManageDeliveryBoyPage typePassword(String randompassword) {
			password.sendKeys(randompassword);
			return this;
		}
		
		public ManageDeliveryBoyPage clickSaveButton()
		{
			
			WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(5));
			wb.until(ExpectedConditions.elementToBeClickable(saveButton));
			Actions actions = new Actions(driver);
		    actions.moveToElement(saveButton).click().perform();
		    return this;

			//saveButton.click();
		}
		
		public boolean isSuccessAlertVisible()
		{
			return newDeliveryBoysuccessAlert.isDisplayed();
			
		}
		public ManageDeliveryBoyPage clickSearchManageDeliveryBoyTopButton()
		{
			searchManageDeliveryBoyTopButton.click();
			return this;
		}
		public ManageDeliveryBoyPage TypeInSearchDeliveryBoyName(String deliveryBoyName)
		{
			searchDeliveryBoyName.sendKeys(deliveryBoyName);
			return this;
		}
		public ManageDeliveryBoyPage TypeInsearchManageDeliveryBoyEmail(String deliveryBoyEmail)
		{
			searchManageDeliveryBoyEmail.sendKeys(deliveryBoyEmail);
			return this;
		}
		public ManageDeliveryBoyPage TypeInsearchManageDeliveryBoyPhone(String deliveryBoyPhone)
		{
			searchManageDeliveryBoyPhone.sendKeys(deliveryBoyPhone);
			return this;
		}
		
		public String manageDeliveryBoySearchResultTableFirstCellValue()
		{
			return manageDeliveryBoysearchResultTableFirstCell.getText();
			
		}
		//public void search
  }