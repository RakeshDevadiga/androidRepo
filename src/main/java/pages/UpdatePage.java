package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class UpdatePage extends Common{
	public UpdatePage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click on No in New Version Detedted Pop up")
	public void clickOnNoButtonOnNewVersionDetected(AppiumDriver<MobileElement> driver) throws InterruptedException {
		try {
		driver.findElement(By.xpath("//*[@text='New version detected']/..//*[@text='No']")).click();
		System.out.println("Click on No in New Version Detedted Pop up");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(13000);
		}
	
	catch (StaleElementReferenceException e) 
	{
		if(driver.findElement(By.xpath("//*[@text='New version detected']/..//*[@text='No']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@text='New version detected']/..//*[@text='No']")).click();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
	}
	}
}
