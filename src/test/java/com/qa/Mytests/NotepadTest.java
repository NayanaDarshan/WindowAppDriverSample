package com.qa.Mytests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class NotepadTest {

	public static WindowsDriver driver = null;

	@BeforeMethod

	public void setup() {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platform", "windows");
		cap.setCapability("devicename", "windowspc");

		try {

			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 2)
	public void checkhelpabouttest() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByName("Help").click();
		driver.findElementByName("About Notepad").click();
		driver.findElementByName("OK").click();

	}

	@Test(priority = 1)

	public void enterdata() {

		driver.findElementByName("Text Editor").sendKeys("Nayana doing automation of desktop application");
		driver.findElementByName("Text Editor").clear();
	}

	@Test(priority = 3)

	public void Timedateentry() {

		driver.findElementByName("Edit").click();
		// driver.findElementByName("Time/Date").click();
		driver.findElementByAccessibilityId("26").click();
		String date_time = driver.findElementByName("Text Editor").getAttribute("Value.Value");

		System.out.println("The current date is ====>" + date_time);
		
		String s= driver.switchTo().alert().getText();
		System.out.println("s");
		
	 //  driver.switchTo().alert().dismiss();
		
	//	driver.findElementByAccessibilityId("CommandButton_2").click();
		//driver.findElementByClassName("CCPushButton").click();

	
	
	}

	@AfterMethod

	public void cleanup() {
		driver.quit();

	}

}
