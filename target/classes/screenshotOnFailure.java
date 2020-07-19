package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotOnFailure 
{
	File sourceFile;
	public String timeDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    return formatter.format(date);  
	}
	public void getScreenshot(String methodName, WebDriver driver) throws IOException
	{
		sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir")+"/Screenshots/"+methodName+timeDate()+".png";
		FileUtils.copyFile(sourceFile, new File(DestinationFile));
	}
}
