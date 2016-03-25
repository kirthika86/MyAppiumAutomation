package com.selenium.junit.web;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	
	private WebDriver driver;

    @Before
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
    }

    @Test
    public void loginCorrect() throws Exception {
            driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("login")).submit();
        //Assert the result page
        assertTrue("success message not present",
                driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
    }
    
    @Test
    public void loginInCorrect() throws Exception {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("Mithun");
        driver.findElement(By.id("password")).sendKeys("kirthika balu!");
        driver.findElement(By.id("login")).submit();
      //Assert the result page
        assertTrue("error message not present",
                driver.findElement(By.cssSelector(".flash.error")).isDisplayed());
        assertEquals("login error message not found", "Your username is invalid!\n×", driver.findElement(By.cssSelector(".flash.error")).getText());
        
    }
    @Test
    public void usernameInCorrect() throws Exception {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("Mithun");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("login")).submit();
      
        //Assert the result page
        assertTrue("error message not present",
        		driver.findElement(By.cssSelector(".flash.error")).isDisplayed());
        assertEquals("login error message not equal", "Your username is invalid!\n×", driver.findElement(By.cssSelector(".flash.error")).getText());
        Thread.sleep(10000);
        
    }
    
    
    @Test
    public void passwordInCorrect() throws Exception {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("kirthika balu!");
        driver.findElement(By.id("login")).submit();
      //Assert the result page
        assertTrue("success message not present",
                driver.findElement(By.cssSelector(".flash.error")).isDisplayed());
      assertEquals("login error message not equal","Your password is invalid!\n×",driver.findElement(By.cssSelector(".flash.error")).getText());
        
    }
    @After
    public void tearDown() throws Exception{
        driver.quit();
    }

}
