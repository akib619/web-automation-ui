package pages;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import utils.FileUploadUtil;
import utils.RandomUtil;
import org.openqa.selenium.By;

import java.util.List;

public class Card2Page extends Form {
    private final ICheckBox unselectAll = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']//span[contains(@class,'icon icon-check checkbox__check')]"), "Unselect");
    private final List<ICheckBox> chkInterests = getElementFactory().findElements(By.xpath("//span[contains(@class,'checkbox__box')]"), ICheckBox.class);
    private final IButton btnNext = getElementFactory().getButton(By.xpath("//button[normalize-space()='Next']"), "Next");

    public Card2Page() {
        super(By.id("app"), "Card 2");
    }

    public void uploadFile(String filePath) {
        FileUploadUtil.setClipboardContent(filePath);

        getElementFactory().getButton(By.className("avatar-and-interests__upload-button"), "Upload").click();

        FileUploadUtil.performFileUpload();
    }


    public void chooseOptions() {
        unselectAll.click();

        int amountOfCheckboxes = chkInterests.size();
        if(chkInterests.size() <= amountOfCheckboxes){
            int numberOfCheckboxesToSelect = 3;
            for (int i = 0; i < numberOfCheckboxesToSelect; i++) {
                int randomCheckboxIndex = RandomUtil.getRandomNumber(0, amountOfCheckboxes - 1);
                chkInterests.get(randomCheckboxIndex).click();
            }
        }
       
    }

    public void clickNext() {
        btnNext.click();
    }
}

