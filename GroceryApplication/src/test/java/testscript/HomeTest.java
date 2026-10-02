package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import constant.Constant;

public class HomeTest extends Base {
	HomePage hp;

	@Test
	public void verifyWhetherUserisAbledToSuccessfullyLoggedOut() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "Login");
		String passwordValue = ExcelUtility.getStringData(0, 1, "Login");
		LoginPage lp = new LoginPage(driver);

		lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickLoginButton();

		hp.clickAdminDropdown();
		lp = hp.clickLogoutLink();

		String actual = lp.verifyLoginPageTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.LOGOUT_ERROR);

	}

}
