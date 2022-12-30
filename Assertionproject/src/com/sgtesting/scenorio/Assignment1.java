package com.sgtesting.scenorio;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment1 {
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
        @Test(priority=4,dataProvider="Createuser")
	private static void Createuser(String fname,String lname,String mail,String username,String password1,String passwordcopy)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[1]")).click();
			Thread.sleep(5000);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(5000);
			oBrowser.findElement(By.name("firstName")).sendKeys(fname);
			oBrowser.findElement(By.name("lastName")).sendKeys(lname);
			oBrowser.findElement(By.name("email")).sendKeys(mail);
			oBrowser.findElement(By.name("username")).sendKeys(username);
			oBrowser.findElement(By.name("password")).sendKeys(password1);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(passwordcopy);
			oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(5000);
			WebElement oEle=oBrowser.findElement(By.xpath("//span[text()='User2, demoss']"));
			Assert.assertTrue(oEle.isDisplayed());

		}catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
       @Test(priority=5)
	private static void deleteuser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='userListTableContainer']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]")).click();
			Thread.sleep(5000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(5000);
			Alert oAlert=oBrowser.switchTo().alert();
			Thread.sleep(4000);
			String content=oAlert.getText();
			System.out.println(content);
			oAlert.accept();
			Thread.sleep(3000);
			
		}catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
       @Test(priority=6)
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
      @Test(priority=7)
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
        
