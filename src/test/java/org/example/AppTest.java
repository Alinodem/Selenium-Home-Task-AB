package org.example;

import static org.junit.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup () {
        ChromeOptions options = new ChromeOptions();
        //options.add_experimental_option("excludeSwitches", ["enable-automation"]);
        //options.add_experimental_option('useAutomationExtension', False);
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
    }

    @Test(description = "I Can Win")

    public void iCanWin ()
    {
        driver.get("https://pastebin.com/");
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='AGREE']")));
        WebElement agreeBtn = driver.findElement(By.xpath("//button[text()='AGREE']"));
        agreeBtn.click();
        WebElement newPasteTextArea = driver.findElement(By.id("postform-text"));
        newPasteTextArea.sendKeys("Hello from WebDriver");
        //Select dropdown = new Select (driver.findElement(By.xpath("//select[@id='postform-expiration']")));
        //dropdown.selectByValue("10M");//selectByVisibleText("10 Minutes");
        WebElement dropdown = driver.findElement(By.id("select2-postform-expiration-container"));
        dropdown.click();
        WebElement option10 = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
        option10.click();
        WebElement pasteName = driver.findElement(By.id("postform-name"));
        pasteName.sendKeys("helloweb");
        WebElement btnCnp = driver.findElement(By.xpath("//button[text()='Create New Paste']"));
        btnCnp.click();
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='info-top']/h1")));
        WebElement title = driver.findElement(By.xpath("//div[@class='info-top']/h1"));
        String time = driver.findElement(By.xpath("//*[@class='expire']")).getText().trim();
        WebElement text = driver.findElement(By.xpath("//*[@class='de1']"));
        Assert.assertEquals(title.getText(), "helloweb", "Title is not consistent.");
        Assert.assertEquals(time, "10 MIN", "Time is not consistent");
        Assert.assertEquals(text.getText(), "Hello from WebDriver", "Text is not consistent");
        driver.quit();
    }
    @AfterMethod (alwaysRun = true)
    public void browserTearDown () {
        driver.quit();
        driver=null;
    }
}
