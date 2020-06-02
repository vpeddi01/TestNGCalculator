package com.edureka.TestCalculatorJar;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class CalcTest 
{    	
    public static void main(String[] args) throws IOException, InterruptedException
    {
		
	    WebDriver driver;
	    
	    //Properties prop = new Properties();
	    //FileInputStream f = new FileInputStream("./data.properties");
	    //prop.load(f);
	    //String myIP = prop.getProperty("public_ip");
	    //String myPort = prop.getProperty("tomcat_port");
	    //String myAppName = prop.getProperty("app_name");
	    //String myURL = "http://" + myIP + ":" + myPort + "/" + myAppName;
	    String myURL = "http://130.211.229.175:9090/calculator/";
	    FirefoxOptions options = new FirefoxOptions();
        
        //options.addArguments("--headless");
	    options.setCapability("requireWindowFocus", true);
        String mygecko=System.getenv("HOME") + "/Downloads/geckodriver";
        //String mygecko= prop.getProperty("webdriver_path") + "geckodriver";

        System.setProperty("webdriver.gecko.driver",mygecko);
        
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        
        driver = new FirefoxDriver(options);
        
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	    System.out.println("Opening " + myURL);

        driver.get(myURL);
        
        Thread.sleep(5000);
        
	    //String text = prop.getProperty("exp_add_text");
	    String text = "Addition";
	    //int len = text.length();

        String bodyText = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println(bodyText);
	    driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("12");
	    driver.findElement(By.xpath("/html/body/form/input[2]")).sendKeys("38");
        
	    driver.findElement(By.name("r1")).click();
	    
	    driver.findElement(By.xpath("/html/body/form/input[3]")).click();
	    Thread.sleep(5000);
	    
	    bodyText = driver.findElement(By.xpath("/html/body")).getText();
	    
	    System.out.println(bodyText);
	    
	    //Assert.assertEquals(bodyText.substring(0, len),text);
	    
	    Assert.assertTrue(bodyText.contains(text), text + " not found!" );
	    
	    Assert.assertTrue(bodyText.contains(text), "50 not found!" );
	    
	    Thread.sleep(5000);
	    
        driver.quit();
	}
}
