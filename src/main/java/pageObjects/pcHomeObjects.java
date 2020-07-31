package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import functions.Base;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.io.IOException;
import java.sql.SQLException;

public class pcHomeObjects extends Base
{
	WebDriver driver;
	private By nameObject = By.xpath("//input[@name='name']");
	private By emailObject = By.xpath("//input[@name='email']");
	private By passwordObject = By.id("exampleInputPassword1");
	private By checkbox = By.id("exampleCheck1");
	private By dropdownObject = By.id("exampleFormControlSelect1");
	private By empStatus_student = By.id("inlineRadio1");
	private By empStatus_employed = By.id("inlineRadio2");
	private By verificationBox = By.cssSelector(".ng-untouched.ng-pristine.ng-valid");
	private By textAboveDateBox = By.cssSelector("label[for='dateofBirth']");
	private String tagName_dateBox = "input";
	private By submit = By.cssSelector("input[type='submit']");
	private By successMessageBox = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By shopButton = By.cssSelector("a[href='/angularpractice/shop']");
	private By orderTotalElementAfterRemoval = By.xpath("/html/body/app-root/app-shop/div/div/div/table/tbody/tr[1]/td[5]/h3/strong");
	
	
	public pcHomeObjects(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement lookForName() throws IOException, SQLException
	{
		return driver.findElement(nameObject);
	}
	public WebElement lookForEmail() throws IOException, SQLException
	{
		return driver.findElement(emailObject);
	}
	public WebElement lookForPassword() throws IOException, SQLException
	{
		return driver.findElement(passwordObject);
	}
	public void checkbox()
	{
		driver.findElement(checkbox).click();
	}
	public void genderSelector_male() throws IOException
	{
		driver.findElement(dropdownObject).click();
		Select selectObject = new Select(driver.findElement(dropdownObject));
		selectObject.selectByVisibleText("Male");
	}
	public void genderSelector_female()
	{
		driver.findElement(dropdownObject).click();
		Select selectObject = new Select(driver.findElement(dropdownObject));
		selectObject.selectByVisibleText("Female");
	}
	public void EmpStatus_student()
	{
		driver.findElement(empStatus_student).click();
	}
	public void EmpStatus_employed()
	{
		driver.findElement(empStatus_employed).click();
	}
	public void enterDoB_male() throws IOException
	{
		String male_doB = getDoB_male();
		driver.findElement(withTagName(tagName_dateBox).below(textAboveDateBox)).click();
		driver.findElement(withTagName(tagName_dateBox).below(textAboveDateBox)).sendKeys(male_doB);
	}
	public void enterDoB_female() throws IOException
	{
		String female_doB = getDoB_female();
		driver.findElement(withTagName(tagName_dateBox).below(textAboveDateBox)).click();
		driver.findElement(withTagName(tagName_dateBox).below(textAboveDateBox)).sendKeys(female_doB);
	}
	public String NameVerificationBox()			//Use a string to store this value when calling this method
	{
		return  driver.findElement(verificationBox).getAttribute("value");
	}
	public void clickOnSubmit()
	{
		driver.findElement(submit).click();
	}
	public boolean findSuccessMessageBox()
	{
		return driver.findElement(successMessageBox).isDisplayed();
	}
	public String getSuccessMessageText()
	{
		String liveMessage = driver.findElement(successMessageBox).getText();
		return liveMessage;
	}
	public void clickOnShopButton()
	{
		driver.findElement(shopButton).click();
	}
	public boolean verifyOrderTotalAfterRemoval()
	{
		boolean orderTotalAfterRemoval = driver.findElement(orderTotalElementAfterRemoval).isDisplayed();
		return orderTotalAfterRemoval;
	}
}

