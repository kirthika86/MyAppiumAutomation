package com.appium.junit.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class APIDemosJunit {
	
	private AppiumDriver<MobileElement> driver;
	private final String appiumEndPoint = "http://0.0.0.0:4723/wd/hub";
   
	@Before
	public void setUp() throws Exception {
		System.out.println("Before method called");
	    File appDir = new File("src/test/resources");
	    File app = new File(appDir, "ApiDemos-debug.apk");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AppSpeed");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    driver = new AndroidDriver<MobileElement>(new URL(appiumEndPoint), capabilities);
	    System.out.println("Driver loaded");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After method called");
		driver.quit();
	}

	@Test
	  public void tapApp() {
		System.out.println("tap App method called");
		driver.findElement(By.name("App")).click();
		driver.findElement(By.name("Action Bar")).click();
		driver.navigate().back();
		driver.findElement(By.name("Activity")).click();
		driver.navigate().back();
		driver.findElement(By.name("Alarm")).click();
		driver.navigate().back();
		driver.findElement(By.name("Alert Dialogs")).click();
		driver.navigate().back();
		driver.findElement(By.name("Device Admin")).click();
		driver.navigate().back();
		driver.findElement(By.name("Fragment")).click();
		driver.navigate().back();
		driver.findElement(By.name("Launcher Shortcuts")).click();
		driver.navigate().back();
		driver.findElement(By.name("Loader")).click();
		driver.navigate().back();
		driver.findElement(By.name("Menu")).click();
		driver.navigate().back();
		driver.findElement(By.name("Notification")).click();
		driver.navigate().back();
		driver.scrollTo("Search");
		driver.findElement(By.name("Search")).click();
		driver.navigate().back();
		driver.scrollTo("Service");
		driver.findElement(By.name("Service")).click();
		driver.navigate().back();
		driver.scrollTo("Text-To-Speech");
		driver.findElement(By.name("Text-To-Speech")).click();
		driver.navigate().back();
		driver.scrollTo("Voice Recognition");
		driver.findElement(By.name("Voice Recognition")).click();
		driver.navigate().back();
	  }
	@Test
	  public void tapContent() {
		System.out.println("tap content method called");
		driver.findElement(By.name("Content")).click();
	  }
	@Test
	  public void tapGraphics() {
		System.out.println("tap Graphics method called");
		driver.findElement(By.name("Graphics")).click();
	  }
	@Test
	  public void tapMedia() {
		System.out.println("tap Media method called");
		driver.findElement(By.name("Media")).click();
	}
	@Test
	  public void tapNFC() {
		System.out.println("tap NFC method called");
		driver.findElement(By.name("NFC")).click();
	}
	@Test
	  public void tapOS() {
		System.out.println("tap OS method called");
		driver.findElement(By.name("OS")).click();
	}
	@Test
	  public void tapPreference() {
		System.out.println("tap Preference method called");
		driver.findElement(By.name("Preference")).click();
	}
	@Test
	  public void tapText() {
		System.out.println("tap Text method called");
		driver.scrollTo("Text");
		driver.findElement(By.name("Text")).click();
	}
	@Test
	  public void tapViews() {
		System.out.println("tap Views method called");
		driver.scrollTo("Views");
		driver.findElement(By.name("Views")).click();
	}
}
	
	

