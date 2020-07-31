package pcHome;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import functions.Base;
import pageObjects.pcShoppingObjects;

public class demo extends Base{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/angularpractice/shop");
		
		/*driver.findElement(By.cssSelector("input[type='submit']")).click();
		String x = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(x);
		By textAboveDateBox = By.cssSelector("label[for='dateofBirth']");
		String tagName_dateBox = "input";
		String female_doB = getDoB_female();
		driver.findElement(withTagName(tagName_dateBox).below(textAboveDateBox)).click();
		Thread.sleep(2000);
		driver.findElement(withTagName(tagName_dateBox).below(textAboveDateBox)).sendKeys(female_doB);
		System.out.println(female_doB);*/
		
		/*By dropdownObject = By.id("exampleFormControlSelect1");
		driver.findElement(dropdownObject).click();
		Select selectObject = new Select((driver.findElement(dropdownObject)));
		selectObject.selectByVisibleText("Female");*/
		
		/*driver.findElement(By.xpath("//input[@name='name']")).sendKeys("quertyasdfg");
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector(".ng-untouched.ng-pristine.ng-valid")).getAttribute("value"));*/
		
		/*String a = driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li/a")).getText();
		System.out.println(a);*/
		
		
		/*pcShoppingObjects shoppingObjects = new pcShoppingObjects(driver);
		shoppingObjects.clickOnSecondAddButton();
		shoppingObjects.clickOnBlueCheckoutButton();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("4");
		String b = driver.findElement(By.xpath("/html/body/app-root/app-shop/div/div/div/table/tbody/tr[2]/td[5]/h3/strong")).getText();
		System.out.println(b);*/
		
		pcShoppingObjects shoppingObjects = new pcShoppingObjects(driver);
		shoppingObjects.clickOnSecondAddButton();
		shoppingObjects.clickOnBlueCheckoutButton();
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
	}

}
