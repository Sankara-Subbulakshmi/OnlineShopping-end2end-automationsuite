package MavenPack.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MavenPack.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent
{
    
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
        super(driver);  
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	
	}

	//pagefactory dseign pattern(reducing syntax creating webelement
	
	//List<WebElement> Products= driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
    By proby = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMsgvisible = By.cssSelector("#toast-container");
    
    @FindBy(css =".ng-animating")
    WebElement spinner;
  
	public  List<WebElement> getProductList() 
	{
		waitForElementToAppear(proby);
		return products;	
	}
	
	public WebElement getProductByName(String pdt) 
	{
		 WebElement selectList = getProductList().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(pdt)).findFirst().orElse(null);
		 return selectList;
	}
	
	public void addProductToCart(String pdt) throws InterruptedException 
	{
		  WebElement selectList = getProductByName(pdt);
		  selectList.findElement(addToCart).click();
		  waitForElementToAppear(toastMsgvisible);
		  waitForElementToDisappear(spinner);	  
	}
	
	
	
	
}
