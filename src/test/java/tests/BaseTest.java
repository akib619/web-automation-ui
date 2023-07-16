package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import utils.Config;
import utils.JsonDataReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected Browser browser;

    @BeforeMethod
    public void setUp() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        
        String url = JsonDataReader.readJson("src/main/java/resources/config.json", Config.class).getUrl();
        browser.goTo(url);

        browser.waitForPageToLoad();
    }

    @AfterMethod
    public void tearDown() {
        if (browser.isStarted()) {
            browser.quit();
        }
    }
}
