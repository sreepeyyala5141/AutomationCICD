package rahulsheetyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulsheetyacademy.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {

	
	WebDriver driver;
	 public CheckOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 super(driver);
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
		 
}
	 @FindBy (css=("input[placeholder='Select Country']"))
	 WebElement country;
	 
	 @FindBy (css=(".action__submit"))
	 WebElement submit ;
	 
	 @FindBy (css=(".ta-item:nth-of-type(2)"))
	 WebElement selectCountry;
	 
	By result = By.cssSelector(".ta-results");
	 
	 
	 
	 
	 public void selectCountry(String countryName) {
		 Actions s = new Actions(driver);
		    s.sendKeys(country,countryName).build().perform();
		    waitforElementToAppear(By.cssSelector(".ta-results"));
		    selectCountry.click();
		    }
	 
	 public ConfirmationPage submitOrder()
	 {
		 submit.click();
		  return new ConfirmationPage(driver);
}
	
}
