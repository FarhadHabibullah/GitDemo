package PlaintTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Planit.base;
import pageObject.ContactPage;
import pageObject.LandingPage;

public class TestCase2 extends base {
public WebDriver driver;
	@Test (dataProvider = "getData")

	public void planitAssessment2(String UserNmae,String Email,String Text) throws IOException {
		driver = initializerDriver();
		Logger log = LogManager.getLogger(base.class.getName());
		
		driver.get(prop.getProperty("url"));
		log.info("navigate to homepage");

		// from the home page go to contact page
		LandingPage lp = new LandingPage(driver);
		lp.getContactButton().click();
		log.info("clicking contact button");

		// populate mandatory fields
		ContactPage cp = new ContactPage(driver);
		cp.getForeName().sendKeys(UserNmae);
		log.info("sending user name");
		
		cp.getEmail().sendKeys(Email);
		log.info("sending email");
		
		cp.getMessage().sendKeys(Text);
		log.info("sending text");
		
		// click submit button
		cp.getSubmitButton().click();
		log.info("clicking submit button");
		
		//validate successful submission message
		String ssm = cp.getSuccessfulSubmissionMessage().getText();
		Assert.assertEquals(ssm, "Thanks Farhad");
		log.info("validate message");
		
		driver.close();
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[1][3];
		data[0][0] = "Farhad";
		data[0][1] = "farhad.inaus@gmail.com";
		data[0][2] = "Valid input";
		
		
		return data;
		
	}
	

}
