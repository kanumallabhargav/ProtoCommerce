package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import functions.Base;

public class pcShoppingObjects extends Base
{
	WebDriver driver;
	Properties prop = new Properties();
	private By firstAddButton = By.xpath("//html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[1]/div/div[2]/button");
	private By secondAddButton = By.xpath("/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[2]/div/div[2]/button");
	private By thirdAddButton = By.xpath("/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[3]/div/div[2]/button");
	private By fourthAddButton = By.xpath("/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[4]/div/div[2]/button");
	private By blueCheckoutButton = By.xpath("//*[@id='navbarResponsive']/ul/li/a");
	private By greenCheckoutButton = By.xpath("/html/body/app-root/app-shop/div/div/div/table/tbody/tr[4]/td[5]/button");
	private By countryBox = By.cssSelector("input[id='country']");
	private By selectCountry = By.xpath("/html/body/app-root/app-shop/div/app-checkout/div/div[2]/ul/li/a");
	private By checkboxTermsandConditions = By.xpath("//input[@id='checkbox2']");
	private By purchaseButton = By.xpath("//input[@type='submit']");
	private By verificationBox = By.xpath("/html/body/app-root/app-shop/div/app-checkout/div[2]/div");
	private By continueShoppingButton = By.cssSelector(".btn.btn-default");
	private By homePageValidatorElement = By.xpath("//div[@class='list-group']");
	private By quantityBox = By.id("exampleInputEmail1");
	private By orderTotalElement = By.xpath("/html/body/app-root/app-shop/div/div/div/table/tbody/tr[2]/td[5]/h3/strong");
	private By removeButton = By.cssSelector(".btn.btn-danger");
	private By itemToBeRemoved = By.xpath("/html/body/app-root/app-shop/div/div/div/table/tbody/tr[1]/td[5]/h3/strong");

	public pcShoppingObjects(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void clickOnFirstAddButton()
	{
		driver.findElement(firstAddButton).click();
	}
	public void clickOnSecondAddButton()
	{
		driver.findElement(secondAddButton).click();
	}
	public void clickOnThirdAddButton()
	{
		driver.findElement(thirdAddButton).click();
	}
	public void clickOnFourthAddButton()
	{
		driver.findElement(fourthAddButton).click();
	}
	public void clickOnBlueCheckoutButton()
	{
		driver.findElement(blueCheckoutButton).click();
	}
	public void clickOnGreenCheckoutButton()
	{
		driver.findElement(greenCheckoutButton).click();
	}
	public void countryBoxEnterText() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/Data.properties");
		prop.load(fis);
		String country = prop.getProperty("country");
		driver.findElement(countryBox).sendKeys(country);
	}
	public void selectCountryFromList()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountry));
		driver.findElement(selectCountry).click();
	}
	/*public void clickOnTermsAndConditionsCheckbox()
	{
		//driver.findElement(checkboxTermsandConditions).click();
		//driver.findElement(withTagName("").toLeftOf(termsLabel)).click();
		driver.findElement(termsLabel).click();
	}*/
	public void clickOnPurchaseButton()
	{
		driver.findElement(purchaseButton).click();
	}
	public boolean verifyBox()
	{
		return driver.findElement(verificationBox).isDisplayed();
	}
	public void clickOnContinueShoppingButton()
	{
		driver.findElement(continueShoppingButton).click();;
	}
	public boolean homePageValidator()
	{
		boolean verifyHomePage = driver.findElement(homePageValidatorElement).isDisplayed();
		return verifyHomePage;
	}
	public String checkItemsInCartAfterReturningToHomePage()
	{
		String textFromCheckoutButton = driver.findElement(blueCheckoutButton).getText();
		return textFromCheckoutButton;
	}
	public void increaseQuantity()
	{
		driver.findElement(quantityBox).sendKeys(Keys.BACK_SPACE);
		driver.findElement(quantityBox).sendKeys("4");
	}
	public String getOrderTotal()
	{
		String orderTotal = driver.findElement(orderTotalElement).getText();
		return orderTotal;
	}
	public void clickOnRemoveButton()
	{
		driver.findElement(removeButton).click();
	}
	public boolean verifyItemRemoval()
	{
		boolean itemVisibility = driver.findElement(itemToBeRemoved).isDisplayed();
		return itemVisibility;
	}
	public String verifyOrderTotal()
	{
		String orderTotalAfterRemoving = driver.findElement(itemToBeRemoved).getText();
		return orderTotalAfterRemoving;
	}
}
