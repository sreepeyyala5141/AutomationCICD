package rahulsheetyacademy.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;
	 public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 super(driver);
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
	}

	 //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	 
	 
	 @FindBy(css="tr td:nth-child(3)")
	 private List <WebElement> productNames;
	 
	 @FindBy(css=".totalRow button")
	 WebElement  totalEle;
	 
	 public Boolean VerifyorderProducts(String productName) {
		 
		 Boolean match = productNames.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		    
	 }
	 
	 
	 
	  
	  
	 

	 
	 
	  

}
