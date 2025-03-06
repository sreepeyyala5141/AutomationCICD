package rahulsheetyacademy.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	 public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 super(driver);
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
	}

	 //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	 
	 
	 @FindBy(css=".cartSection h3")
	 private List <WebElement>productsTitles;
	 
	 @FindBy(css=".totalRow button")
	 WebElement  totalEle;
	 
	 public Boolean VerifyproductDisplay(String productName) {
		 
		 Boolean match = productsTitles.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		    
	 }
	 
	 public CheckOutPage goTocheckout() {
		 
		 totalEle.click();
		return  new CheckOutPage(driver);
	 }
	 
	  
	  
	 

	 
	 
	  

}
