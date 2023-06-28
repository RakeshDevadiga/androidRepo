package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class MapPage extends Common{
	public MapPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click on Collector Icon")
	public void clickOnCollectorIcon(AppiumDriver<MobileElement> driver) {
		try {
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//*[@text='Collector']")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@text='Collector']")).click();
			System.out.println("Click on Collector Icon");
		}
		Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
