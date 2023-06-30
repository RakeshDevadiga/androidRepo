package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CollectorSearchPage extends Common
{
	public CollectorSearchPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void searchLayerRecord(AppiumDriver<MobileElement> driver, String searchString)
	{
		MobileElement input = driver.findElement(By.xpath("//*[@text='Search your record']"));
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			input.click();
			input.sendKeys(searchString);
			Thread.sleep(1000);
			driver.hideKeyboard();//driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@index='1' and @clickable='true']/*[@index='0'])[1]")).click();
			
			System.out.println("Clicked on the search button");
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void clickOnCloseButton(AppiumDriver<MobileElement> driver)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@index='1']/*[@index='0']/*[@index='0'])[1]")).click();
			System.out.println("Clicked on the close button");
		}
		catch(Exception e)
		{
			
		}
	}
	
	public boolean verifySearchResultData(AppiumDriver<MobileElement> driver)
	{
		boolean searchResult = false;
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElements(By.xpath("(//*[@index='0' and @class='android.widget.TextView'])[2]")).isEmpty())
			{
				System.out.println("Search result data is not showing");
			}
			else
			{
				searchResult = true;
				System.out.println("Search result data is showing on the page");
			}
			
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return searchResult;
	}
	
	public void clickOn3DotsOnSP(AppiumDriver<MobileElement> driver)
	{
		
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@index='1' and @clickable='true']/*[@index='0'])[2]")).click();
			//driver.findElement(By.xpath("(//*[@index='1' and @clickable='true'])[2]")).click();
			System.out.println("Clicked on 3 dotted icon");
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	public void clickOnThreeDotsOnSP(AppiumDriver<MobileElement> driver)
	{
		
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@index='1' and @clickable='true']/*[@index='0'])[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@index='1' and @clickable='true']/*[@index='0'])[2]")).click();
			//driver.findElement(By.xpath("(//*[@index='1' and @clickable='true'])[2]")).click();
			System.out.println("Clicked on 3 dotted icon");
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	public void clickOnPreviewOnSP(AppiumDriver<MobileElement> driver)
	{
		
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@text='Preview'])")).click();
			System.out.println("Clicked on the Preview button");
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	
	public boolean VerifyPreviewCollectorLayerIsDisplayedOnSP(AppiumDriver<MobileElement> driver) {
		boolean record = false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.findElement(By.xpath("(//*[@text='Preview Collector Layer'])")).isDisplayed()) {
				//MobileElement client = driver.findElement(By.xpath("(//*[@index='2' and @class='android.widget.EditText'])"));
				//String clientName = client.getAttribute("text");
				System.out.println("Preview collector page is displayed for search result");
				record = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
	
	public void clickOnBackButtonOnSP(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@index='3']/*[@index='0' and @clickable='true'])")).click();
			System.out.println("Clicked on back button");
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}
}
