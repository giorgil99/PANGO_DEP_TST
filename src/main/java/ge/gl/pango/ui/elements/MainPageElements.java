package ge.gl.pango.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$x;

@Data
public class MainPageElements {
    private final SelenideElement mayAccountButton = $x("//a[@title='My Account']"),

    registerButton = $x("//li[contains(@class,'dropdown open')]/ul/li/a[text()='Register']");
}
