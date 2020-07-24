package pcHome;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import functions.Base;
import junit.framework.Assert;
import pageObjects.pcHomeObjects;

public class pcHome_SS9 extends Base
{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void pcHome_SS6_negativeAction() throws IOException
	{
	driver = driverInitialize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	pcHomeObjects homeObjects = new pcHomeObjects(driver);
	homeObjects.clickOnSubmit();
	boolean checkIfBoxIsDisplayed = homeObjects.findSuccessMessageBox();
	if(checkIfBoxIsDisplayed)
	{
		log.info("Box visible");
		log.info("Test Case failed");
	}
	Assert.assertFalse(checkIfBoxIsDisplayed);
	}
}
