package test;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
import pages.LoginPage;
import pages.ManageAccountPage;
import pages.MapPage;
import pages.Ndms2Page;
import pages.PermissionPage;
import pages.SetupPage;
import pages.UpdatePage;

	@Listeners({ TestAllureListener.class })
	public class CreateCollectorTest1 extends Common
	{
			
		@BeforeClass
		public void initialize() throws MalformedURLException {
			SetUp();
		}
		
		@Test(priority = 0, description = "verifying login page title test")
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Case Description: Verify login page title test on Login Page")
		@Story("Story Name: To check login page title")
		public void CreationCases(String rowsCount) throws InterruptedException {
			try {

				int Row_number = Integer.parseInt(rowsCount);
				
				List<String> list = Utility.getRowData("userData", "Sheet1", Row_number);
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
				
				
				SoftAssert softAssert = new SoftAssert();
				
				softAssert.assertAll();
				// Assert.assertTrue(true);
				// Assert.assertFalse(true);
				// loginPage.TearDown();

				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
		@Test(priority = 1, dataProvider = "DocFileReadFormCreation")
		@Description("Verify the create collector layer form test")
		@Epic(" Creation of the Collector form ")
		@Feature("Collector Feature")
		@Story("Create and fill collector layer details and log out")
		@Severity(SeverityLevel.CRITICAL)
		public void CreateCollectortTestCases(String rowsCount) throws InterruptedException {
			try {
				int Row_number = Integer.parseInt(rowsCount);
				List<String> list = Utility.getRowData("userData", "Sheet2", Row_number);
				MapPage map = new MapPage();
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
			} 
			catch (Exception e) {

			}
		}
		
		
	
		@Test(priority = 2)
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
		@AfterClass
		public void Teardown() throws MalformedURLException {
			driver.quit();
		}
	}
