package MavenPack.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MavenPack.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent 
{
	    WebDriver driver;
	   @FindBy(css ="tr td:nth-child(3)")
	    private List<WebElement> ProNameinOrderList;
	    
	    @FindBy(css =".totalRow button")
	    WebElement checkoutele;
	    
	public OrderPage(WebDriver driver)
	{
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
		
	public Boolean VerifyMyOrderListdispaly(String pdt)
	{
	
		   Boolean match = ProNameinOrderList.stream().anyMatch(Ml->Ml.getText().equalsIgnoreCase(pdt));
		   return match;
	}

}
