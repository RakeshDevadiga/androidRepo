package test;

import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Common;
import base.TestAllureListener;
import base.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.CollectorPage;
import pages.CreateCollectorLayerPage;
import pages.EditCollectorLayerPage;
import pages.LoginPage;
import pages.ManageAccountPage;
import pages.MapPage;
import pages.Ndms2Page;
import pages.PermissionPage;
import pages.SetupPage;
import pages.UpdatePage;

@SuppressWarnings("unchecked")
@Listeners({TestAllureListener.class})
public class EditCollectorTest extends Common {

	@Test(priority = 0, dataProvider = "DocFileRead")
	@Description("Verify the login test")
	@Epic("Login end to end flow")
	@Feature("Login Feature")
	@Story("login and create and fill collector layer details and log out")
	@Severity(SeverityLevel.CRITICAL)
	public void LoginTestCases(String rowsCount) throws InterruptedException {
		try {

			System.out.println("Rowcount " + rowsCount);
			int Row_number = Integer.parseInt(rowsCount);

			List<String> list = Utility.getRowData("userData", "Sheet1", Row_number);
			SetupPage setupPage = new SetupPage();
			setupPage.enterDemoLink(driver, list.get(1));
			setupPage.clickOnContinue(driver);
			Thread.sleep(2000);
			PermissionPage permission = new PermissionPage();
			permission.clickOnLocationPermission(driver);
			permission.allowOK(driver);
			permission.allowWhileUsingApp(driver);
			permission.clickOnAllowAllTimeRadio(driver);
			permission.clickOnBackButton(driver);
			permission.clickOnBatteryPermission(driver);
			permission.clickOnCameraPermission(driver);
			permission.allowWhileUsingApp(driver);
			permission.clickOnStoragePermission(driver);
			permission.clickOnAllow(driver);
			permission.clickOnGo(driver);

			// boolean loginStatus = login.ValidLogin(driver, list.get(2), list.get(3));

			LoginPage loginPage = new LoginPage();
			// loginPage.enterUsername(driver, list.get(2));
			// loginPage.enterPassword(driver, list.get(3));
			// loginPage.clickLogin(driver);
			loginPage.login(driver, list.get(2), list.get(3));
			// permission.clickOnAllow(driver); // For Notification
			Ndms2Page ndms = new Ndms2Page();
			boolean ndsm2Text = ndms.VerifyNDMS2Page(driver);
			Assert.assertTrue(ndsm2Text);
			// softAssert.assertEquals(ndsm2Text, false);
			// softAssert.assertTrue(ndsm2Text);
			ndms.clickOnMapView(driver);
			ndms.clickOnConfirmOKButton(driver);
			UpdatePage update = new UpdatePage();
			update.clickOnNoButtonOnNewVersionDetected(driver);

			SoftAssert softAssert = new SoftAssert();

			softAssert.assertAll();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Test(priority = 1)
	@Description("Verify the create collector layer form test")
	@Epic(" Creation of the Collector form ")
	@Feature("Collector Feature")
	@Story("Create and fill collector layer details and log out")
	@Severity(SeverityLevel.CRITICAL)
	public void CreateCollectortTestCases() throws InterruptedException {
		try {
			MapPage map = new MapPage();
			Thread.sleep(2000);
			map.clickOnCollectorIcon(driver);
			CollectorPage collector = new CollectorPage();
			// update.clickOnNoButtonOnNewVersionDetected(driver);
			collector.clickOnAddNewCollectorIcon(driver);
			CreateCollectorLayerPage create = new CreateCollectorLayerPage();
			create.enterClientName(driver, "Automation");
			create.enterPurposeOfMeeting(driver, "Automation test");
			create.enterMinutesOfMeeting(driver, "Automation test is running");
			create.SelectFollowUpDate(driver);
			create.SelectLocation(driver);
			create.UploadImage(driver, "Uploading a raw image");
			create.clickOnSaveButton(driver);
			Thread.sleep(2000);
			boolean record = collector.VerifyRecordAddedSucessfully(driver, "Automation");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(record);

			softAssert.assertAll();
		} catch (Exception e) {

		}
	}

	@Test(priority = 2)
	@Description("Verify the Edit collector layer form test")
	@Epic(" Editing of the Collector form ")
	@Feature("Collector Feature")
	@Story("Edit and fill collector layer details")
	@Severity(SeverityLevel.NORMAL)
	public void EditCollectortTestCases() throws InterruptedException {

		try {
			CollectorPage collector = new CollectorPage();
			EditCollectorLayerPage edit = new EditCollectorLayerPage();
			SoftAssert softAssert = new SoftAssert();
			collector.clickOn3Dots(driver);
			collector.clickOnEditRecord(driver);

			Thread.sleep(2000);
			edit.editClientName(driver, "Editing Automation");
			edit.editClientNameHere(driver, "Editing Automation");
			edit.editPurposeOfMeeting(driver, "Editing Automation");
			edit.editMinutesOfMeeting(driver, "Editing Automation test is running");
			Thread.sleep(1000);
			edit.clickOnUpdateButton(driver);
			Thread.sleep(1000);
			boolean recordUpdated = collector.VerifyRecordAddedSucessfully(driver, "Editing Automation");
			Thread.sleep(1000);
			softAssert.assertTrue(recordUpdated);
			softAssert.assertAll();
		} 
		catch (Exception e) {

		}

	}
	
	@Test(priority = 3)
	@Description("Verify the Logout functionality test")
	@Epic(" Logout form the App ")
	@Feature("Logout Feature")
	@Story("Logout from the app")
	@Severity(SeverityLevel.NORMAL)
	public void LogoutTestCase() throws InterruptedException {

		try {
			CollectorPage collector = new CollectorPage();
			collector.clickOnManageAccount(driver);
			Thread.sleep(1000);
			
			ManageAccountPage manage = new ManageAccountPage();
			manage.clickOnLogOut(driver);
			
		} 
		catch (Exception e) {

		}

	}
}
