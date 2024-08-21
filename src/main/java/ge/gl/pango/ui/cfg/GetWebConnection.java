package ge.gl.pango.ui.cfg;

import static com.codeborne.selenide.Selenide.open;


// Sets web connections

public class GetWebConnection extends SelenideConfig {

    public static String URL = "http://tutorialsninja.com/demo/"; // todo


    public void ConnectToPage() {
        initConfig();
        open(URL);
        System.out.println("Connection to web  is set: "); //todo
    }

}
