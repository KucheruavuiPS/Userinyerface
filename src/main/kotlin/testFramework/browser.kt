package testFramework
import Config
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.WebDriverWait

class Browser {
    private lateinit var driver:WebDriver
    init {
        when (Config.browser){
            Constants.CHROME -> {
                driver = ChromeDriver()
            }
            Constants.FIREFOX -> {
                driver = FirefoxDriver()
            }
        }
    }
    fun getDriver():WebDriver{
        return driver
    }
}
