package com.contact.app;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AddContactsApp {
	@Test
	public void AddingContacts() throws MalformedURLException {

		// Appium Code to Launch the Calculator App without .apk File

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		capabilities.setCapability("autoLaunch", true);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("com.android.contacts:id/floating_action_button").click();
		driver.findElementByXPath(("//android.widget.Button[@text='KEEP LOCAL']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<AndroidElement> txtbox = driver.findElements(By.className("android.widget.EditText"));
		txtbox.get(0).sendKeys("Deepak");
	//	driver.pressKeyCode(AndroidKeyCode.ENTER);

//		driver.scrollTo("Phone");
		List<AndroidElement> txtbox1 = driver.findElements(By.className("android.widget.EditText"));
		txtbox1.get(0).sendKeys("9999999999");

		driver.findElement(By.className("android.widget.ImageButton")).click();

	}
}

/*
 * public class AddContactsApp { // Add TestNG Dependency Use the Version
 * According to u r TestNG installed // Eclipse Version // Add Appium Dependency
 * Latest Version
 * 
 * private static AndroidDriver<MobileElement> driver;
 * 
 * @BeforeClass public void beforeMethod() throws MalformedURLException,
 * InterruptedException {
 * 
 * DesiredCapabilities capabilities = new DesiredCapabilities();
 * 
 * capabilities.setCapability("platformName", "Android");
 * capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
 * "emulator-5554"); capabilities.setCapability("appPackage",
 * "com.android.contacts"); capabilities.setCapability("appActivity",
 * "com.android.contacts.activities.PeopleActivity");
 * capabilities.setCapability("autoLaunch", true); AndroidDriver<AndroidElement>
 * driver = new AndroidDriver<AndroidElement>( new
 * URL("http://127.0.0.1:4723/wd/hub"), capabilities);
 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }
 * 
 * @Test public void AddContactTest() throws MalformedURLException {
 * driver.findElement(By.id("com.android.contacts:id/floating_action_button")).
 * click();
 * //driver.findElement(By.xpath("//android.widget.Button[@text='DEL']")).click(
 * ); }
 * 
 * @AfterMethod public void afterMethod() { driver.quit(); } }
 */