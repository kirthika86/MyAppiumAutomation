package com.selenium.testng.web;



import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	
	private WebDriver driver;
	
	
	@DataProvider(name="inValidCredentials")
	public Object[][] inValidCredentials() {
		
		int row = 4;
		int col = 2;
		Object[][] object = new Object[row][col];
		
		for(int j =0; j<row;j++){
			object[j][0] = "inValidUserName"+j;
			object[j][1] = "inValidPassword"+j;	
		}
		
		return object;
	}

    @BeforeTest
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
    
    @Test(dataProvider="inValidCredentials")
    public void loginInCorrect(String userId,String password) throws Exception {
    	System.out.println("UserId "+userId+" Password = "+password);
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys(userId);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).submit();
      //Assert the result page
        assertTrue("error message not present",
                driver.findElement(By.cssSelector(".flash.error")).isDisplayed());
        assertEquals("login error message not found", "Your username is invalid!\n×", driver.findElement(By.cssSelector(".flash.error")).getText());
        
    }
  
    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }

}
