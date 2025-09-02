package MavenPack.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MavenPack.pageobjects.CartPage;
import MavenPack.pageobjects.OrderPage;

public class AbstractComponent 
{
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) // coming from page objectlandingpage
	{
		
	this.driver = driver;
	PageFactory.initElements(driver, this); 	
	}

	 @FindBy(css ="button[routerlink*='cart']")
	 WebElement headercartbutton;
	 

	 @FindBy(css ="button[routerlink*='myorders']")
	 WebElement headerorderbutton;
	  
	 public CartPage goToCartPage()
	 {
		 headercartbutton.click();	
		 CartPage cp = new CartPage(driver);
		 return cp;  	 
	 }
	 
	 public OrderPage goToOrdersPage()
	 {
		 headerorderbutton.click();	
		 OrderPage op = new OrderPage(driver);
		 return op;
	  	 
	 }
	
	public void waitForElementToAppear(By findBy) 
	{
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
	}
	public void waitForWebElementToAppear(WebElement ele) 
	{
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));	
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
	Thread.sleep(1000);	
  // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
  // wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
}
