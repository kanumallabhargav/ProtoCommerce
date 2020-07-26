package pcShopping;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import functions.Base;
import pageObjects.pcHomeObjects;
import pageObjects.pcShoppingObjects;

public class pcShopping_SS1 extends Base
{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void pcShopping_SS1_positiveAction() throws IOException
	{
		driver = driverInitialize();
		pcHomeObjects homeObjects = new pcHomeObjects(driver);
		homeObjects.clickOnShopButton();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pcShoppingObjects shoppingObjects = new pcShoppingObjects(driver);
		shoppingObjects.clickOnFirstAddButton();
		shoppingObjects.clickOnFirstAddButton();
		shoppingObjects.clickOnFourthAddButton();
		shoppingObjects.clickOnBlueCheckoutButton();
		shoppingObjects.clickOnGreenCheckoutButton();
		shoppingObjects.countryBoxEnterText();
		shoppingObjects.selectCountryFromList();
		//shoppingObjects.clickOnTermsAndConditionsCheckbox();
		shoppingObjects.clickOnPurchaseButton();
		boolean checkIfBoxIsDisplayed = shoppingObjects.verifyBox();
		if(checkIfBoxIsDisplayed)
		{
			log.info("Box displayed");
			log.info("TestCase passed");
		}
		else
		{
			log.error("Box is NOT displayed. TestCase failed.");
		}
	}
}
