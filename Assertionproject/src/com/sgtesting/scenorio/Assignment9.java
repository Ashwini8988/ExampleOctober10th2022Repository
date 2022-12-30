package com.sgtesting.scenorio;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment9 {
	public static WebDriver oBrowser=null;
	
    @Test(priority=1)
	private static void LaunchBrowser()
{
	try
	{
		System.setProperty("webdriver.chrome.driver", ".\\Library\\Driver\\chromedriver.exe");
		oBrowser=new ChromeDriver();
		
	}catch (Exception e)
	{
		e.printStackTrace();
	}
}
    @Test(priority=2)
private static void navigate()
{
	try
	{
		String expected,actual;
		expected="actiTIME - Login";
		oBrowser.get("http://localhost/user/submit_tt.do");
		Thread.sleep(5000);
		actual=oBrowser.getTitle();
		Assert.assertEquals(expected, actual);
		
	}catch (Exception e)
	{
		e.printStackTrace();
	}
}
    @Test(priority=3,dataProvider="Login")
private static void login(String uname,String password)
{
	try
	{
		
		oBrowser.findElement(By.id("username")).sendKeys(uname);
		oBrowser.findElement(By.name("pwd")).sendKeys(password);
		oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
		Thread.sleep(5000);
		WebElement oEle=oBrowser.findElement(By.xpath("//td[text()='Enter Time-Track']"));
		Assert.assertTrue(oEle.isDisplayed());
		Thread.sleep(2000);

	}catch (Exception e)
	{
		e.printStackTrace(); 
	}
}
    @Test(priority=4)
    private static void importTasks()
    {
    	try
    	{
    		oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[3]/a/div[2]")).click();
    		Thread.sleep(2000);
    		oBrowser.findElement(By.xpath("//div[text()='Add New Task']")).click();
    		Thread.sleep(2000);
    		oBrowser.findElement(By.xpath("//div[text()='Import tasks from CSV']")).click();
    		Thread.sleep(2000);
    		oBrowser.findElement(By.id("dropzoneClickableArea")).click();
    		Thread.sleep(2000);
    		String filepath="F:\\ExampleAutomation\\Sample.csv";
    		Thread.sleep(2000);
    		Robot robot=new Robot();
    		robot.keyPress(KeyEvent.VK_CONTROL);
    		robot.keyPress(KeyEvent.VK_V);
    		robot.keyRelease(KeyEvent.VK_CONTROL);
    		robot.keyRelease(KeyEvent.VK_V);
    		Thread.sleep(2000);
    		robot.keyPress(KeyEvent.VK_ENTER);
    		robot.keyRelease(KeyEvent.VK_ENTER);
    		Thread.sleep(2000);
    	}catch (Exception e) 
    	{
    		e.printStackTrace();
    	}
    }
    @Test(priority=5)
   	private static void Logout()
   	{
   		try
   		{
   			String expected,actual;
   			expected="actiTIME - Login";
   			oBrowser.findElement(By.linkText("Logout")).click(); 
   			Thread.sleep(2000);
   			actual=oBrowser.getTitle();
   			Assert.assertEquals(expected, actual);
   			Thread.sleep(2000);
   		}catch (Exception e)
   		{
   			e.printStackTrace(); 
   		}
   	}
         @Test(priority=6)
   	private static void closeApp()
   	{
   		try
   		{
   			oBrowser.quit();
   		}catch (Exception e)
   		{
   			e.printStackTrace(); 
   		}
   	}

           @DataProvider(name="Login")
           public Object[][] getLogin()
           {
           	return new Object[][] {{"admin","manager"}};
           }
           @DataProvider(name="Createuser")
           public Object[][] getCreateuser()
           {
           	return new Object[][] {{"demoss","User2","demoss@yahoo.com","demoUser2","Welcome12","Welcome12"}};
           }

}
