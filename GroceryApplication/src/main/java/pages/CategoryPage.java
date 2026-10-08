package pages;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = " //a[contains(text(),'New')]")
	WebElement newCategoryButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryText;
	@FindBy(xpath = "//div[@id='ms-grp_id']//li[1]")
	WebElement selectGroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile1;
	@FindBy(xpath = "//input[@type='file']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement newCategorysuccessAlert;
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	WebElement categorySearchResultTableFirstCell;
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement searchCategoryTopButton;
	@FindBy(xpath = "//input[@name=\"un\"]")
	WebElement typeInsearchCategory;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchCategory;

	public CategoryPage clickNewCategory() {
		newCategoryButton.click();
		return this;
	}
	public CategoryPage typeCategory(String category) {
		categoryText.sendKeys(category);
		return this;
	}
	public CategoryPage clickGroup() {
		selectGroup.click();
		return this;
	}
	public CategoryPage clickChooseFile() {
		Actions actions = new Actions(driver);
		actions.moveToElement(chooseFile).click().perform();
		return this;
	}
	public CategoryPage clickSaveButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(saveButton).click().perform();
		return this;
	}
	public CategoryPage uploadFile() throws AWTException {
		chooseFile1.sendKeys("D:\\abacus-master\\hany\\level-3-result.png");
		return this;
	}
	public boolean isSuccessAlertVisible() {
		return newCategorysuccessAlert.isDisplayed();
		
	}
	public CategoryPage clickSearchManageDeliveryBoyTopButton() {
		searchCategoryTopButton.click();
		return this;
	}
	public CategoryPage typeInSearchCategory(String categoryName) {
		typeInsearchCategory.sendKeys(categoryName);
		return this;
	}
	public CategoryPage ClickOnsearchCategoryButton() {
		searchCategory.click();
		return this;
	}
	public String categorySearchResultTableFirstCellValue() {
		return categorySearchResultTableFirstCell.getText();
	}
}
