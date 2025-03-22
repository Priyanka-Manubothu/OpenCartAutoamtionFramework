package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
    
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement txtPass;
	
	@FindBy(xpath="//*[@value=\"Login\"]")
	WebElement btnLogin;
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);	
	}
	public void setPass(String pass)
	{
		txtPass.sendKeys(pass);	
	}
	public void loginClick()
	{
		btnLogin.click();	
	}
}
