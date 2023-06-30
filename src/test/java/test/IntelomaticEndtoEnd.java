package test;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
import pages.CollectorFilterPage;
import pages.CollectorLayerListPage;
import pages.CollectorPage;
import pages.CollectorSearchPage;
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
@Listeners({ TestAllureListener.class })
public class IntelomaticEndtoEnd extends Common {

	@BeforeClass
	public void initialize() throws MalformedURLException {
		SetUp();
	}

	@Test(dataProvider = "DocFileRead", priority = 0)
	@Description("Verify the login test")
	@Epic("Login end to end flow")
	@Feature("Login Feature")
	@Story("login and create and fill collector layer details and log out")
	@Severity(SeverityLevel.CRITICAL)
	public void LoginTestCases(String rowsCount) throws InterruptedException {
		try {
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
			LoginPage loginPage = new LoginPage();
			loginPage.login(driver, list.get(2), list.get(3));
			// permission.clickOnAllow(driver); // For Notification
			Ndms2Page ndms = new Ndms2Page();
			boolean ndsm2Text = ndms.VerifyNDMS2Page(driver);
			Assert.assertTrue(ndsm2Text);
			ndms.clickOnMapView(driver);
			ndms.clickOnConfirmOKButton(driver);
			UpdatePage update = new UpdatePage();
			update.clickOnNoButtonOnNewVersionDetected(driver);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Create Scenario
	@Test(priority = 1)
	@Description("Verify the create collector layer form test")
	@Epic(" Creation of the Collector form ")
	@Feature("Collector Feature")
	@Story("Create and fill collector layer details and log out")
	@Severity(SeverityLevel.CRITICAL)
	public void CreateCollectortTestCases() throws InterruptedException {
		try {
			MapPage map = new MapPage();
			map.clickOnCollectorIcon(driver);
			CollectorPage collector = new CollectorPage();
			Thread.sleep(1000);
			// update.clickOnNoButtonOnNewVersionDetected(driver);
			collector.clickOnAddNewCollectorIcon(driver);
			CreateCollectorLayerPage create = new CreateCollectorLayerPage();
			create.enterClientName(driver, "Automation");
			create.enterPurposeOfMeeting(driver, "Automation test");
			create.enterMinutesOfMeeting(driver, "Automation test is running");
			create.SelectFollowUpDate(driver);
			create.SelectLocation(driver);
			create.UploadImage(driver, "Uploading a raw image");
			Thread.sleep(2000);
			create.takeCameraImage(driver, "Taking a camera image");
			create.clickOnSaveButton(driver);
			Thread.sleep(2000);
			boolean record = collector.VerifyRecordAddedSucessfully(driver, "Automation");

			SoftAssert softAssert = new SoftAssert();

			softAssert.assertTrue(record);

			softAssert.assertAll();
		} catch (Exception e) {

		}
	}

	// Preview Scenario
	@Test(priority = 2)
	@Description("Verify the prview of collector layer")
	@Epic(" Preview of the Collector form ")
	@Feature("Collector Feature")
	@Story("View of verify of collector layer details")
	@Severity(SeverityLevel.CRITICAL)
	public void PreviewCollectortTestCases() throws InterruptedException {
		try {

			CollectorPage collector = new CollectorPage();
			SoftAssert softAssert = new SoftAssert();

			collector.clickOn3Dots(driver);
			Thread.sleep(1000);
			collector.clickOnPreviewRecord(driver);
			Thread.sleep(1000);
			boolean recordPreview = collector.VerifyPreviewCollectorLayerIsDisplayed(driver);
			softAssert.assertTrue(recordPreview);
			collector.clickOnBackButton(driver);
			Thread.sleep(1000);

			softAssert.assertAll();
		} catch (Exception e) {

		}
	}

	// Edit Scenario
	@Test(priority = 3)
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
		} catch (Exception e) {

		}

	}

