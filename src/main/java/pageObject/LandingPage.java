package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	private By contactButton = By.xpath("//a[normalize-space()='Contact']");
	
	
	
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		
	}



	public WebElement getContactButton() {
		return driver.findElement(contactButton);
	}

}
