package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
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
}
