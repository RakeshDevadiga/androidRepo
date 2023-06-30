package pages;

import java.util.List;
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

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[@class='android.widget.EditText'][@text='Input here'])[1]"))
					.sendKeys(mom);
			System.out.println("Entered Minutes of Meeting :" + mom);
		} catch (Exception e) {

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

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@index='2' and @clickable='true']/*[@index='0']")).click();
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//*[@index='4' and @clickable='true']/*[@index='0' and @class='android.view.ViewGroup']"))
					.click();
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
		} catch (Exception e) {

		}
	}

	public void SelectFollowUpDate(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@index='9']/*[@index='0']")).click();
			Thread.sleep(2000);
			/*
			 * MobileElement selectedDate =
			 * driver.findElement(By.xpath("//*[@selected='true']")); String textDate =
			 * selectedDate.getAttribute("content-desc");
			 * 
			 * System.out.println(textDate); while(!textDate.contains(SelectDate)) {
			 * driver.findElement(By.xpath("//*[@resource-id='android:id/next']")).click();
			 * MobileElement selectedDate1 = driver.findElement(By.xpath("//*[@text='1']"));
			 * String textDate1 = selectedDate1.getAttribute("content-desc");
			 * System.out.println(textDate1); textDate=textDate1;
			 * System.out.println(textDate); } MobileElement dateq =
			 * driver.findElement(By.xpath("//*[@content-desc='"+SelectDate+"']"));
			 * dateq.click();
			 */
			driver.findElement(By.xpath("//*[@text='30']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='OK']")).click();

			System.out.println("Follow up date is selected");
		} catch (Exception e) {

		}
	}

	public void SelectLocation(AppiumDriver<MobileElement> driver) {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@index='12']/*[@index='0']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@index='3']/./*[@index='0']/./*[@index='0'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Confirm']")).click();
			System.out.println("Current Location is selected");
		} catch (Exception e) {

		}
	}

	public void takeCameraImage(AppiumDriver<MobileElement> driver, String desc) {

		try {
			// System.out.println("Entered in image method");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(2000);
			List<MobileElement> addPhoto1 = driver.findElements(By
					.xpath("//*[@index='5' and @clickable='true']/*[@index='0' and @class='android.view.ViewGroup']"));
			if (addPhoto1.isEmpty()) {
				driver.findElement(By.xpath("//*[@index='2' and @clickable='true']/*[@index='0']")).click();
			}

			if (addPhoto1.isEmpty()) {
				driver.findElement(By.xpath(
						"//*[@index='4' and @clickable='true']/*[@index='0' and @class='android.view.ViewGroup']"))
						.click();
			} else {
				driver.findElement(By.xpath(
						"//*[@index='5' and @clickable='true']/*[@index='0' and @class='android.view.ViewGroup']"))
						.click();
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Camera']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@content-desc='Shutter']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@content-desc='Done']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@text='Done']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Enter description....']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Enter description....']")).sendKeys(desc);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Update']")).click();
			Thread.sleep(2000);

			System.out.println("Image is taken and uploaded");
		} catch (Exception e) {

		}
	}

}
