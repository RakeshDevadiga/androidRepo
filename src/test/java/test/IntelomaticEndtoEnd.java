package test;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
@Listeners({TestAllureListener.class})
public class IntelomaticEndtoEnd extends Common {

	@BeforeMethod
	public void initialize() throws MalformedURLException {
		SetUp();
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "DocFileRead")
	@Description("Verify the login test")
	@Epic("Login end to end flow")
	@Feature("Login Feature")
	@Story("login and create and fill collector layer details and log out")
	@Severity(SeverityLevel.CRITICAL)
	public void EndtoEndFlowTest(String rowsCount) throws InterruptedException {
		try {
			System.out.println("Rowcount " + rowsCount);
			int Row_number = Integer.parseInt(rowsCount);
			
			List<String> list = Utility.getRowData("userData", "Sheet1", Row_number);
			List<String> collectrData = Utility.getRowData("userData", "Sheet2", Row_number);
			SetupPage setupPage = new SetupPage();
			setupPage.enterDemoLink(driver,list.get(1));
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
			//permission.clickOnAllow(driver); // For Notification
			Ndms2Page ndms = new Ndms2Page();
			boolean ndsm2Text = ndms.VerifyNDMS2Page(driver);
			Assert.assertTrue(ndsm2Text);
			// softAssert.assertEquals(ndsm2Text, false);
			// softAssert.assertTrue(ndsm2Text);
			ndms.clickOnMapView(driver);
			ndms.clickOnConfirmOKButton(driver);
			UpdatePage update = new UpdatePage();
			update.clickOnNoButtonOnNewVersionDetected(driver);
			MapPage map = new MapPage();
			map.clickOnCollectorIcon(driver);
			
			SoftAssert softAssert = new SoftAssert();
			CollectorPage collector = new CollectorPage();
			CreateCollectorLayerPage create = new CreateCollectorLayerPage();
			EditCollectorLayerPage edit = new EditCollectorLayerPage();
			
			//Create Scenario
			collector.clickOnAddNewCollectorIcon(driver);
			create.enterClientName(driver, collectrData.get(1));
			create.enterPurposeOfMeeting(driver, collectrData.get(2));
			create.enterMinutesOfMeeting(driver, collectrData.get(3));
			create.SelectFollowUpDate(driver);
			create.SelectLocation(driver);
			create.UploadImage(driver, "Uploading a raw image");
			create.clickOnSaveButton(driver);
			Thread.sleep(2000);
			boolean recordAdded = collector.VerifyRecordAddedSucessfully(driver,collectrData.get(1));
			softAssert.assertTrue(recordAdded);
			
			//Preview Scenario
			collector.clickOn3Dots(driver);
			Thread.sleep(1000);
			collector.clickOnPreviewRecord(driver);
			Thread.sleep(1000);
			boolean recordPreview = collector.VerifyPreviewCollectorLayerIsDisplayed(driver);			
			softAssert.assertTrue(recordPreview);
			collector.clickOnBackButton(driver);
			Thread.sleep(1000);
			
			//Edit Scenario
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
			
			//Remove Scenario
			collector.clickOnAddNewCollectorIcon(driver);
			create.enterClientName(driver, "New Added Automation");
			create.enterPurposeOfMeeting(driver, "New Added Automation");
			create.enterMinutesOfMeeting(driver, "New Automation test is running");
			create.SelectFollowUpDate(driver);
			create.SelectLocation(driver);
			create.UploadImage(driver, "Uploading a raw image");
			create.clickOnSaveButton(driver);
			Thread.sleep(2000);
			boolean newRecordAdded = collector.VerifyRecordAddedSucessfully(driver, "New Added Automation");
			softAssert.assertTrue(newRecordAdded);
			
			collector.clickOn3Dots(driver);
			collector.clickOnRemoveRecord(driver);
			Thread.sleep(1000);
			collector.clickOnOKButton(driver);
			Thread.sleep(1000);
			boolean removeRecord = collector.verifyRemovedRecord(driver);
			softAssert.assertTrue(removeRecord);
				
			//Publish Scenario
			collector.clickOn3Dots(driver);
			collector.clickOnPublishRecord(driver);
			collector.clickOnOKButton(driver);
			collector.clickOnOnline(driver);
			collector.VerifyPublishedRecordIsDisplayed(driver);
			Thread.sleep(1000);
			
			//Logout
			collector.clickOnManageAccount(driver);
			Thread.sleep(1000);
			ManageAccountPage manage = new ManageAccountPage();
			manage.clickOnLogOut(driver);
			
			softAssert.assertAll();
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	@AfterTest
	public void Teardown() throws MalformedURLException {
		driver.quit();
	}
}
