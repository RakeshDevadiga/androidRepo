package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CollectorLayerListPage extends Common {

	public CollectorLayerListPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLayerListPageIsDisplayed(AppiumDriver<MobileElement> driver) {
		boolean verifyList = false;

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<MobileElement> list = driver.findElements(By.xpath("//*[@text='Collector Layer List']"));

			if (list.isEmpty()) {
				System.out.println("Filter page is not opened");
			} else {
				verifyList = true;
				System.out.println("Filter page is opened");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return verifyList;

	}

	public void selectCollectorLayerList(AppiumDriver<MobileElement> driver) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			MobileElement listLayer = driver.findElement(By.xpath("//*[@text='DailyVisit']"));
			if (listLayer.isDisplayed()) {
				listLayer.click();
				System.out.println("Clicked on the collector layer option");
				Thread.sleep(5000);
			} else {
				System.out.println("Colleector layer list is not available");
			}
		} catch (Exception e) {

		}
	}
}
