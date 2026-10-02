package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class CategoryTest extends Base {
	HomePage hp;
	CategoryPage categoryPage;

	@Test
	public void verifyWhetherUserIsAbledToAddNewCategory() throws IOException, AWTException {

		LoginPage lp = new LoginPage(driver);
		RandomDataUtility rd = new RandomDataUtility();
		String category = rd.generateCategoryText();
		String usernameValue = ExcelUtility.getStringData(0, 0, "Login");
		String passwordValue = ExcelUtility.getStringData(0, 1, "Login");
		lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		categoryPage = hp.clickCategoryMoreInfo().clickNewCategory()
				.typeCategory(category).clickGroup().uploadFile().clickSaveButton();
		Assert.assertTrue(categoryPage.isSuccessAlertVisible(), Constant.NEWCATEGORY_ERROR);
	}

	@Test
	public void verifyWhetherUserIsAbledToSearchCategory() throws IOException {

		LoginPage lp = new LoginPage(driver);
		String usernameValue = ExcelUtility.getStringData(0, 0, "Login");
		String passwordValue = ExcelUtility.getStringData(0, 1, "Login");
		String searchCategoryName = "ABCDEF";
		lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickLoginButton();
		categoryPage = hp.clickCategoryMoreInfo().clickSearchManageDeliveryBoyTopButton()
				.typeInSearchCategory(searchCategoryName).ClickOnsearchCategoryButton();
		Assert.assertEquals(categoryPage.categorySearchResultTableFirstCellValue(), searchCategoryName,
				Constant.SEARCHCATEGORY_ERROR);
	}
}
