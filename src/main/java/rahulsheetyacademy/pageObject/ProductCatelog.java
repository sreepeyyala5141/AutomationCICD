package rahulsheetyacademy.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.AbstractComponents.AbstractComponents;

public class ProductCatelog extends AbstractComponents {
	
	WebDriver driver;
	 public ProductCatelog(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 super(driver);
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
	}

	 //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	 @FindBy(css=".mb-3")
	 List <WebElement> products;
	 
	 //By.cssSelector(".ng-animating")
	 
	 @FindBy(css=".ng-animating")
	 WebElement spinner;
	 
	 By ProductsBy = By.cssSelector(".mb-3");
	  By addTocart = By.cssSelector(".card-body button:last-of-type");
	  By toast= By.cssSelector("#toast-container");
	 
	 public List<WebElement> getProductList() {
		 waitforElementToAppear(ProductsBy);
		 return products;
	 }
	 
	 public WebElement getproductByname(String productName) {

		    WebElement prod = getProductList().stream().filter(product ->
		        product.findElement(By.cssSelector("b")).getText().equals(productName))
		        .findFirst().orElse(null);
			return prod;
	 }
	 
	 public void addproductTocart(String productName) {
		WebElement prod = getproductByname(productName);
		prod.findElement(addTocart).click();
		waitforElementToAppear(toast);
		waitforElementToDisappear(spinner);
		 
		  
	 }

	 
	 
	  

}
