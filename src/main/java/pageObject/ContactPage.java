package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {

	public WebDriver driver;

	private By submitButton = By.xpath("//a[@class='btn-contact btn btn-primary']");
	private By errorWarning = By.xpath("//div[@class='alert alert-error ng-scope']");
	private By foreName = By.id("forename");
	private By email = By.id("email");
	private By messageBox = By.id("message");
	private By messageAfterMandatoryField = By.xpath("//strong[normalize-space()='We welcome your feedback']");
	private By SuccessfulSubmissionMessage = By.xpath("//strong[@class='ng-binding']");
	private By messageAfterInvalidData = By.xpath("//div[@class='alert alert-error ng-scope']");
	
	public ContactPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getSubmitButton() {
		return driver.findElement(submitButton);
	}

	public WebElement getErrorWarning() {
		return driver.findElement(errorWarning);
	}

	public WebElement getForeName() {
		return driver.findElement(foreName);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getMessage() {
		return driver.findElement(messageBox);
	}
	
	public WebElement getMessageAfterMandatoryField() {
		return driver.findElement(messageAfterMandatoryField);
	}
	
	public WebElement getSuccessfulSubmissionMessage() {
		return driver.findElement(SuccessfulSubmissionMessage);
	}
	
	public WebElement getMessageAfterInvalidData() {
		return driver.findElement(messageAfterInvalidData);
	}
	
}

