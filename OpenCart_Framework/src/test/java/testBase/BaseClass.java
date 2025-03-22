package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.time.Duration;
import java.util.Properties;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class BaseClass {
	public WebDriver driver;
	public Logger logger ;
	public Properties p;
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"browser"})
	public void setup(String browser) throws InterruptedException, IOException
	{ 
		//loading properties 
		FileInputStream file = new FileInputStream(".//src//test//resources//configuration.properties");
		p=new Properties();
		p.load(file);
		
		
		logger= LogManager.getLogger(this.getClass());
		switch(browser.toLowerCase())
		{
		case"chrome":driver = new ChromeDriver();break;
		case"edge":driver = new EdgeDriver();break;
		default:System.out.println("Invalid browser name");return;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.get("https://demo.opencart.com/");
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
	
		Thread.sleep(1000);
	}
	public String RandomAlphabates()
	{
		String randomalpha=RandomStringUtils.randomAlphabetic(5);
		return randomalpha;	
	}
	public String RandomNumeric()
	{
		String randomnumeric=RandomStringUtils.randomNumeric(10);
		return randomnumeric;	
	}

	public String RandomAlpNumerics()
	{
		String randomalpha=RandomStringUtils.randomAlphabetic(3);
		String randomnumerics = RandomStringUtils.randomNumeric(3);
		return (randomalpha+"*"+randomnumerics);	
	}

	
	public String CaptureScreen()
	{
		String df = new SimpleDateFormat("yyyy:MM:DD,HH,mm,SS").format(new Date()) ;
	  String targetpath = "Scrrenshot"+df+".png";
	   return targetpath;	
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.close();
	}
		

}
