package LoginApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver .manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void validLogin()
	{
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
		Assert.assertEquals(heading.getText(), "Secure Area");
	}
	@Test
	public void invalidLoginTest()
	{
		driver.findElement(By.id("username")).sendKeys("wrongusername");
		driver.findElement(By.id("password")).sendKeys("wrongpassword");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
		Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"));
	}
	@Test
	public void emptyFieldsTest()
	{
	    driver.findElement(By.id("username")).sendKeys("");
	    driver.findElement(By.id("password")).sendKeys("");
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
	    Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"));
	}
	@AfterMethod
	public void tearDown()
	{
	    driver.quit();
	}

}


