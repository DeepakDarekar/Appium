package com.calculator.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorAppAdd {
	// Add TestNG Dependency Use the Version According to yourTestNG installed
	// Eclipse Version
	// Add Appium Dependency Latest Version

	AppiumDriver<?> driver;

	@Test

	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		capabilities.setCapability("autoLaunch", true);

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(1500,TimeUnit.SECONDS);

		// Addition of 2 Numbers

		driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();

		AndroidElement results = driver.findElement(By.id("com.android.calculator2:id/result"));
		// Check the calculated value on the edit box
		try {
			assert results.getText().equals("13");
		} catch (Exception e) {
			System.out.println("Fail" + e.getMessage());
		}
		System.out.println("Actual value is : " + results.getText());

		// System.out.println("Actual value is : " + results.getText() + " did not match
		// with expected value: 13");

	}

}
