package ICanWin.test;

import ICanWin.page.Page;
import ICanWin.page.TextPaste;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ICanWin_BringItOn
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
        new Page(driver)
                .openPage ()
                .cookieAgree()
                .setExpiration("10 Minutes")
                .fillText("Hello from WebDriver")
                .fillName("helloweb")
                .save();

        TextPaste page = new TextPaste(driver);

        page.waitLoad();

        Assert.assertEquals(page.title.getText(), "helloweb", "Title is not consistent.");
        Assert.assertEquals(page.time.getText(),"10 MIN", "Time is not consistent");
        Assert.assertEquals(page.text.getText(), "Hello from WebDriver");
        driver.quit();
    }

    @Test(description = "Bring It On")
    public void bringItOn ()
    {
        new Page(driver)
                .openPage ()
                .cookieAgree()
                .setExpiration("10 Minutes")
                .SyntaxHighlighting("Bash")
                .fillText("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .fillName("how to gain dominance among developers")
                .save();

        TextPaste page = new TextPaste(driver);

        page.waitLoad();

        Assert.assertEquals(page.title.getText(), "how to gain dominance among developers", "Title is not consistent.");
        Assert.assertEquals(page.time.getText(),"10 MIN", "Time is not consistent");
        Assert.assertEquals(page.bash.getCssValue("color"),"rgba(194, 12, 185, 1)", "Syntax Highlighting is not consistent - color");
        Assert.assertEquals(page.bash.getCssValue ("font-weight"),"700", "Syntax Highlighting is not consistent - font-weight");
        Assert.assertEquals(page.text.getText(), "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force", "Text is not consistent");
        driver.quit();
    }
    @AfterMethod (alwaysRun = true)
    public void browserTearDown () {
        driver.quit();
        driver=null;
    }
}
