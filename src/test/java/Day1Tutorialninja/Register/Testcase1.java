package Day1Tutorialninja.Register;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase1 {

	@Test
	public  void RegisterWithMandatory() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Pawan");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8956634543");
		driver.findElement(By.id("input-password")).sendKeys("pawan123");
		driver.findElement(By.id("input-confirm")).sendKeys("pawan123");
		driver.findElement(By.name("agree")).click(); 
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
        String expectheading= "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(), expectheading);
		
		String expectheading2= "Congratulations! Your new account has been successfully created!";
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).getText(), expectheading2);
        
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed());
		String Accountcheck= "My Account";
		Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText(), Accountcheck);
		driver.quit();
	}
	public  String generateEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
	 
		
	}

}
