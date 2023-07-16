package pages;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    private final IButton btnAcceptCookies = getElementFactory().getButton(By.xpath("//button[normalize-space()='Not really, no']"), "Accept Cookies");

    public CookiesForm() {
        super(By.id("app"), "Cookies Form");
    }

    public void acceptCookies() {
        btnAcceptCookies.click();
    }

    public boolean isCookiesFormClosed() {
        return btnAcceptCookies.state().waitForNotDisplayed();
    }
}
