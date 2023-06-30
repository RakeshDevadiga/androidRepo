package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class SetupPage extends Common {

	public SetupPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Enter link")
	public void enterDemoLink(AppiumDriver<MobileElement> driver, String link) {
		driver.findElement(By.xpath("//*[@text='Paste link in here']")).sendKeys(link);
	}

	@Step("Click on Continue")
	public void clickOnContinue(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='Continue']")).click();
	}

}
