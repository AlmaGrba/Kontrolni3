package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Home;
import objects.Inventory;

public class TestSajt {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 0)
	public void testInvalidData() {
		File f = new File("data.xlsx");
		try {
			InputStream inp = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(0);
			Row row1 = sheet.getRow(1);
			String invalidUser = row.getCell(0).toString();
			String invalidPass = row.getCell(1).toString();

			driver.navigate().to(Home.URL);
			driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(invalidUser);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(invalidPass);
			driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

			String current = driver.getCurrentUrl();
			String expected = "https://www.saucedemo.com/";

			Assert.assertEquals(current, expected);
			wb.close();

		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	public void testValidData() {
		SoftAssert sa = new SoftAssert();
		File f = new File("data.xlsx");
		try {
			InputStream inp = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row;
			for (int i=1; i<5; i++) {
			row = sheet.getRow(i);
			String validUser = row.getCell(0).toString();
			String validPass = row.getCell(1).toString();

			driver.navigate().to(Home.URL);
			driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(validUser);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(validPass);
			driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

			String current = driver.getCurrentUrl();
			String expected = "https://www.saucedemo.com/inventory.html";
			sa.assertEquals(current, expected); }

			wb.close();
			sa.assertAll();

		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void sortItems() {
		driver.navigate().to(Inventory.URL);
		double[] niz = { 29.99, 9.99, 15.99, 49.99, 7.99, 15.99 };
		Inventory.sortiranje(niz);
		Inventory.sortItems(driver);
		double[] expected = { 7.99, 9.99, 15.99, 15.99, 29.99, 49.99 };
		Assert.assertEquals(niz, expected);
	}
}
