package ge.gl.pango.ui.cfg;

import com.codeborne.selenide.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SelenideConfig {

    public void initConfig() {

        Configuration.browser = "Chrome";
        Configuration.timeout = 100000;
        Configuration.pageLoadTimeout = 100000;
        Configuration.proxyEnabled=false;
        Configuration.holdBrowserOpen = false;
        Configuration.reopenBrowserOnFail = true;
        Path root = Paths.get(".").normalize().toAbsolutePath();
        Configuration.reportsFolder = root + "\\src\\main\\resources\\Reports";
        Configuration.savePageSource = false;
    }

}


