package rahulsheetyacademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	 public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 super(driver);
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
	}

	//WebElement  userEmail= driver.findElement(By.id("userEmail"));
	 //this is findby annotation is initElements method to take care of the annotations with help of driver.
	 @FindBy(id="userEmail")
	 WebElement userEmail;
	 
	 @FindBy(id="userPassword")
	 WebElement PasswordEle;
	 
	 @FindBy(id="login")
	 WebElement submit;
	 
	 @FindBy(css="[class*='flyInOut']")
	 WebElement ErrorMessage;
	 
	 //Actions Methods
	 
	 public ProductCatelog LoginApplicationPage(String UserEmail, String Password) {
		 
		 userEmail.sendKeys(UserEmail);
		 PasswordEle.sendKeys(Password);
		 submit.click();
		 ProductCatelog productcatelog = new ProductCatelog(driver);
		 return  productcatelog;
		 
	 }
	 
	 public String getErrorMessage()
	 {
		  
		 waitforWebElementToAppear(ErrorMessage);
		  return ErrorMessage.getText();
	 }
	 
	  

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	 
	 
	 

}
