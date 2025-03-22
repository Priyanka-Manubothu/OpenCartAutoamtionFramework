package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	// constructer
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	// Register
    @FindBy(xpath="//*[@class='dropdown-menu dropdown-menu-right']//li/a[text()='Register']")
    WebElement Register;
	
	
	//MyAccount
	  @FindBy(
	  xpath="//ul[@class=\"list-inline\"]//*[@class=\"dropdown\"]//*[text()='My Account']"
	  ) WebElement Account_Dropdowm;
	
	
	  //Login
	  @FindBy(xpath="//*[@class='dropdown-menu dropdown-menu-right']//li/a[text()='Login']")
	  WebElement btnLogin;
	  
	  // Actions Method
	  public void clickMyAccount()
	  {
		  System.out.println("Driver instance: " + driver);
		  Account_Dropdowm.click();
	  }
	   public void clickRegister()
	   {
		   Register.click();
	   }
	  
	   public void clickLogin()
	   {
		   btnLogin.click();
	   }
	  
}
