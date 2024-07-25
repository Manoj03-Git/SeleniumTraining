package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	public static WebDriver driver;

    public static void launchBrowser() {
    	WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

	public static void WindowMaximize() {

		driver.manage().window().maximize();

	}

	public static void LaunchUrl(String Url) {

		driver.get(Url);

	}

	public static String PageTitle() {

		String title = driver.getTitle();
		return title;

	}

	public static String pageUrl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public static void passtext(String txt, WebElement ele) {
		ele.sendKeys(txt);

	}

	public static void closeEntireBrowser() {

		driver.quit();
	}

	public static void clickbutton(WebElement ele) {

		ele.click();

	}

	public static void ScreenShot(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("loaction+ imgname.png");
		FileUtils.copyFile(image, f);

	}

	public static Actions a;

	public static void movethecursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();

	}

	public static void dragdrop(WebElement dragElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragElement, dropElement).perform();

	}

	public static JavascriptExecutor js;

	public static void scrollthePage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", tarWebEle);

	}

	public static void scroll(WebElement Ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", Ele);

	}

	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excelLocation.xlsx");
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet mysheet = wb.getSheet("Datas");
		XSSFRow r = mysheet.getRow(rowNum);
		XSSFCell c = r.getCell(cellNum);
		int cellType = c.getCellType();

		String value = " ";

		if (cellType == 1) {
			String value2 = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);

		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
		}

	}
	
	
	public static void createNewExcelFile(int rowNum , int cellNum, String newData ) throws IOException {
		
		File f = new File("C:\\Users\\Manoj kumar\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newSheet = w.createSheet("Datas");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}
	
	public static void createCell(int rowNum , int cellNum, String newData ) throws IOException {
		
		File f = new File("C:\\Users\\Manoj kumar\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("Datas");
		Row r = s.getRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		

	}
	
	public static void createRow(int creRow, int creCell ,String newData) throws IOException {
		
		File f = new File("C:\\\\Users\\\\Manoj kumar\\\\eclipse-workspace\\\\MavenProject\\\\Excel\\\\newfile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		
		
		

	}
	
	
	
	
	

}
