package PlaintTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Planit.base;
import pageObject.ContactPage;
import pageObject.LandingPage;

public class TestCase1 extends base {
	public WebDriver driver;

	@Test
	public void planitAssessment1() throws IOException {
		
		Logger log = LogManager.getLogger(base.class.getName());

		driver = initializerDriver();
		log.info("driver is initialized");
		
		
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");

		//from the home page go to contact page
		LandingPage lp = new LandingPage(driver);
		lp.getContactButton().click();

		//click submit button
		ContactPage cp = new ContactPage(driver);
		cp.getSubmitButton().click();

		//validate errors
		String error = cp.getErrorWarning().getText();
		Assert.assertEquals(error,
				"We welcome your feedback - but we won't get it unless you complete the form correctly.");
log.info("successfully validated text message");
		
		
		//populate mandatory fields
		cp.getForeName().sendKeys("Farhad");
		cp.getEmail().sendKeys("farhad.inaus@gmail.com");
		cp.getMessage().sendKeys("Have a great day!");
		
		//validate errors are gone
		String mamf = cp.getMessageAfterMandatoryField().getText();
		Assert.assertEquals(mamf, "We welcome your feedback");
		
		driver.close();
		
	}

}
