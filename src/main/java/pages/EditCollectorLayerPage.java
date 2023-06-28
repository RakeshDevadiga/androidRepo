package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class EditCollectorLayerPage extends Common{
	
	public EditCollectorLayerPage() {
		PageFactory.initElements(driver, this);
	}
		
	public void editClientName(AppiumDriver<MobileElement> driver, String clientName) {

		try {
			
			MobileElement Name = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'][@index='2'])"));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Name.click();
			Name.clear();
			Name.sendKeys(clientName);
			System.out.println("Entered client name :" + clientName);
		} 
		catch (Exception e) {

		}
	}

	public void editPurposeOfMeeting(AppiumDriver<MobileElement> driver, String purpose) {

		try {
			MobileElement purposeDesc = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'][@index='4'])"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			purposeDesc.click();
			purposeDesc.clear();
			purposeDesc.sendKeys(purpose);
			System.out.println("Entered purpose of meeting :" + purpose);
		} catch (Exception e) {

		}
	}

public void editMinutesOfMeeting(AppiumDriver<MobileElement> driver, String meeting) {
	
	try{
		MobileElement MOM = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'][@index='6'])"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	MOM.click();
	MOM.clear();
	MOM.sendKeys(meeting);
	System.out.println("Entered Minutes of Meeting :"+meeting);
	}
	catch(Exception e) {
	
	}
}

public void clickOnUpdateButton(AppiumDriver<MobileElement> driver) {

	try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='Update']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		System.out.println("Clicked on Update Button");			
	} catch (Exception e) {

	}

}

public void editClientNameHere(AppiumDriver<MobileElement> driver, String clientName) {

	try {
		
		MobileElement Name = driver.findElement(By.xpath("(//*[@class='android.widget.EditText'][@index='2'])"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Name.click();
		Name.clear();
		Name.sendKeys(clientName);
		System.out.println("Entered client name :" + clientName);
	} 
	catch (Exception e) {

	}
}
}