	@Test(priority = 4)
	@Description("Verify the create collector layer form test")
	@Epic(" Creation of the Collector form ")
	@Feature("Collector Feature")
	@Story("Create and fill collector layer details and log out")
	@Severity(SeverityLevel.CRITICAL)
	public void CreateNewCollectortTestCases() throws InterruptedException {
		try {
			CollectorPage collector = new CollectorPage();

			SoftAssert softAssert = new SoftAssert();
			CreateCollectorLayerPage create = new CreateCollectorLayerPage();

			collector.clickOnAddNewCollectorIcon(driver);
			create.enterClientName(driver, "New Added Automation");
			create.enterPurposeOfMeeting(driver, "New Added Automation");
			create.enterMinutesOfMeeting(driver, "New Automation test is running");
			create.SelectFollowUpDate(driver);
			create.SelectLocation(driver);
			// create.UploadImage(driver, "Uploading a raw image");
			create.clickOnSaveButton(driver);
			Thread.sleep(2000);
			boolean newRecordAdded = collector.VerifyRecordAddedSucessfully(driver, "New Added Automation");
			softAssert.assertTrue(newRecordAdded);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	// Search Scenario
	@Test(priority = 5)
	@Description("Verify the search result of collector layers")
	@Epic(" Search result data of the Collector form ")
	@Feature("Collector Feature")
	@Story("Search and verify the search result of collector layers")
	@Severity(SeverityLevel.NORMAL)
	public void SearchPageTestCases() throws InterruptedException {
		try {

			CollectorSearchPage search = new CollectorSearchPage();
			SoftAssert softAssert = new SoftAssert();
			CollectorPage collector = new CollectorPage();

			collector.clickOnSearchIcon(driver);
			Thread.sleep(1000);
			search.searchLayerRecord(driver, "Automation");
			Thread.sleep(1000);
			boolean searchRecord = search.verifySearchResultData(driver);
			softAssert.assertTrue(searchRecord);
			Thread.sleep(4000);

			// search.clickOn3DotsOnSP(driver);
			search.clickOnThreeDotsOnSP(driver);
			Thread.sleep(1000);
			search.clickOnPreviewOnSP(driver);
			Thread.sleep(1000);
			boolean previewRecord = search.VerifyPreviewCollectorLayerIsDisplayedOnSP(driver);
			softAssert.assertTrue(previewRecord);
			Thread.sleep(1000);
			search.clickOnBackButtonOnSP(driver);
			Thread.sleep(1000);
			search.clickOnCloseButton(driver);

			softAssert.assertAll();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// Filter Scenario
	@Test(priority = 6)
	@Description("Verify the filter of collector layers")
	@Epic(" Filter result data of the Collector form ")
	@Feature("Collector Feature")
	@Story("Filter options and verify the filter result of collector layers")
	@Severity(SeverityLevel.NORMAL)
	public void FilterPageTestCases() throws InterruptedException {
		try {

			CollectorFilterPage filter = new CollectorFilterPage();
			SoftAssert softAssert = new SoftAssert();
			CollectorPage collector = new CollectorPage();

			collector.clickOnFilterIcon(driver);
			Thread.sleep(1000);
			boolean filterRecord = filter.verifyFilterPageIsDisplayed(driver);
			softAssert.assertTrue(filterRecord);
			Thread.sleep(1000);

			filter.clickOnCreateDate(driver);
			Thread.sleep(1000);
			filter.selectCurrentDate(driver);
			Thread.sleep(1000);
			filter.clickOnAddFilterButton(driver);
			Thread.sleep(1000);
			filter.selectClientName(driver);
			Thread.sleep(1000);
			filter.enterTextInAddFilter(driver, "New Added Automation");
			Thread.sleep(1000);
			filter.clickOnApplyButton(driver);
			Thread.sleep(1000);
			boolean appliedFilter = filter.verifyFilterPageIsApplied(driver);
			softAssert.assertTrue(appliedFilter);

			softAssert.assertAll();
			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}

	// Collector Layer List
	@Test(priority = 7)
	@Description("Verify the Collector layer list")
	@Epic(" Selecting the Collector layer list from the Collector page ")
	@Feature("Collector Feature")
	@Story("Select the collector layer")
	@Severity(SeverityLevel.NORMAL)
	public void SelectCollectorLayertTestCases() throws InterruptedException {

		try {
			CollectorPage collector = new CollectorPage();
			CollectorLayerListPage list = new CollectorLayerListPage();
			SoftAssert softAssert = new SoftAssert();

			collector.clickOnLayerListButton(driver);
			Thread.sleep(1000);
			boolean verifyList = list.verifyLayerListPageIsDisplayed(driver);
			softAssert.assertTrue(verifyList);
			Thread.sleep(1000);

			list.selectCollectorLayerList(driver);
			Thread.sleep(1000);
			softAssert.assertAll();

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	// Remove Scenario
	@Test(priority = 8)
	@Description("Verify the Remove collector layer")
	@Epic(" Removing of the Collector form ")
	@Feature("Collector Feature")
	@Story("Remove the collector layer")
	@Severity(SeverityLevel.NORMAL)
	public void RemoveCollectortTestCases() throws InterruptedException {

		try {
			CollectorPage collector = new CollectorPage();

			SoftAssert softAssert = new SoftAssert();

			collector.clickOn3Dots(driver);
			collector.clickOnRemoveRecord(driver);
			Thread.sleep(1000);
			collector.clickOnOKButton(driver);
			Thread.sleep(1000);
			boolean removeRecord = collector.verifyRemovedRecord(driver);
			softAssert.assertTrue(removeRecord);

			softAssert.assertAll();

			Thread.sleep(2000);
		} catch (Exception e) {

		}

	}

	// Publish Scenario
	@Test(priority = 9)
	@Description("Verify the publish collector layer")
	@Epic(" Publishing of the Collector form ")
	@Feature("Collector Feature")
	@Story("Publish the collector layer record")
	@Severity(SeverityLevel.NORMAL)
	public void PublishCollectortTestCases() throws InterruptedException {

		try {
			CollectorPage collector = new CollectorPage();

			SoftAssert softAssert = new SoftAssert();

			collector.clickOn3Dots(driver);
			collector.clickOnPublishRecord(driver);
			collector.clickOnOKButton(driver);

			collector.clickOnOnline(driver);
			boolean verifyPublish = collector.VerifyPublishedRecordIsDisplayed(driver);
			softAssert.assertTrue(verifyPublish);

			softAssert.assertAll();

		} catch (Exception e) {

		}

	}

	@Test(priority = 10)
	@Description("Verify the create collector layer form test")
	@Epic(" Creation of the Collector form ")
	@Feature("Collector Feature")
	@Story("Create and fill collector layer details and log out")
	@Severity(SeverityLevel.CRITICAL)
	public void NewCreateCollectortTestCases() throws InterruptedException {
		try {
			CollectorPage collector = new CollectorPage();

			SoftAssert softAssert = new SoftAssert();
			CreateCollectorLayerPage create = new CreateCollectorLayerPage();

			collector.clickOnLocal(driver);

			collector.clickOnAddNewCollectorIcon(driver);
			create.enterClientName(driver, "New Added Automation");
			create.enterPurposeOfMeeting(driver, "New Added Automation");
			create.enterMinutesOfMeeting(driver, "New Automation test is running");
			create.SelectFollowUpDate(driver);
			create.SelectLocation(driver);
			// create.UploadImage(driver, "Uploading a raw image");
			create.clickOnSaveButton(driver);
			Thread.sleep(2000);
			boolean newRecordAdded = collector.VerifyRecordAddedSucessfully(driver, "New Added Automation");
			softAssert.assertTrue(newRecordAdded);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Test(priority = 11)
	@Description("Publish all of the collector layers")
	@Epic(" Publish all of the Collector layers ")
	@Feature("Collector Feature")
	@Story("Publish all of the collector layers")
	@Severity(SeverityLevel.NORMAL)
	public void PublishAllCollectorsTestCases() throws InterruptedException {
		try {

			SoftAssert softAssert = new SoftAssert();
			CollectorPage collector = new CollectorPage();

			Thread.sleep(2000);
			collector.clickOnPublishAllButton(driver);
			boolean publishAllSuccess = collector.verifyPublishAllMethod(driver);
			softAssert.assertTrue(publishAllSuccess);
			Thread.sleep(1000);
			collector.clickOnOnline(driver);
			Thread.sleep(1000);
			boolean publishRecord = collector.VerifyPublishedRecordIsDisplayed(driver);
			softAssert.assertTrue(publishRecord);
			Thread.sleep(4000);

			softAssert.assertAll();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Test(priority = 12)
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

		} catch (Exception e) {

		}

	}

	@AfterClass
	public void Teardown() throws MalformedURLException {
		driver.quit();
	}

}
