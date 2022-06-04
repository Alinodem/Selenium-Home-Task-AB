package ICanWin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page extends AbstractPage {
    @FindBy (id="postform-text")
    public WebElement newPasteTextArea;
    @FindBy (id="postform-name")
    public WebElement pasteName;

    @FindBy (xpath="//select[@id='postform-expiration']/..")
    public WebElement dropdown;

    @FindBy (xpath="//span[@id='select2-postform-format-container']")
    public WebElement dropdownbash;

    @FindBy (xpath="//button[text()='Create New Paste']")
    public WebElement saveButton;

    public Page (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Page cookieAgree () {
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='AGREE']")));
        WebElement agreeBtn = driver.findElement(By.xpath("//button[text()='AGREE']"));
        agreeBtn.click();
        return this;
    }

    public Page fillText (String text) {
        newPasteTextArea.sendKeys(text);
        return this;
    }

    public Page setExpiration (String text) {
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(dropdown));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown);
        actions.perform();
        dropdown.click();
        WebElement option10 = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
        option10.click();
        return this;
    }
    public Page SyntaxHighlighting (String text) {
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(dropdownbash));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownbash);
        actions.perform();
        dropdownbash.click();
        WebElement bash = driver.findElement(By.xpath("//li[text()='Bash']"));
        bash.click();
        return this;
    }

    public Page fillName (String text) {
        pasteName.sendKeys(text);
        return this;
    }
    public Page save () {
        saveButton.click();
        return this;
    }

    @Override
    public Page openPage() {

        driver.get("https://pastebin.com/");
        return this;
    }

}
