package pcShopping;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import functions.Base;
import pageObjects.pcHomeObjects;
import pageObjects.pcShoppingObjects;

public class pcShopping_SS2 extends Base
{
private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test
	public void pcShopping_SS3_positiveAction() throws IOException
	{
		driver=driverInitialize();
		pcHomeObjects homeObjects = new pcHomeObjects(driver);
		homeObjects.clickOnShopButton();
		log.info("Clicked on shop button");
		
		//add phones to the cart
		pcShoppingObjects shoppingObjects = new pcShoppingObjects(driver);
		shoppingObjects.clickOnSecondAddButton();
		shoppingObjects.clickOnSecondAddButton();
		shoppingObjects.clickOnBlueCheckoutButton();
		
		//verifying order total
		String orderTotalBeforeQuantityIncrease = shoppingObjects.getOrderTotal();
		shoppingObjects.increaseQuantity();
		String orderTotalAfterQuantityIncrease = shoppingObjects.getOrderTotal();
		if(orderTotalBeforeQuantityIncrease.equalsIgnoreCase(orderTotalAfterQuantityIncrease))
		{
			log.error("Order total unchanged. Test Case failed");
		}
		else
		{
			log.info("Order total updated accordingly. Test case passed");
		}
	}
}
