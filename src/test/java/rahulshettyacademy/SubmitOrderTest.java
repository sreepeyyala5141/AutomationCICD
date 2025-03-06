package rahulshettyacademy;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;  // TestNG annotation

import rahulsheetyacademy.TestComponents.BaseTest;
import rahulsheetyacademy.pageObject.CartPage;
import rahulsheetyacademy.pageObject.CheckOutPage;
import rahulsheetyacademy.pageObject.ConfirmationPage;
import rahulsheetyacademy.pageObject.LandingPage;
import rahulsheetyacademy.pageObject.OrderPage;
import rahulsheetyacademy.pageObject.ProductCatelog;

 

public class SubmitOrderTest extends BaseTest {
	String productName = "IPHONE 13 PRO";
    @Test(dataProvider="getData", groups={"Purchase"})
    public void submitOrder( HashMap<String,String> input) throws IOException , InterruptedException {
    	
         
           LandingPage landingPage= launchApplication();
            
            // Login and navigate to product catalog
            ProductCatelog productcatelog = landingPage.LoginApplicationPage(input.get("email"), input.get("password"));

            // Find and add product to cart
            List<WebElement> products = productcatelog.getProductList();
            productcatelog.addproductTocart(input.get("product"));
            
            CartPage cartpage = productcatelog.goToCart();
            
            
            // Verify product display
            Boolean match = cartpage.VerifyproductDisplay(input.get("product"));
            Assert.assertTrue(match, "Product not found in the cart.");
            
            // Proceed to checkout
            CheckOutPage checkoutPage = cartpage.goTocheckout();
            checkoutPage.selectCountry("india");
            
            // Submit order and verify confirmation
            ConfirmationPage confirmationpage = checkoutPage.submitOrder();
            String confirmationMessage = confirmationpage.getconfirmationMessage();
            
            Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."), 
                "Confirmation message mismatch.");
         
    }
    @Test(dependsOnMethods= {"submitOrder"})
    public void OrderHistoryTest() {
    	
        ProductCatelog productcatelog = landingpage.LoginApplicationPage("vijaypeyyal5141@gmail.com", "Vijay5141");
        OrderPage  orderpage =productcatelog.goToOrder();
        Assert.assertTrue(orderpage.VerifyorderProducts(productName));
        
     }
    

    @DataProvider
    public Object[][] getData() throws IOException {
    	//HashMap <String,String>  map= new HashMap<String,String>();
    	//map.put("email", "vijaypeyyal5141@gmail.com");
    	//map.put("password", "Vijay5141");
    	//map.put("product", "ADIDAS ORIGINAL");
    	
    	//HashMap <String,String>  map1= new HashMap<String,String>();
    	//map1.put("email", "vijaypeyyal5141@gmail.com");
    	//map1.put("password", "Vijay5141");
    	//map1.put("product", "IPHONE 13 PRO");
    	List <HashMap<String,String>>data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulsheetyacademy\\data\\PurchaseOrder.json",StandardCharsets.UTF_8);
    	 return new Object[][] {{data.get(0)},{data.get(1)}};
     
}}