package activities;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity11 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/simple-form");
    }

    public static List<List<String>> readExcel(String filePath) {

        List<List<String>> data = new ArrayList<>();

        try {

            Workbook workbook =
                    new XSSFWorkbook(
                            new FileInputStream(filePath));

            Sheet sheet =
                    workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                List<String> rowData =
                        new ArrayList<>();

                for (Cell cell : row) {

                    switch (cell.getCellType()) {

                        case STRING:
                            rowData.add(
                                    cell.getStringCellValue()
                                            .trim());
                            break;

                        case NUMERIC:

                            if (DateUtil.isCellDateFormatted(cell)) {

                                rowData.add(
                                        cell.getLocalDateTimeCellValue()
                                                .format(
                                                        DateTimeFormatter.ofPattern(
                                                                "yyyy-MM-dd")));

                            } else {

                                rowData.add(
                                        String.valueOf(
                                                cell.getNumericCellValue()));
                            }

                            break;

                        default:
                            rowData.add("-");
                    }
                }

                data.add(rowData);
            }

            workbook.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return data;
    }

    @DataProvider(name = "excelDataProvider")
    public static Object[][] inputData() {

        List<List<String>> excelData =
                readExcel("src/test/resources/input.xlsx");

        Object[][] data =
                new Object[excelData.size()][];

        for (int i = 0; i < excelData.size(); i++) {

            data[i] =
                    excelData.get(i).toArray();
        }

        return data;
    }

    @Test(priority = 1)
    public void verifyPageTitle() {

        assertEquals(
                driver.getTitle(),
                "Selenium: Simple Form");
    }

    @Test(priority = 2,
            dataProvider = "excelDataProvider")
    public void registerTest(String[] rows) {

        driver.findElement(By.id("full-name"))
                .sendKeys(rows[0]);

        driver.findElement(By.id("email"))
                .sendKeys(rows[1]);

        driver.findElement(By.name("event-date"))
                .sendKeys(rows[2]);

        driver.findElement(By.id("additional-details"))
                .sendKeys(rows[3]);

        driver.findElement(
                By.xpath("//button[text()='Submit']"))
                .click();

        String message =
                driver.findElement(
                        By.id("action-confirmation"))
                        .getText();

        System.out.println(message);

        assertEquals(
                message,
                "Your event has been scheduled!");

        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}