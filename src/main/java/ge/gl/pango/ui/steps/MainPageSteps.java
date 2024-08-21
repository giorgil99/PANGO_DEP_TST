package ge.gl.pango.ui.steps;

import com.codeborne.selenide.Condition;
import ge.gl.pango.ui.elements.MainPageElements;

public class MainPageSteps extends MainPageElements {

    public MainPageSteps clickOnMyAccountButton(){
        getMayAccountButton().should(Condition.visible).click();
        return this;
    }

   public MainPageSteps clickOnRegisterButton(){
        getRegisterButton().should(Condition.visible).click();
        return this;
    }

}
