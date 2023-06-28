package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class CreateCollectorLayerPage extends Common {
	public CreateCollectorLayerPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Click on + Button")
	public void enterClientName(AppiumDriver<MobileElement> driver, String clientName) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@class='android.widget.EditText'][@text='Input here'])[1]"))
					.sendKeys(clientName);
			System.out.println("Entered client name :" + clientName);
		} catch (Exception e) {

		}
	}

	public void enterPurposeOfMeeting(AppiumDriver<MobileElement> driver, String purpose) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@class='android.widget.EditText'][@text='Input here'])[1]"))
					.sendKeys(purpose);
			System.out.println("Entered purpose of meeting :" + purpose);
		} catch (Exception e) {

		}
	}

public void enterMinutesOfMeeting(AppiumDriver<MobileElement> driver, String mom) {
	
	try{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//*[@class='android.widget.EditText'][@text='Input here'])[1]")).sendKeys(mom);
	System.out.println("Entered Minutes of Meeting :"+mom);
	}
	catch(Exception e) {
	
	}
}
	public void clickOnSaveButton(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@text='Save']")).click();
			System.out.println("Click on Save Button");
			driver.findElement(By.xpath("//*[@text='OK']")).click();			
		} catch (Exception e) {

		}

	}

	public void clickOnSaveAsDraftButton(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@text='Save as draft']")).click();
			System.out.println("Click on Save as draft Button");
		} catch (Exception e) {

		}

	}

	public void clickOnDisardButton(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@text='Discard']")).click();
			System.out.println("Click on Discard Button");
		} catch (Exception e) {

		}

	}
	

public void UploadImage(AppiumDriver<MobileElement> driver, String desc) {
	
	try{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@index='2' and @clickable='true']/*[@index='0']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@index='4' and @clickable='true']/*[@index='0' and @class='android.view.ViewGroup']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='Gallery']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='Pictures']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//*[contains(@content-desc, 'Photo taken on')][1])")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@text='Done']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='Enter description....']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='Enter description....']")).sendKeys(desc);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='Update']")).click();
	Thread.sleep(2000);
	
	System.out.println("Image is uploaded");
	}
	catch(Exception e) {
	
	}
}


public void SelectFollowUpDate(AppiumDriver<MobileElement> driver) {
	
	try{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@index='9']/*[@index='0']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='30']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='OK']")).click();
	
	System.out.println("Follow up date is selected");
	}
	catch(Exception e) {
	
	}
}

public void SelectLocation(AppiumDriver<MobileElement> driver) {
	
	try{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@index='12']/*[@index='0']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//*[@index='3']/./*[@index='0']/./*[@index='0'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='Confirm']")).click();
	System.out.println("Current Location is selected");
	}
	catch(Exception e) {
	
	}
}

}
