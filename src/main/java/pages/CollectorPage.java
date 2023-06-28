package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class CollectorPage extends Common {
	public CollectorPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Click on + Button")
	public void clickOnAddNewCollectorIcon(AppiumDriver<MobileElement> driver) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@index='19']")).click();
			System.out.println("Click on + Button");
		} catch (Exception e) {

		}
	}

	public boolean VerifyRecordAddedSucessfully(AppiumDriver<MobileElement> driver, String recordname) {
		boolean record = false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println(recordname);
			if (driver.findElement(By.xpath("//*[@text='" + recordname + " ']")).isDisplayed()) {
				System.out.println("Client name is created and displayed in record sucessfully : " + recordname);
				record = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}

	public boolean VerifyRecordUpdatedSucessfully(AppiumDriver<MobileElement> driver, String recordname) {
		boolean record = false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println(recordname);
			if (driver.findElement(By.xpath("//*[@text='" + recordname + " ']")).isDisplayed()) {
				System.out.println("Client name is created and displayed in record sucessfully : " + recordname);
				record = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}

	public void clickOnManageAccount(AppiumDriver<MobileElement> driver) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[3]")).click();
			System.out.println("Click on Manage account");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOn3Dots(AppiumDriver<MobileElement> driver) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(
					"(//*[@index='1' and @clickable='true']/*[@index='0' and @class='android.view.ViewGroup'])[1]"))
					.click();
			Thread.sleep(1000);
			System.out.println("Clicked on the 3 dots icon");
		} catch (Exception e) {

		}
	}

	public void clickOnPublishRecord(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@text='Publish']")).click();
			Thread.sleep(1000);
			System.out.println("Collector layer is published");
		} catch (Exception e) {

		}
	}

	public void clickOnOKButton(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@text='OK'])")).click();
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

	public void clickOnCancelButton(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@text='CANCEL'])")).click();
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

	public void clickOnBackButton(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@index='3']/*[@index='0' and @clickable='true'])")).click();
			System.out.println("Clicked on back button");
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

	public void clickOnRemoveRecord(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@text='Remove'])")).click();
			Thread.sleep(1000);
			System.out.println("Clicked on Remove button");
		} catch (Exception e) {

		}
	}

	public boolean verifyRemovedRecord(AppiumDriver<MobileElement> driver) {

		boolean removeProduct = false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.findElement(By.xpath("(//*[@text='Deleted successfully!'])")).isDisplayed()) {
				System.out.println("Collector layer is removed");				
				removeProduct = true;
			}
			else
			{
				System.out.println("Collector layer is not removed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return removeProduct;
	}

	public void clickOnPreviewRecord(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@text='Preview'])")).click();
			Thread.sleep(1000);
			System.out.println("Clicked on the Preview button");
		} catch (Exception e) {

		}
	}

	public boolean VerifyPreviewCollectorLayerIsDisplayed(AppiumDriver<MobileElement> driver) {
		boolean record = false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.findElement(By.xpath("(//*[@text='Preview Collector Layer'])")).isDisplayed()) {
				MobileElement client = driver
						.findElement(By.xpath("(//*[@index='2' and @class='android.widget.EditText'])"));
				String clientName = client.getAttribute("text");
				System.out.println("Preview collector page is displayed for client name");
				record = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}

	public void clickOnEditRecord(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@text='Edit'])")).click();
			Thread.sleep(1000);
			System.out.println("Clicked on the Edit button");
		} catch (Exception e) {

		}
	}
	
	public void clickOnOnline(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//*[@text='Online'])")).click();
			Thread.sleep(6000);
			System.out.println("Clicked on the Online button");
		} catch (Exception e) {

		}
	}
	
	
	public boolean VerifyPublishedRecordIsDisplayed(AppiumDriver<MobileElement> driver) {
		boolean publishedRecord = false;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.findElement(By.xpath("//*[@index='17']/*[@index='0']/*[@index='0']/*[@index='0']/*[@index='0']/*[@index='0']")).isDisplayed()) 
			{
				System.out.println("Record is displayed in Online page");
				publishedRecord = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return publishedRecord;
	}
	
	
	
	
	
	
	
	
	
	public void clickOnSearchIcon(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@index='17']/*[@index='0']")).click();
			Thread.sleep(1000);
			System.out.println("Clicked on the Search icon");
		} catch (Exception e) {

		}
	}

}