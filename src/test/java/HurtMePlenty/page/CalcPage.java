package HurtMePlenty.page;

import ICanWin.page.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalcPage extends AbstractPage {

    public CalcPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input_85']")
    public WebElement searchNumOfInst;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_80']")
    public WebElement searchInstType;

    @FindBy(xpath = "//md-option[@id='select_option_195']")
    public WebElement searchInstTypeN1;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_81']")
    public WebElement searchMachType;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    public WebElement searchdropOption;

    @FindBy(xpath = "//div[@class='compute-engine-block']//form[@name='ComputeEngineForm']//md-checkbox[@aria-label='Add GPUs']")
    public WebElement checkGpu;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']") //md-input-container[@class='md-input-has-placeholder flex md-input-has-value']//md-select[@placeholder='GPU type']
    public WebElement gpuType;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    public WebElement gpuTypev100;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    public WebElement gpuNumber;

    @FindBy(xpath = "//div[@id=//md-select[@placeholder='Number of GPUs']/@aria-owns]//md-option[@value='1']")
    public WebElement gpuNum1;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_409']")
    public WebElement ssd;

    @FindBy(xpath = "//md-option[@id='select_option_436']//div[@class='md-text ng-binding']")
    public WebElement ssd2375;

    @FindBy(xpath = "//md-select[@id='select_118']")
    public WebElement datacenter;

    @FindBy(xpath = "//md-option[@id='select_option_220']")
    public WebElement datacenterFrankfurt;

    @FindBy(xpath = "//md-select[@id='select_125']")
    public WebElement usage;

    @FindBy(xpath = "//md-option[@id='select_option_123']")
    public WebElement cu1year;

    @FindBy(xpath = "(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]")
    public WebElement addToEstimate;

    public CalcPage waitLoad() {
        driver.switchTo().frame(driver.findElement(By.xpath("//article[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='input_85']")));
        driver.switchTo().defaultContent();
        return this;
    }

    public void scrollTo(WebElement element){
        Locatable a = (Locatable) element;
        Point p = a.getCoordinates().inViewPort();
        driver.switchTo().defaultContent();
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+(p.y - 30)+");"); //65 - header height
        driver.switchTo().frame(driver.findElement(By.xpath("//article[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
    }

    public CalcPage agreeCookie(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='devsite-snackbar-inner']/button"))).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//article[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
        return this;
    }

    public CalcPage fillInst1(int value) {
        searchNumOfInst.sendKeys(String.valueOf(value));
        return this;
    }
        public CalcPage searchInstType1() {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select-value[@id='select_value_label_80']")));
        scrollTo(searchInstType);
            searchInstType.click();
            return this;
    }
        public CalcPage searchInstTypeN11() {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@id='select_option_195']")));
            searchInstTypeN1.click();
            return this;
        }
    public CalcPage searchMachType1() {
        scrollTo(searchMachType);
        searchMachType.click();
        return this;
    }
    public CalcPage searchDropOption1() {
        scrollTo(searchdropOption);
        searchdropOption.click();
        return this;
    }
    public CalcPage checkGpu1() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='compute-engine-block']//form[@name='ComputeEngineForm']//md-checkbox[@aria-label='Add GPUs']")));
        checkGpu.click();
        return this;
    }
    public CalcPage gpuType1() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@placeholder='GPU type']")));
        scrollTo(gpuType);
        gpuType.click();
        return this;
    }
    public CalcPage gpuTypev1001() {
        gpuTypev100.click();
        return this;
    }
    public CalcPage gpuNumber1() {
        gpuNumber.click();
        return this;
    }
    public CalcPage gpuNumb1() {
        gpuNum1.click();
        return this;
    }
    public CalcPage ssd1() {
        scrollTo(ssd);
        ssd.click();
        return this;
    }
    public CalcPage ssd12375() {
        scrollTo(ssd2375);
        ssd2375.click();
        return this;
    }
    public CalcPage datacenter1() {
        scrollTo(datacenter);
        datacenter.click();
        return this;
    }
    public CalcPage datacenterFrankfurt1() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@id='select_option_220']"))).click();
        //scrollTo(datacenterFrankfurt);
        //datacenterFrankfurt.click();
        return this;
    }
    public CalcPage usage1() {
        scrollTo(usage);
        usage.click();
        return this;
    }
    public CalcPage cu1year1() {
        scrollTo(cu1year);
        cu1year.click();
        return this;
    }
    public CalcPage addToEstimate1() {
        scrollTo(addToEstimate);
        addToEstimate.click();
        return this;
    }

    @Override
    protected AbstractPage openPage() throws Exception {
        throw new Exception ("not implemented");
    }
}
