package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class PermissionPage extends Common {

	public PermissionPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Click on Permission")
	public void clickOnLocationPermission(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='Request location permission']")).click();
		System.out.println("Clicked on Location Permission");
	}

	@Step("Click on Allow Button")
	public void allowOK(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		System.out.println("Clicked on Allow OK");
	}

	@Step("Click on Allow While Using App")
	public void allowWhileUsingApp(AppiumDriver<MobileElement> driver) {
		//driver.findElement(By.xpath("//*[@text , 'While using the app')]")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).click();
		System.out.println("Clicked on While Using The App");
	}

	@Step("Click on All Time Radio Button")
	public void clickOnAllowAllTimeRadio(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='Allow all the time']")).click();
		System.out.println("Clicked on Allow All Time radio button");
	}

	@Step("Click on Back Button")
	public void clickOnBackButton(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
		System.out.println("Clicked on back button");
	}

	@Step("Click on Battery Permission")
	public void clickOnBatteryPermission(AppiumDriver<MobileElement> driver) {
		
		List<MobileElement> batteryPermission = driver.findElements(By.xpath("//*[@text='Turn off optimized battery']"));
		
		if (batteryPermission.isEmpty())
				{
					System.out.println("Battery Permission is already selected");
				}
		else
		{
			batteryPermission.get(0).click();
			System.out.println("Click on Battery Permission");
			//driver.findElement(By.xpath("//*[@text='Allow']")).click();
			driver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
			System.out.println("Clicked on Allow");
			
		}
		
	}
	
	@Step("Click on Allow Button")
	public void clickOnAllowforBattery(AppiumDriver<MobileElement> driver) {
		//driver.findElement(By.xpath("//*[@text='Allow']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")).click();
		System.out.println("Clicked on Allow");
	}
	
	@Step("Click on Camera Permission")
	public void clickOnCameraPermission(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='Request camera permission']")).click();
		System.out.println("Clicked on Request Camera Permission");
	}

	@Step("Click on Storage Permission Button")
	public void clickOnStoragePermission(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='Request storage permission']")).click();
		System.out.println("Clicked on Request Storage Permission");
	}

	@Step("Click on Allow Button")
	public void clickOnAllow(AppiumDriver<MobileElement> driver) {
		//driver.findElement(By.xpath("//*[@text='Allow']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")).click();
		System.out.println("Clicked on Allow");
	}
	
	@Step("Click on Go Button")
	public void clickOnGo(AppiumDriver<MobileElement> driver) {
		driver.findElement(By.xpath("//*[@text='Go']")).click();
		System.out.println("Clicked on Go Button");
	}
}
