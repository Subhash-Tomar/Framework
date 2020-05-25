package restAssuredTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class test1 
{
	@Test
	public void Test2() 
	{
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.silentOutput", "true");

        System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");

		//ChromeOptions chromeOpt=new ChromeOptions();

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.booking.com/hotel/ie/spacious-2-bedroom-apartment-near-o-39-connell-st.en-gb.html?");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    WebElement element = driver.findElement(By.xpath("//*[@id=\"b2hotelPage\"]/script[24]"));
	    //String htmlCode = (String) ((JavascriptExecutor) driver).executeScript("return arguments[1].innerHTML;", element);
       String htmlsource=element.getAttribute("outerHTML").toString();
       
       if(htmlsource.contains("isVacationRental: '1'"))
       {
    	   System.out.print("hotel is Rental");
       }


	}

}
