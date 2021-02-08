package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	public static final String URL = "https://www.saucedemo.com/";
	//public static final String URL_INVENTORY = "https://www.saucedemo.com/inventory.html";

	public static void invalidData(WebDriver driver) {

		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user1");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123");

		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	public static void invalidData1(WebDriver driver) {

		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("Alma");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Grba");

		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	public static void validData(WebDriver driver) {

		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	/*public static void validData1(WebDriver driver) {

		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("locked_out_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	public static void validData2(WebDriver driver) {

		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("problem_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	public static void validData3(WebDriver driver) {

		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("performance_glitch_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}*/

	//public static void sortInventory(WebDriver driver) {

		//driver.get(URL_INVENTORY);
		//driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select")).click();
		//driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[3]")).click();
		//driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select")).sendKeys("Price (low to high)");
		//WebElement price = driver.findElement(By.xpath("//*[@id=\\\"inventory_filter_container\\\"]/select"));
		//price.sendKeys("Price (low to high)");
		//driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[3]")).sendKeys(Keys.ENTER);
		
	}
