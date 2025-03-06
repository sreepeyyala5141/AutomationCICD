package rahulshettyacademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulsheetyacademy.TestComponents.BaseTest;
import rahulsheetyacademy.pageObject.CartPage;
import rahulsheetyacademy.pageObject.ProductCatelog;
 
public class ErrorValidationTest  extends BaseTest{
	 
	
	
	     
	    	@Test(groups= {"ErrorHandling"})//,retryAnalyzer = Retry.class)edi tarvata add chedam 
	        public void LoginErrorValidation() throws IOException , InterruptedException 
	    	
	    	{
	         // Login and navigate to product catalog
            landingpage.LoginApplicationPage("vijaypeyyal5141@gmail.com", "Vij5141");
            Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	    }
	    
	    @Test
        public void producterrorValidations() throws IOException , InterruptedException {
	    	 
	    	// Login and navigate to product catalog
	    	
	     	String productName = "IPHONE 13 PRO";
            ProductCatelog productcatelog =landingpage.LoginApplicationPage("vijaypeyyal5141@gmail.com", "Vijay5141");
            productcatelog.addproductTocart(productName);
            
            CartPage cartpage = productcatelog.goToCart();
            
            
            // Verify product display
            Boolean match = cartpage.VerifyproductDisplay("IPHONE 13 PRO");
            Assert.assertTrue(match, "Product not found in the cart.");

	    }
}

