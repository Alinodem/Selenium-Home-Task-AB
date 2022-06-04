package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriver driver = new ChromeDriver ();
        driver.get("https://pastebin.com/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='AGREE']")));
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


    }
}
