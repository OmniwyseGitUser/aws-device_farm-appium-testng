package com.flipkart;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SampleTestNGTest {
	AppiumDriver<MobileElement> driver;
	final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

	@BeforeMethod
	public void beforeTest() throws MalformedURLException {

		URL url = new URL(URL_STRING);

		//Use a empty DesiredCapabilities object
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		driver = new AndroidDriver<MobileElement>(url, capabilities);

		//Use a higher value if your mobile elements take time to show up
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {
		try {
			driver.findElement(By.id("com.flipkart.android:id/btn_skip")).click();
		} catch (Exception e) {
		}
		driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox")).click();
		driver.findElement(By.id("com.flipkart.android:id/search_autoCompleteTextView")).sendKeys("Latest mobiles");
		
		TimeUnit.SECONDS.sleep(8);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
