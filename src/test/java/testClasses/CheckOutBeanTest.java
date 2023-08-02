package testClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.tus.CheckoutBean;

public class CheckOutBeanTest {

	CheckoutBean checkoutBean;

	@BeforeEach
	void setUpClass() throws Exception {
		checkoutBean = new CheckoutBean();
	}
	
	@Test
	void testCheckOut() throws Exception {
		String actual = checkoutBean.checkOut();
		assertEquals("checkout-success", actual);
	}
}
