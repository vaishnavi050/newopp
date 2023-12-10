package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import commonutils.excelutil;
import commonutils.fileutil;
import commonutils.webdriver;

public class VtigerTest {
	
	public WebDriver driver;
	@Test
	public void Vtigercrm() throws IOException {
		
		
		   excelutil eutil=new excelutil();
			fileutil futil =new fileutil();
			webdriver wutil =new webdriver();
			
		//	String bro = futil.getDataFromPropertyFile("browser");
		//	String URL = futil.getDataFromPropertyFile("url");
			
			String bro = eutil.getDataFromExelSheet("Sheet1", 0, 1);
			String URL = eutil.getDataFromExelSheet("Sheet1", 1, 1);
		    String us = eutil.getDataFromExelSheet("Sheet1", 2,1);
			String ps = eutil.getDataFromExelSheet("Sheet1", 3,1);
////==============================================================================================
				String orgname = eutil.getDataFromExelSheet("Sheet1", 4, 1);
				String curl = eutil.getDataFromExelSheet("Sheet1", 6, 1);
				String purl = eutil.getDataFromExelSheet("Sheet1", 7, 1);
				String value = eutil.getDataFromExelSheet("Sheet1", 8, 1);
				String date = eutil.getDataFromExelSheet("Sheet1", 5, 1);
				String val = eutil.getDataFromExelSheet("Sheet1", 9, 1);
		        
			    
			if(bro.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(bro.equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
			}
			else {
				driver=new FirefoxDriver();
			
			}
			
			driver.get(URL);
			
			
			driver.findElement(By.name("user_name")).sendKeys(us);
			driver.findElement(By.name("user_password")).sendKeys(ps);
			driver.findElement(By.id("submitButton")).click();

			

			
			
			driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();
			driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
			
			driver.findElement(By.name("potentialname")).sendKeys(orgname);
			driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
			wutil.switchWindow(driver, curl);
			driver.findElement(By.id("search_txt")).sendKeys("t");
			driver.findElement(By.xpath("//input[@type='button']")).click();
			driver.findElement(By.id("1")).click();
			wutil.switchWindow(driver, purl);
			
			driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
			WebElement dd = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
			wutil.handleDropdownfortitle(dd, value);
			
			driver.findElement(By.id("jscal_field_closingdate")).sendKeys(date);
			driver.findElement(By.xpath("//select[@name='sales_stage']")).click();
			wutil.handleDropdownfortitle(dd, val);
			
		

		
	}

}
