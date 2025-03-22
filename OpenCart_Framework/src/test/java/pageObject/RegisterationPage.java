package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends BasePage{

	public WebDriver driver;
	
	public RegisterationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    
	
	//locators
	@FindBy(xpath="//*[@name=\"firstname\"]")
	WebElement txtfName;
	
	@FindBy(xpath="//*[@name=\"lastname\"]")
	WebElement txtlName;
	
	@FindBy(xpath="//*[@name=\"email\"]")
	WebElement txtemailid;
	
	@FindBy(xpath="//*[@name=\"password\"]")
	WebElement txtpassword;
	
	@FindBy(xpath="//*[@placeholder=\"Telephone\"]")
	WebElement txtPhoneNumber;
    
	@FindBy(xpath="//*[@placeholder=\"Password Confirm\"]")
	WebElement txtConPass;
	
    @FindBy(xpath="//*[@name=\"agree\"]")
    WebElement privacy_toggle;
	
    @FindBy(xpath="//*[@type=\"submit\"]")
    WebElement btnContinue;
    
    
    @FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
    WebElement confirmation_message;

	private Object js;
    
	//Methods
	
    
    public void setFName(String Fname)
	   {
    	txtfName.sendKeys(Fname);
	   }
    public void setLName(String Lname)
	   {
    	txtlName.sendKeys(Lname);
	   }
 
    public void setEmail(String Email)
	   {
    	txtemailid.sendKeys(Email);
	   }
    public void setPassword(String Pass)
	   {
    	txtpassword.sendKeys(Pass);
	   }
    
    public void setConPassword(String Pass)
	   {
    	txtConPass.sendKeys(Pass);
	   }
    
    
    public void setPhoneNumber(String Phno)
	   {
    	txtPhoneNumber.sendKeys(Phno);
	   }
    
    public void clickPrivacy(WebDriver driver)
	   {
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	js1.executeScript("arguments[0].click()", privacy_toggle);
    	
	   }
    
    public void clickContinue(WebDriver driver)
	   {
    	JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	js1.executeScript("arguments[0].click()", btnContinue);
    	
	   }
	public String msgConfirmation()
	{
		try {
		return 	(confirmation_message.getText());}
		catch(Exception e) {
			return (e.getMessage());}
	}
	
	
}
