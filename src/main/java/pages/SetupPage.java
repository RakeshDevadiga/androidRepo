package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SetupPage extends Common {

	public SetupPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterDemoLink(AppiumDriver<MobileElement> driver, String link) {
		driver.findElement(By.xpath("//*[@text='Paste link in here']")).sendKeys(link);
	}

	public void clickOnContinue(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='Continue']")).click();
	}

}
