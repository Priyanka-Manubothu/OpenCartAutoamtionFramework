package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC2_LoginTest extends BaseClass{
      @Test(groups={"Sanity","Master"})
      public void verify_login()
      {
    	  
    		logger.info("Started Execution of TC_LoginTest");
    		HomePage page = new HomePage(driver);
    		page.clickMyAccount();
    		page.clickLogin();
    		LoginPage login = new LoginPage(driver);
    		
    		login.setEmail(p.getProperty("email"));
    		login.setPass(p.getProperty("password"));
    		login.loginClick();
    		
    		MyAccountPage map = new MyAccountPage(driver);
    		boolean targetpage = map.msgValidation();
    		Assert.assertTrue(targetpage);
    		logger.info(" Execution of TC_LoginTest is finished");
      }
	
}
