package core.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class MobileBaseTest extends AbstractBaseTest{

    @BeforeEach
    public void setUp() {
        baseUrl = determineBseUrl();
        configure();
    }

    @Override
    protected void configure() {
        Configuration.browser = "chrome";

        // Настройка эмуляции мобильного устройства
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone X") // Указываем устройство
        );

        // Применяем настройки ChromeOptions
        Configuration.browserCapabilities = chromeOptions;

    }

    private static String determineBseUrl() {
        String environment = System.getProperty("env", "mobile");
        String configFileName = "application-" + environment + ".properties";

        Properties properties = new Properties();
        try (InputStream input = BaseTest.class.getClassLoader().getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found: " + configFileName);
            }
            properties.load(input);
        } catch (Exception e) {
            throw new IllegalStateException("Unable to load configuration file: " + configFileName, e);
        }
        return  properties.getProperty("baseUrl");
    }
}
