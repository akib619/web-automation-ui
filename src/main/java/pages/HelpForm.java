package pages;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private final IButton btnHideForm = getElementFactory().getButton(By.xpath("//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"), "Hide Help Form");

    public HelpForm() {
        super(By.id("app"), "Help Form");
    }

    public void hideHelpForm() {
        btnHideForm.click();
    }

    public boolean isHelpFormHidden() {
        return btnHideForm.state().isDisplayed();
    }
}
