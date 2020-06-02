package com.edureka.TestApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SubChromeTest {

	@Test
    void testSub() throws IOException, InterruptedException
    {
		WebDriver driver;
		
	    Properties prop = new Properties();
	    FileInputStream f = new FileInputStream("./data.properties");
	    prop.load(f);
	    String myIP = prop.getProperty("public_ip");
 
	    String myPort = prop.getProperty("tomcat_port");
	    String myAppName = prop.getProperty("app_name");
	    String myURL = "http://" + myIP + ":" + myPort + "/" + myAppName;
	    //String myURL = "http://130.211.229.175:9090/calculator/";
	    System.out.println("Opening " + myURL);
	    
		System.setProperty("webdriver.chrome.driver","/home/edureka/Downloads/chromedriver");
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
	    System.setProperty("webdriver.chrome.verboseLogging", "true");
		System.out.println("System.setProperty!!");
		ChromeOptions chromeOptions = new ChromeOptions(); 
		chromeOptions.addArguments("headless"); 
		chromeOptions.addArguments("--no-sandbox");
	    driver = new ChromeDriver(chromeOptions); 
		System.out.println("driver!!");

        driver.get(myURL);
        System.out.println("baseUrl!!");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String test = driver.findElement(By.xpath("/html/body/h1")).getText();
        System.out.println("findElement!!" + test);
        
        System.out.println("Test Succeeded!!");
             
        //close Fire fox
        driver.quit();  
		
    }
}
