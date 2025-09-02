package MavenPack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MavenPack.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent 
{
	WebDriver driver;

	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')] [2]")
	WebElement selectCountry;
	
	
	@FindBy(css=".action__submit")
	WebElement submit;
	 
	By results = By.cssSelector(".ta-results");

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	public void SelectCountry(String countryName) 
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder()
	{
		
		submit.click();
		return new ConfirmationPage(driver);
		
	}
	
	
	
}
