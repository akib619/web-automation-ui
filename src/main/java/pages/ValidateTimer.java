package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ValidateTimer extends Form {
    private final ILabel lblTimer = getElementFactory().getLabel(By.xpath("//div[@class='timer timer--white timer--center']"), "Timer");

    public ValidateTimer() {
        super(By.id("app"), "Validate Timer");
    }
 
    public String getTimerValue() {
        return lblTimer.getText();
    }
}
