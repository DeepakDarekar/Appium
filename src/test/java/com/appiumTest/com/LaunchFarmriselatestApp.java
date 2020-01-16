package com.appiumTest.com;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchFarmriselatestApp {

	AndroidDriver<?> driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void launchapp() throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		File file = new File("C:\\Users\\darekdee\\Automation\\AppiumTest\\apk\\farmrise_latest.apk");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability("app", file.getAbsolutePath());
		caps.setCapability("autoLaunch", true);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void setUpApp() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.climate.farmrise:id/txt_alphabet') and @text='a']")).click();
		driver.findElement(By.id("com.climate.farmrise:id/btn_Proceed")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Cabbage']")).click();
		driver.findElement(By.id("com.climate.farmrise:id/btn_Proceed")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'com.climate.farmrise:id/btn_allow_proceed') and @text='Allow and Proceed']")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'com.android.packageinstaller:id/permission_allow_button') and @text='ALLOW']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.climate.farmrise:id/tv_dismiss') and @text='OK']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.climate.farmrise:id/tv_dismiss') and @text='OK']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.climate.farmrise:id/tv_dismiss') and @text='OK']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.climate.farmrise:id/tv_dismiss') and @text='OK']")).click();
		
		String actualURL = driver.getCurrentUrl();
		assertEquals(actualURL, "https://www.toolsqa.com/");
		
		
	}

}
