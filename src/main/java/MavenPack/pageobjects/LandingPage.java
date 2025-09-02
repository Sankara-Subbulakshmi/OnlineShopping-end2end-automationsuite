  package MavenPack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenPack.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent
//create object again is overhead memory.use inheritence method.REUSE CODE
{
    
	WebDriver driver;
		
	public LandingPage(WebDriver driver) 
	{	
		
		super(driver); //child to parent send variable use super (driver coming from tc) construcor can catch the var.
		this.driver = driver;  //this.driver refers local class
		PageFactory.initElements(driver, this); //initializing all the elements ,driver	
	}
	
	//WebElement email = driver.findElement(By.id("userEmail"));
	//pagefactory dseign pattern(reducing syntax creating webelement
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	 WebElement pwd;
	
	@FindBy(id="login")
	WebElement submit;
	
 
	WebElement errorMsg;
	
	public ProductCatalogue loginpage(String eid , String pd)
	{
		email.sendKeys(eid);
		pwd.sendKeys(pd);
		submit.click(); 
		
		ProductCatalogue pdtcatpage = new ProductCatalogue(driver);
		return pdtcatpage;
		
		
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMsg);
		return errorMsg.getText();
		
	}
	
	public void goTo()
	{
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	
}
