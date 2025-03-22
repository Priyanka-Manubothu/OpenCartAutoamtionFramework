package testCases;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import utilities.DataProviders;
import junit.framework.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_LoginDDT extends BaseClass {

    @Test(dataProvider="loginData",dataProviderClass=DataProviders.class,groups={"Sanity","Regression","Master"})
    public void TC_LoginDDT(String email,String pwd,String exp)
    {
    	HomePage hp = new HomePage(driver);
    	hp.clickMyAccount();
    	hp.clickLogin();
    	
    	//Login
    	LoginPage lp = new LoginPage(driver);
    	lp.setEmail(email);
		lp.setPass(pwd);
		lp.loginClick();
		
		//My Account
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetpage = map.msgValidation();
		System.out.println(targetpage);
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage)
			{
				//logout
				map.clicklogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				map.clicklogout();
				Assert.assertTrue(false);
				//logout
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		logger.info(" Execution of TC_LoginTest is finished");
    }
	
}
