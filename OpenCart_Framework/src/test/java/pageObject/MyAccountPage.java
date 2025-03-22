package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
 
	@FindBy(xpath="//*[@id=\"content\"]//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class=\"list-group-item\" and text()='Logout']")
	WebElement logout;
	
	public void clicklogout()
	{
		logout.click();
	}
	public boolean msgValidation()
	{
		try {
		return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;}
	}
}
