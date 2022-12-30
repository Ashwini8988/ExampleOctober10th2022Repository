package com.sgtesting.scenorio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment8 {
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
    private static void createcustomer()
	{
		try
		{
			oBrowser.manage().window().maximize();
			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr/td[3]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//div[text()='Add New']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("/html/body/div[12]/div[1]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("customerLightBox_nameField")).sendKeys("Productcompany");
			oBrowser.findElement(By.id("customerLightBox_descriptionField")).sendKeys("it is big company");
			oBrowser.findElement(By.xpath("//span[text()='Create Customer']")).click();
			Thread.sleep(2000);
		}catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
    @Test(priority=5)
	private static void createproject()
	{
		try
		{
			oBrowser.findElement(By.xpath("//div[text()='Add New']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("/html/body/div[12]/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("projectPopup_projectNameField")).sendKeys("vehicalinsurance");
            oBrowser.findElement(By.id("projectPopup_projectDescriptionField")).sendKeys("it is very helpful project");
            oBrowser.findElement(By.xpath("//span[text()='Create Project']")).click();
            Thread.sleep(2000);
		}catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
    @Test(priority=6)
    private static void createtask()
	{
		try
		{
			
			oBrowser.findElement(By.xpath("//div[text()='Add New Task']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//div[text()='Create new tasks']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\"createTasksPopup_createTasksTableContainer\"]/table/tbody/tr[1]/td[1]/input")).sendKeys("software tools");
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'createTasksPopup_createTasksTableContainer\']/table/tbody/tr[2]/td[1]/input")).sendKeys("testcases");
			oBrowser.findElement(By.xpath("//*[@id=\'createTasksPopup_createTasksTableContainer\']/table/tbody/tr[3]/td[1]/input")).sendKeys("models");
			oBrowser.findElement(By.xpath("//*[@id=\'createTasksPopup_createTasksTableContainer\']/table/tbody/tr[4]/td[1]/input")).sendKeys("design");
			oBrowser.findElement(By.xpath("//*[@id=\'createTasksPopup_createTasksTableContainer\']/table/tbody/tr[5]/td[1]/input")).sendKeys("Structure");
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//span[text()='Create Tasks']")).click();
			Thread.sleep(2000);
			
		}catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
    @Test(priority=7)
	private static void deletetask()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[1]/table/tbody/tr/td[1]/div/div")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//span[text()='Delete']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("deleteTaskPopup_deleteConfirm_submitBtn")).click();
			Thread.sleep(3000);
		}catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
    @Test(priority=8)
	private static void deleteproject()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[1]/div[2]/div[3]/div/div/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[4]/div/div[3]/div")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'projectPanel_deleteConfirm_submitTitle\']")).click();
			Thread.sleep(5000);
		}catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
    @Test(priority=9)
	private static void deletecustomer()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[4]/div/div/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[4]/div/div[3]/div")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'customerPanel_deleteConfirm_submitTitle\']")).click();
			Thread.sleep(4000);
		}catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
    @Test(priority=10)
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
        @Test(priority=11)
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
}
