package HurtMePlenty.page;

import ICanWin.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstimateCalcPage extends AbstractPage {

    public EstimateCalcPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[contains(text(),'Region')]")
    public WebElement searchRegion;

    @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
    public WebElement searchCommitment;

    @FindBy(xpath = "//div[contains(text(),'Instance type')]")
    public WebElement searchInstanceType;

    @FindBy(xpath = "//div[contains(text(),'Local SSD: 2x375 GiB')]")
    public WebElement searchLocalSsd;

    @Override
    protected AbstractPage openPage() throws Exception {
        throw new Exception ("not implemented");
    }
}