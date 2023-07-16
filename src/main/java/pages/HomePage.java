package pages;

import org.openqa.selenium.By;
import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.ILink;


public class HomePage extends Form{
    private final ILink nextPage = getElementFactory().getLink(By.linkText("HERE"), "Next Page");
    
    public HomePage() {
        super(By.className("start__button"), "Home Page");
    }
    
    
    public void clickNextPage() {
        nextPage.click();
    }

}
