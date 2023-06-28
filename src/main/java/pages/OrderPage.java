package pages;

import org.openqa.selenium.support.PageFactory;

import base.Common;

public class OrderPage extends Common{
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
}
