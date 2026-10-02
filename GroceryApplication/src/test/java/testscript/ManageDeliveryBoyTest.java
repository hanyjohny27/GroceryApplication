package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base {
	HomePage hp;
	ManageDeliveryBoyPage manageDeliveryBoyPage;
	@Test
	public void verifyWhetherUserIsAbledToAddNewDeliveryBoy() throws IOException
	{
		
		
		LoginPage lp = new LoginPage(driver);
		RandomDataUtility rd=new RandomDataUtility();
		String usernameValue = ExcelUtility.getStringData(0, 0, "Login");
		String passwordValue = ExcelUtility.getStringData(0, 1, "Login");
		String newDeliveryBoyName=rd.generateFullName();
		String newDeliveryBoyEmail=rd.generateRandomEmailId();
		String newDeliveryBoyAddress=rd.generateRandomAddress();
		String newDeliveryBoyPhone=rd.generateRandomPhoneNumber();
		String newUserNameValue=rd.generateRandomUserName();
		String newPasswordValue=rd.generateRandomPassword();
		
		
		lp.enterUsernameOnUserNameField(usernameValue)
		.enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		manageDeliveryBoyPage=hp.clickManageDeliveryBoyMoreInfo()
	.clicknewManageDeliveryBoyButton()
			.typeName(newDeliveryBoyName)
				.typeEmail(newDeliveryBoyEmail)
				.typeMobile(newDeliveryBoyPhone)
				.typeAddress(newDeliveryBoyAddress)
				.typeUserName(newUserNameValue)
				.typePassword(newPasswordValue)
				.clickSaveButton();
		Assert.assertTrue(manageDeliveryBoyPage.isSuccessAlertVisible(),Constant.NEWDELIVERYBOY_ERROR );
		
	}
	@Test
	public void verifyWhetherUserIsAbledToSearchDeliveryBoy() throws IOException
	{
		//HomePage hp = new HomePage(driver);
	//	ManageDeliveryBoyPage manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		LoginPage lp = new LoginPage(driver);
		//RandomDataUtility rd=new RandomDataUtility();
		String usernameValue = ExcelUtility.getStringData(0, 0, "Login");
		String passwordValue = ExcelUtility.getStringData(0, 1, "Login");
		String searchUName="Tibin";
		lp.enterUsernameOnUserNameField(usernameValue)
		.enterPasswordOnPasswordField(passwordValue);
		hp=lp.clickLoginButton();
		manageDeliveryBoyPage=hp.clickManageDeliveryBoyMoreInfo()
		.clickSearchManageDeliveryBoyTopButton()
		.TypeInSearchDeliveryBoyName("Tibin")
	//	manageDeliveryBoyPage.TypeInsearchManageDeliveryBoyEmail(passwordValue);
		.ClickOnsearchDeliveryBoyButton();
		Assert.assertEquals(manageDeliveryBoyPage.manageDeliveryBoySearchResultTableFirstCellValue(), searchUName,Constant.SEARCHDELIVERYBOY_ERROR);
		
	}
	

}
