package tests;

import org.testng.annotations.Test;

import java.nio.file.Paths;

import org.testng.Assert;

import pages.Card1Page;
import pages.Card2Page;
import pages.Card3Page;
import utils.Card1TestData;
import utils.JsonDataReader;
import utils.TestData;
import pages.HelpForm;
import pages.CookiesForm;
import pages.ValidateTimer;
import pages.HomePage;

public class TaskOneTest extends BaseTest{

    @Test
    public void testCardOpen(){

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is open");
        homePage.clickNextPage();

        Card1Page card1Page = new Card1Page();
        Assert.assertTrue(card1Page.state().waitForDisplayed(), "Card 1 is open");

        Card1TestData testData = JsonDataReader.readJson("src/main/java/resources/testData.json", TestData.class).getCard1();
        card1Page.fillForm(testData.getPassword(), testData.getEmail(), testData.getDomain());
        card1Page.clickDropdown();
        card1Page.clickTerms();
        card1Page.clickNext();

        Card2Page card2Page = new Card2Page();
        Assert.assertTrue(card2Page.state().waitForDisplayed(), "Card 2 is open");
        
        String basePath = System.getProperty("user.dir");
        String relativePath = Paths.get(basePath, "src", "main", "java", "files", "image.jpg").toString();
        card2Page.uploadFile(relativePath);

        card2Page.chooseOptions();
        card2Page.clickNext();

        Card3Page card3Page = new Card3Page();
        Assert.assertTrue(card3Page.state().waitForDisplayed(), "Card 3 is open");
    
    }

    @Test
    public void testHideHelpForm(){
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is open");
        
        homePage.clickNextPage();

        HelpForm helpForm = new HelpForm();
        helpForm.hideHelpForm();
        Assert.assertTrue(helpForm.isHelpFormHidden(), "Form content is hidden");        
    }

    @Test
    public void testAcceptCookies(){
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is open");
        
        homePage.clickNextPage();

        CookiesForm cookiesForm = new CookiesForm();
        cookiesForm.acceptCookies();
        Assert.assertTrue(cookiesForm.isCookiesFormClosed(), "Form content is hidden");        
    }

    @Test
    public void testTimer(){
        HomePage homePage = new HomePage();
        homePage.clickNextPage();

        ValidateTimer validateTimer = new ValidateTimer();

        final String EXPECTED_TIMER_VALUE = "00:00";
        String actualTimerValue = validateTimer.getTimerValue();
        
        boolean isTimerValue = actualTimerValue.startsWith(EXPECTED_TIMER_VALUE);
        Assert.assertTrue(isTimerValue, "Timer should start from 00:00");
    }
}
