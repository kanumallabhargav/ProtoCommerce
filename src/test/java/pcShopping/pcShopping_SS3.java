package pcShopping;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import functions.Base;
import pageObjects.pcHomeObjects;
import pageObjects.pcShoppingObjects;

public class pcShopping_SS3 extends Base
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
		shoppingObjects.clickOnThirdAddButton();
		shoppingObjects.clickOnFirstAddButton();
		shoppingObjects.clickOnBlueCheckoutButton();
		shoppingObjects.clickOnContinueShoppingButton();
		
		//check if returned to homePage
		boolean verificationElement = shoppingObjects.homePageValidator();
		if(verificationElement)
		{
			log.info("Successfully returned to the homepage");
		}
		else
		{
			log.error("Did not return to the hoe page. Test case failed");
		}
		String textFromCheckoutButton = shoppingObjects.checkItemsInCartAfterReturningToHomePage();
		String comparisionText = "Checkout ( 0 )\n" + 
				"(current)";
		if(textFromCheckoutButton.equalsIgnoreCase(comparisionText))
		{
			log.error("Items in the cart have been removed. Test case failed");
		}
		else
		{
			log.info("Items in the cart remail. Test case passed");
		}
	}
}
