package pages;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;

import org.openqa.selenium.By;

public class Card1Page extends Form {
    private final ITextBox txtPassword = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password");
    private final ITextBox txtEmail = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "Email");
    private final ITextBox txtDomain = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "Domain");
    private final IButton domainDropdown = getElementFactory().getButton(By.className("dropdown__field"), "Domain Dropdown");
    private final IButton domainOption = getElementFactory().getButton(By.xpath("//div[@class='dropdown__list']//div[contains(text(),'.com')]"), "Domain Option");
    private final ICheckBox checkTerms = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'icon icon-check checkbox__check')]"), "Terms");
    private final IButton btnNext = getElementFactory().getButton(By.xpath("//a[contains(@class,'button--secondary')]"), "Next");

    
    public Card1Page() {
        super(By.id("app"), "Card 1");
    }
    
    public void fillForm(String password, String email, String domain) {
        txtPassword.clearAndType(password);
        txtEmail.clearAndType(email);
        txtDomain.clearAndType(domain);
    }

    public void clickDropdown(){
        domainDropdown.click();
        domainOption.click();
    }

    public void clickTerms(){
        checkTerms.click(); 
    }

    public void clickNext(){
        btnNext.click();
    }

}

