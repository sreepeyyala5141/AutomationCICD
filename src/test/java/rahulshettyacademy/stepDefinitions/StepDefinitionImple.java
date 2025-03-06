package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulsheetyacademy.TestComponents.BaseTest;
import rahulsheetyacademy.pageObject.CartPage;
import rahulsheetyacademy.pageObject.CheckOutPage;
import rahulsheetyacademy.pageObject.ConfirmationPage;
import rahulsheetyacademy.pageObject.LandingPage;
import rahulsheetyacademy.pageObject.ProductCatelog;

public class StepDefinitionImple extends BaseTest {
    public ProductCatelog productCatelog;
	public LandingPage landingpage;
	public ConfirmationPage confirmationpage;
	
	
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		 landingpage = launchApplication(); 
	}
	
	@Given("^Logged in with username(.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username,String password) {
		
		productCatelog = landingpage.LoginApplicationPage(username,password);
	}
		
		
    @When("^I add product (.+) from cart $")
    public void I_add_product_from_cart(String productName) {
    	
    	List<WebElement> products = productCatelog.getProductList();
        productCatelog.addproductTocart(productName);
    	
    }
    
    @When("Checkout (.+) and submit the order $")
    public void Checkout_productName_and_submit_the_order( String productName) {
    	
    	CartPage cartpage = productCatelog.goToCart();
        
        
        // Verify product display
        Boolean match = cartpage.VerifyproductDisplay(productName);
        Assert.assertTrue(match, "Product not found in the cart.");
        
        // Proceed to checkout
        CheckOutPage checkoutPage = cartpage.goTocheckout();
        checkoutPage.selectCountry("india");
        
        // Submit order and verify confirmation
        confirmationpage = checkoutPage.submitOrder();
    	
    }
    
    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String string) {
    	String confirmationMessage = confirmationpage.getconfirmationMessage();
        
        Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));
    }
	 
}
