package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class Ndms2Page extends Common{
	public Ndms2Page() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click on Confirm OK")
	public void clickOnConfirmOKButton(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		System.out.println("Click on Confirm Ok Button");
	}
	
	
	
	
	public boolean VerifyNDMS2Page(AppiumDriver<MobileElement> driver) {
		try 
		{
		boolean ndms2Text = false;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		if (driver.findElement(By.xpath("//*[@text='NDMS2']")).isDisplayed()) {
			ndms2Text = true;
			System.out.println("NDMS2 displayed sucessfully");
		}
		return ndms2Text;
		}
		catch (StaleElementReferenceException e) 
		{
			boolean ndms2Text = false;
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			if (driver.findElement(By.xpath("//*[@text='NDMS2']")).isDisplayed()) {
				ndms2Text = true;
				System.out.println("NDMS2 displayed sucessfully");
			}
			return ndms2Text;
		}
		
		
		
	}
	
	
	@Step("Click on Map View")
	public void clickOnMapView(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='Map']")).click();
		System.out.println("Click on Map View");
	}
	
}
