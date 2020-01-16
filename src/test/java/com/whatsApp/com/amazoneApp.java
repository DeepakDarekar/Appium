package com.whatsApp.com;

import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

public class amazoneApp {
	public AndroidDriver<?> driver;

@BeforeTest
	public void setUp() throws MalformedURLException {
	
	 	DesiredCapabilities dc = new DesiredCapabilities();
	 	
	 	dc.setCapability("platformName", "Android");
	 	dc.setCapability("platformVersion", "7.1.1");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	 	File file = new File("C:\\Users\\darekdee\\Automation\\Appium\\src\\test\\resources\\amazone.in.apk");
	  	dc.setCapability("app", file.getAbsolutePath());
		dc.setCapability("autoLaunch", true);
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
	 	dc.setCapability("automationName", "UiAutomator2");
	 	
	 	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
}   
		
	@Test
		public void firstTest() throws InterruptedException {
		driver.findElement(By.id("Login Screen")).click();
}
}

