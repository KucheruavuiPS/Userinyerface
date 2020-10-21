package testFramework

import BROWSER
import TIMEOUT
import testFramework.BrowserNames.FIREFOX
import testFramework.BrowserNames.CHROME
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.lang.IllegalArgumentException
import java.util.concurrent.TimeUnit.SECONDS

object Browser {
    private lateinit var driver: WebDriver

    fun browserSetUp() {
        driver = when (BROWSER) {
            CHROME -> {
                WebDriverManager
                    .chromedriver()
                    .setup()
                ChromeDriver()
            }
            FIREFOX -> {
                WebDriverManager
                    .firefoxdriver()
                    .setup()
                FirefoxDriver()
            }
        }.apply {
            manage().apply {
                timeouts()
                    .implicitlyWait(TIMEOUT, SECONDS)
                window()
                    .maximize()
            }
        }
    }

    fun getDriver(): WebDriver {
        return driver
    }
}

