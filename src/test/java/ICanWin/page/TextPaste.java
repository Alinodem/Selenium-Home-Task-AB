package ICanWin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class TextPaste extends AbstractPage {
    @FindBy(xpath="//div[@class='info-top']/h1")
    public WebElement title;
    @FindBy (xpath="//*[@class='expire']")
    public WebElement time;
    @FindBy (xpath="//ol[@class='bash']//*[text()='git config']")
    public WebElement bash;
    @FindBy (xpath="//*[@class='textarea -raw js-paste-raw']")
    public WebElement text;
    public TextPaste(WebDriver driver) {
        super(driver);
    }
    public void elementStyle () {
        bash.getCssValue("color");
        bash.getCssValue ("font-weight");
    }
    public void waitLoad () {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='info-top']/h1")));
    }
    @Override
    protected AbstractPage openPage() throws Exception {
        throw new Exception ("not implemented");
    }
}
