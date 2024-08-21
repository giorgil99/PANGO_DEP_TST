package ge.gl.pango.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
public class RegistrationPageElements {


    private final SelenideElement firstName = $((By.xpath("//input[@id=\"input-firstname\"]"))),
            lastName = $(By.xpath("//input[@id=\"input-lastname\"]")),
            Email = $(By.xpath("//input[@id=\"input-email\"]")),
            Telephone = $(By.xpath("//input[@id=\"input-telephone\"]")),
            Password = $(By.xpath("//input[@type=\"password\" and @name=\"password\"]")),
            passwordConfirmation = $(By.xpath("//input[@type=\"password\" and @name=\"confirm\"]")),
            newsletter = $(By.xpath("//input[@type=\"radio\" and @name=\"newsletter\" and @value=\"1\"]")),
            privacyPolicy = $(By.xpath("//input[@type=\"checkbox\" and @name=\"agree\" and @value=\"1\"]")),
            Submit = $(By.xpath("//input[@type=\"submit\" and @class=\"btn btn-primary\" and @value=\"Continue\"]")),
            successValidationMessage=$x("//h1[text()='Your Account Has Been Created!']");


}
