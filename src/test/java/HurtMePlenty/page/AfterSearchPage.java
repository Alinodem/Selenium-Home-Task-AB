package HurtMePlenty.page;

import HurtMePlenty.test.HurtMePlenty;
import ICanWin.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class AfterSearchPage extends AbstractPage {
        public AfterSearchPage(WebDriver driver) {
            super(driver);
        }
        public void chooseItem (String text) {
            String path = "//a/b[text()='"+text+"']/..";
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(path))).click();
        }

        @Override
        protected AbstractPage openPage() throws Exception {
            throw new Exception ("not implemented");
        }
    }
