package rahulsheetyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulsheetyacademy.pageObject.CartPage;
import rahulsheetyacademy.pageObject.OrderPage;

public class AbstractComponents {

	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	

	public void waitforElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitforWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	
	public void waitforElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 
		 wait.until(ExpectedConditions.invisibilityOf(ele));
		}
	 
	public CartPage goToCart() {
		
		CartPage cartpage = new CartPage(driver);
		cartHeader.click();
		return cartpage;
	}
     public OrderPage goToOrder() {
		
		 OrderPage  orderpage = new  OrderPage(driver);
		orderHeader.click();
		return  orderpage;
	}
	
	
	}

