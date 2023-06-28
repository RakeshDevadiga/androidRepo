package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.Common;
import base.TestAllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.PermissionPage;
@Listeners({TestAllureListener.class})
public class FailTestDemo extends Common {

	@Test
	@Description("Verify the Failed test")
	@Epic("EP001")
	@Feature("Fail Feature")
	@Story("Story test")
	@Step("Verify Invalid feature")
	@Severity(SeverityLevel.CRITICAL)
	public void DemoFailTestCase() throws InterruptedException {
		try {
		setupPage.enterDemoLink(driver, "demo");
		setupPage.clickOnContinue(driver);
		PermissionPage permission = new PermissionPage();
		permission.clickOnLocationPermission(driver);
		Assert.assertFalse(true);

		Thread.sleep(2000);
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
