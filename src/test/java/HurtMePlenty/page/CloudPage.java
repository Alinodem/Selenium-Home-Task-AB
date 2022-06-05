package HurtMePlenty.page;

import ICanWin.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudPage extends AbstractPage {

    //@FindBy(xpath = "//div[@class='devsite-search-container']//*[@class='devsite-search-button devsite-header-icon-button button-flat material-icons']")
    @FindBy(xpath = "//button[@class='devsite-search-button devsite-header-icon-button button-flat material-icons']/..")
    public WebElement searchLoop;

    @FindBy(xpath = "//div[@class='devsite-searchbox']//input")
    public WebElement searchInput;

    public CloudPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //PageFactory.initElements(driver, this);
    }

    public CloudPage waitLoad () {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='devsite-search-button devsite-header-icon-button button-flat material-icons']")));
        return this;
    }

    public CloudPage openSearch() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(searchLoop));
        searchLoop.click();
        return this;
    }

    public CloudPage fillSearchText(String text) {
        searchInput.sendKeys(text);
        return this;
    }

    public CloudPage allResultsSearch(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button-white devsite-suggest-all-results']")));
        WebElement button = driver.findElement(By.xpath("//button[@class='button button-white devsite-suggest-all-results']"));
        button.click();
        return this;
    }
    @Override
    public CloudPage openPage() {

        driver.get("https://cloud.google.com/");
        return this;
    }
}
