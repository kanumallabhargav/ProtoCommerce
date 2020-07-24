package pcHome;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import functions.Base;
import functions.DBConnect;
import junit.framework.Assert;
import pageObjects.pcHomeObjects;

public class pcHome_SS1 extends Base
{
	private static final String Password = null;
	private static final String Email = null;
	private static final String Name = null;
	private static final String Gender = null;
	private static final String DoB=null;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test
	public void pcHome_SS1_positiveAction() throws IOException, SQLException
	{
		//Initialize driver
		driver = driverInitialize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Connect to DB and get values
		DBConnect database = new DBConnect();
		ArrayList<String> creds = database.DBConn(Name, Email, Password, Gender, DoB);
		String name = creds.get(0);
		String email = creds.get(1);
		String password = creds.get(2);
		String gender = creds.get(3);
		String dob = creds.get(4);
		//System.out.println(dob);
		
		//Find elements and pass values
		pcHomeObjects homeObjects = new pcHomeObjects(driver);
		homeObjects.lookForName().sendKeys(name);				log.info("Name entered");
		homeObjects.lookForEmail().sendKeys(email);				log.info("Email entered");
		homeObjects.lookForPassword().sendKeys(password);		log.info("Password entered");
		homeObjects.checkbox();									log.info("Clicked on checkBox");
		if(gender.equalsIgnoreCase("male"))
		{
		homeObjects.genderSelector_male();						log.info("Gender selected (male)");
		}
		else
		{
			homeObjects.genderSelector_female();				log.info("Gender selected (female)");
		}
		homeObjects.EmpStatus_student();						log.info("Employment status selected");
		//homeObjects.enterDoB_male();
		homeObjects.clickOnSubmit();							log.info("Clicked on submit");
		
		//verifyInfoInTheBox
		String verificationText = homeObjects.NameVerificationBox();			log.info("Retrieved verification text");
		Assert.assertEquals(name, verificationText);							log.info("assertion of text successful");
		
		//validate the successMessage
		boolean checkIfBoxIsDisplayed = homeObjects.findSuccessMessageBox();
		if(checkIfBoxIsDisplayed)
		{
			log.info("Box visible");
			//Assert.assertEquals(success, successTextFromDriver);
			log.info("done execution");
		}
	}
}
