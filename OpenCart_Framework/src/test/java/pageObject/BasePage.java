package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	public JavascriptExecutor js1 = (JavascriptExecutor)driver;
	public BasePage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
		this.js1=js1;
		System.out.println("Driver instance: " + driver);
	}
}
