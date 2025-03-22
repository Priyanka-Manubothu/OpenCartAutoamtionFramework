package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.HomePage;
import pageObject.RegisterationPage;
import testBase.BaseClass;

public class TC_AccountRegistration extends BaseClass{

@Test(groups={"Regression","Master"})
public void verify_registration() {
	
	HomePage l1 = new HomePage(driver);
	l1.clickMyAccount();
	l1.clickRegister();
	logger.info("Started Execution of TC_AccountRegistration");
	RegisterationPage R1 = new RegisterationPage(driver);
	R1.setFName(RandomAlphabates().toLowerCase());
	R1.setLName(RandomAlphabates().toLowerCase());
	R1.setEmail(RandomAlphabates()+"@gmail.com");
    String Pass = RandomAlpNumerics();
	R1.setPassword(Pass);
	R1.setConPassword(Pass);
    R1.setPhoneNumber(RandomNumeric());
    logger.info("Entered all details");
    R1.clickPrivacy(driver);
    R1.clickContinue(driver);
    logger.info("Clicking on Continue");
    String Actual =R1.msgConfirmation();
    String Expected ="Your Account Has Been Created!";
    logger.info("Validating the Reults");
    Assert.assertEquals(Actual, Expected);
	/*
	 * } catch(Exception e) { //logger.error("Error occured..");
	 * //logger.debug("Debugging...."); //Assert.fail(); }
	 */
	 logger.info("Exectuion is Completed..");
}

}
