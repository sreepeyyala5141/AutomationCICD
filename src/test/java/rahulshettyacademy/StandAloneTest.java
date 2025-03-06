package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulsheetyacademy.pageObject.LandingPage;
 

public class StandAloneTest {

	public static void main(String[] args) {
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    String productName = "IPHONE 13 PRO";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://rahulshettyacademy.com/client/");
	    
	    // Login steps
	    driver.findElement(By.id("userEmail")).sendKeys("vijaypeyyal5141@gmail.com");
	    driver.findElement(By.id("userPassword")).sendKeys("Vijay5141");
	    driver.findElement(By.id("login")).click();
	     
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    
	    List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	    WebElement prod = products.stream().filter(product ->
	        product.findElement(By.cssSelector("b")).getText().equals(productName))
	        .findFirst().orElse(null);

	    
	        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();///.card-body button:last-of-type
	    
	   
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	    
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
	    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();


	    //driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	    List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
	    Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	    Assert.assertTrue(match);

	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    Actions s = new Actions(driver);
	    s.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	    driver.findElement(By.cssSelector(".action__submit")).click();

	    String catchname = driver.findElement(By.cssSelector(".hero-primary")).getText();
	    Assert.assertTrue(catchname.equalsIgnoreCase("Thankyou for the order."));
	    driver.close();
	}
}
