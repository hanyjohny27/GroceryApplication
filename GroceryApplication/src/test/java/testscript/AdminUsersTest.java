package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {
	HomePage hp;
	AdminUsersPage adminUsersPage;

	@Test
	public void verifyWhetherUserIsAbledToAddNewAdminUser() throws IOException {

		LoginPage lp = new LoginPage(driver);
		RandomDataUtility rd = new RandomDataUtility();
		String newUserNameValue = rd.generateRandomUserName();
		String newPasswordValue = rd.generateRandomPassword();
		String usernameValue = ExcelUtility.getStringData(0, 0, "Login");
		String passwordValue = ExcelUtility.getStringData(0, 1, "Login");
		lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickLoginButton();
		adminUsersPage = hp.clickAdminUsersMoreInfo().clickNewAdminUsersButton()
				.typeNewAdminUserName(newUserNameValue).typeNewAdminPassword(newPasswordValue).selectUserType()
				.clickOnSaveButton();
		Assert.assertTrue(adminUsersPage.isSuccessAlertVisible(),Constant.NEWADMINUSER_ERROR );
	}

	@Test
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedAdminUser() throws IOException {

		LoginPage lp = new LoginPage(driver);
		String searchUName = "Tibin";
		String usernameValue = ExcelUtility.getStringData(0, 0, "Login");
		String passwordValue = ExcelUtility.getStringData(0, 1, "Login");
		lp.enterUsernameOnUserNameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickLoginButton();
		adminUsersPage = hp.clickAdminUsersMoreInfo().clickSearchAdminUsersTopButton()
				.TypeSearchAdminUsersUserName(searchUName).SelectsearchAdminUsersUserType()
				.clickAdminUsersSearchButton();
		Assert.assertEquals(adminUsersPage.adminUserSearchResultTableFirstCellValue(), searchUName,
				Constant.SEARCHADMINUSER_ERROR);

	}
}
