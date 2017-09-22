package stepDefinition;

import org.junit.Assert;
import com.nordstrom.demo.cucumber.Cart;
import com.nordstrom.demo.cucumber.Product;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	
	private Cart cart;

	
	@Given("^I have an empty cart$")
	public void i_have_an_empty_cart() throws Throwable {
		cart = new Cart();
	}

	@Then("^My subtotal should be \"([^\"]*)\" dollars$")
	public void my_subtotal_should_be_dollars(String arg1) throws Throwable {
	 Assert.assertEquals(arg1, String.valueOf(cart.getCartTotal()));	
	 
	}

	@When("^I add a \"([^\"]*)\" dollar item named \"([^\"]*)\"$")
	public void i_add_a_dollar_item_named(String arg1, String arg2) throws Throwable {
	
		Product product = new Product(arg2, Integer.parseInt(arg1));
		cart.addProductToCart(product);
		// Assert.assertEquals(arg1, String.valueOf(cart.getCartTotal()));

	}

	@Given("^I have a cart with a \"([^\"]*)\" dollar item named \"([^\"]*)\"$")
	public void i_have_a_cart_with_a_dollar_item_named(String arg1, String arg2) throws Throwable {
		cart = new Cart();
		Product product = new Product(arg2, Integer.parseInt(arg1));
		cart.addProductToCart(product);
	}

	@Then("^My quantity of products named \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void my_quantity_of_products_named_should_be(String arg1, String arg2) throws Throwable {
		Product product = new Product(arg1, Integer.parseInt(arg2));
		int c = cart.totalQuantity(product);
		Assert.assertEquals(Integer.parseInt(arg2), c  );

	}

	@When("^I apply a \"([^\"]*)\" percent coupon code$")
	public void i_apply_a_percent_coupon_code(String arg1) throws Throwable {
	  cart.addCouponCode(arg1);

	}

	@When("^I add a \"([^\"]*)\" dollar \"([^\"]*)\" lb item named \"([^\"]*)\"$")
	public void i_add_a_dollar_lb_item_named(String arg1, String arg2, String arg3) throws Throwable {
		Product product = new Product(arg3, Integer.parseInt(arg1),Integer.parseInt(arg2));
		cart.addProductToCart(product);
		
	}

	@And("^My total should be \"([^\"]*)\" dollars$")
	public void my_total_should_be_dollars(String arg1) throws Throwable {
		//Product product = new Product(arg3, Integer.parseInt(arg1),Integer.parseInt(arg2));
		cart.calculateTotal();
		Assert.assertEquals(arg1, String.valueOf(cart.getCartTotal()));	

	}
}
/*@And("^My quantity of products named \"([^\"]*)\" should be \"([^\"]*)\"$")
public void and_my_quantity_of_products_named_should_be(String arg1, String arg2) throws Throwable {
	Product product = new Product(arg1, Integer.parseInt(arg2));
	
	Assert.assertEquals(arg2, product.getQuantity() );

}*/

/*@Given("^I add a \"([^\"]*)\" dollar item named \"([^\"]*)\"$")
public void i_add_a_dollar_item_named(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}*/
	
		/*@Then("^My total should be \"([^\"]*)\" dollars$")
	public void my_total_should_be_dollars(String arg1) throws Throwable {
			
			Assert.assertEquals(arg1, String.valueOf(cart.getCartTotal()));	
		}*/

/*@Then("^I apply a \"([^\"]*)\" percent coupon code$")
public void i_apply_a_percent_coupon_code(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^I add a \"([^\"]*)\" dollar item named \"([^\"]*)\"$")
public void i_add_a_dollar_item_named(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}*/