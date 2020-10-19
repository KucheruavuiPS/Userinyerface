package pageElements

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import testFramework.elements.Button

class HelpForm(private val driver: WebDriver) {
    private val hideBtnXpath: String = "//div//div//button[span[text()='Send']]"
    private val hiddenHelpFromXpath: String = "//div[@class='help-form is-hidden']"
    lateinit var hideBtn: Button

    fun hideForm() {
        hideBtn = Button(hideBtnXpath, driver)
        hideBtn.click()
        WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(
            By.xpath(hiddenHelpFromXpath)))
    }
}