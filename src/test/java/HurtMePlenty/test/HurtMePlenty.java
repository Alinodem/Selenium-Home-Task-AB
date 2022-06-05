package HurtMePlenty.test;

import HurtMePlenty.page.AfterSearchPage;
import HurtMePlenty.page.CalcPage;
import HurtMePlenty.page.CloudPage;
import HurtMePlenty.page.EstimateCalcPage;
import ICanWin.page.Page;
import ICanWin.page.TextPaste;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HurtMePlenty {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup () {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(description = "Hurt Me Plenty")

    public void hurtMePlenty () throws InterruptedException {
        new CloudPage(driver)
                .openPage()
                .waitLoad()
                .openSearch()
                .fillSearchText("Google Cloud Platform Pricing Calculator")
                .allResultsSearch();

        new AfterSearchPage(driver)
                .chooseItem("Google Cloud Pricing Calculator");

        new CalcPage(driver)
                .waitLoad()
                .agreeCookie()
                .fillInst1(8)
                .searchInstType1()
                .searchInstTypeN11()
                .searchMachType1()
                .searchDropOption1()
                .checkGpu1()
                .gpuType1()
                .gpuTypev1001()
                .gpuNumber1()
                .gpuNumb1()
                .ssd1()
                .ssd12375()
                .datacenter1()
                .datacenterFrankfurt1()
                .usage1()
                .cu1year1()
                .addToEstimate1();

        EstimateCalcPage resPage = new EstimateCalcPage(driver);
        Assert.assertEquals(resPage.searchRegion.getText(), "Region: Frankfurt", "Region is not consistent.");
        Assert.assertEquals(resPage.searchCommitment.getText(), "Commitment term: 1 Year", "Commitment term is not consistent.");
        Assert.assertEquals(resPage.searchInstanceType.getText(), "Instance type: n1-standard-8\n" +
                "Committed Use Discount applied", "Instance Type is not consistent.");
        Assert.assertEquals(resPage.searchLocalSsd.getText(), "Local SSD: 2x375 GiB\n" +
                "Committed Use Discount applied", "Local SSD is not consistent.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown () {
        driver.quit();
        driver=null;
    }
}
