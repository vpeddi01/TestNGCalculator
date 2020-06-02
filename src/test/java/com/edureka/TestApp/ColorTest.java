package com.edureka.TestApp;

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

public class ColorTest 
{    	
    @Test
    void testSiteColor() throws Exception  {
		
	    WebDriver driver;
	    
	    Properties prop = new Properties();
	    FileInputStream f = new FileInputStream("./data.properties");
	    prop.load(f);
	    String myIP = prop.getProperty("public_ip");
	    String myPort = prop.getProperty("tomcat_port");
	    String myAppName = prop.getProperty("app_name");

	    if(System.getenv("MY_IP")!=null){
		    myIP=System.getenv("MY_IP");
	    }
	    String myURL = "http://" + myIP + ":" + myPort + "/" + myAppName;
	    System.out.println("Opening URL " + myURL);

	    FirefoxOptions options = new FirefoxOptions();
        
            options.addArguments("--headless");
	    
            String mygecko= prop.getProperty("webdriver_path") + "geckodriver";

            System.setProperty("webdriver.gecko.driver",mygecko);
        
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        
            driver = new FirefoxDriver(options);
        
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	    System.out.println("Opening " + myURL);

            driver.get(myURL);
        
            Thread.sleep(5000);
        
            String mycolor = driver.findElement(By.tagName("body")).getAttribute("bgcolor");
	    
	    Assert.assertEquals(mycolor, "Aqua");
        
            driver.quit();
	}
}
