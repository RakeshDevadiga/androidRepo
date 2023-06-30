package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import base.Common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CollectorFilterPage extends Common {

	public CollectorFilterPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyFilterPageIsDisplayed(AppiumDriver<MobileElement> driver) {
		boolean verifyFilter = false;

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<MobileElement> filter = driver.findElements(By.xpath("//*[@text='Filter']"));

			if (filter.isEmpty()) {
				System.out.println("Filter page is not opened");
			} else {
				verifyFilter = true;
				System.out.println("Filter page is opened");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return verifyFilter;

	}

	public void clickOnCreateDate(AppiumDriver<MobileElement> driver) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MobileElement createDate = driver.findElement(By.xpath("(//*[@text='DD/MM/YY'])[1]"));
			if (createDate.isDisplayed()) {
				Thread.sleep(1000);
				createDate.click();
				System.out.println("Clicked on the Create date button");
			} else {
				System.out.println("Create date field is not visible");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void clickOnLastModifiedDate(AppiumDriver<MobileElement> driver) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MobileElement modifiedDate = driver.findElement(By.xpath("(//*[@text='DD/MM/YY'])[2]"));
			if (modifiedDate.isDisplayed()) {
				Thread.sleep(1000);
				modifiedDate.click();
				System.out.println("Clicked on the Last Modified date button");
			} else {
				System.out.println("Last modified date field is not visible");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void clickOnFollowupDate(AppiumDriver<MobileElement> driver) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MobileElement fromDate = driver.findElement(By.xpath("(//*[@text='DD/MM/YYYY'])[1]"));
			if (fromDate.isDisplayed()) {
				Thread.sleep(1000);
				fromDate.click();
				System.out.println("Clicked on Follow up fromDate button");
			} else {
				System.out.println("Follow up date field is not visible");
			}

			MobileElement toDate = driver.findElement(By.xpath("(//*[@text='DD/MM/YYYY'])[2]"));
			if (toDate.isDisplayed()) {
				Thread.sleep(1000);
				toDate.click();
				System.out.println("Clicked on Follow up toDate button");
			} else {
				System.out.println("Follow up date field is not visible");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void clickOnAddFilterButton(AppiumDriver<MobileElement> driver) {
		try {
			MobileElement addFilter = driver.findElement(By.xpath("(//*[@text='Add Filter'])"));
			if (addFilter.isDisplayed()) {
				Thread.sleep(1000);
				addFilter.click();
				System.out.println("Clicked on Add Filter button");
			} else {
				System.out.println("Add Filter button is not visible");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void clickOnApplyButton(AppiumDriver<MobileElement> driver) {
		try {
			MobileElement applyButton = driver.findElement(By.xpath("(//*[@text='Apply'])"));
			if (applyButton.isDisplayed()) {
				Thread.sleep(1000);
				applyButton.click();
				System.out.println("Clicked on Apply Filter button");
			} else {
				System.out.println("Apply Filter button is not visible");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void clickOnClearButton(AppiumDriver<MobileElement> driver) {
		try {
			MobileElement applyButton = driver.findElement(By.xpath("(//*[@text='Apply'])"));
			if (applyButton.isDisplayed()) {
				Thread.sleep(1000);
				applyButton.click();
				System.out.println("Clicked on Apply Filter button");
			} else {
				System.out.println("Apply Filter button is not visible");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void clickOnBackButton(AppiumDriver<MobileElement> driver) {
		try {
			MobileElement closeButton = driver.findElement(By.xpath("(//*[@index='2']/*/*)[1]"));
			if (closeButton.isDisplayed()) {
				Thread.sleep(1000);
				closeButton.click();
				System.out.println("Clicked on Close button");
			} else {
				System.out.println("Close button is not visible");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void selectCurrentDate(AppiumDriver<MobileElement> driver) {
		try {
			MobileElement Currdate = driver.findElement(By.xpath("(//*[@selected='true'])"));
				Thread.sleep(1000);
				Currdate.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//*[@text='OK'])")).click();
				
				System.out.println("Created date is selected");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void selectClientName(AppiumDriver<MobileElement> driver) {
		try {
			MobileElement clientName = driver.findElement(By.xpath("(//*[@text='Client Name'])[1]"));
				Thread.sleep(1000);
				clientName.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@text='Filter']")).click();//tapOnScreen(350,500);
				System.out.println("Clicked on Client Name Filter");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void selectPurposeofMeeting(AppiumDriver<MobileElement> driver) {
		try {
			MobileElement purpose = driver.findElement(By.xpath("(//*[@text='Purpose of visit'])"));
				Thread.sleep(1000);
				purpose.click();
				Thread.sleep(1000);
				tapOnScreen(350,500);
				System.out.println("Clicked on Purpose of Meeting Filter");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void selectReportingManager(AppiumDriver<MobileElement> driver) {
		try {
			MobileElement manager = driver.findElement(By.xpath("(//*[@text='Reporting Manager '])"));
				Thread.sleep(1000);
				manager.click();
				Thread.sleep(1000);
				tapOnScreen(350,500);
				System.out.println("Clicked on Reporting manager Filter");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void enterTextInAddFilter(AppiumDriver<MobileElement> driver, String name) {
		try {
			MobileElement addName = driver.findElement(By.xpath("//*[@index='3' and @class='android.widget.EditText']"));
				Thread.sleep(1000);
				if(addName.isDisplayed())
				{
					addName.click();
					Thread.sleep(1000);
					addName.sendKeys(name);
					Thread.sleep(1000);
					driver.hideKeyboard();
					System.out.println("Entered input data in textbox");
				}
				else
				{
				System.out.println("Input textbox is not showing for filter");
				}
		} catch(NoSuchElementException | InterruptedException e) {
		    // Handle the exception
		    System.out.println("Element not found. Please check your selector.");
		}
	}
	
	public boolean verifyFilterPageIsApplied(AppiumDriver<MobileElement> driver) {
		boolean verifyFilter = false;

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<MobileElement> filterPage = driver.findElements(By.xpath("//*[@index='15']/*[@index='1']"));

			if (filterPage.isEmpty()) {
				System.out.println("Filter is not applied on the data");
			} else {
				verifyFilter = true;
				System.out.println("Filter is applied on the data");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return verifyFilter;

	}
	
}
