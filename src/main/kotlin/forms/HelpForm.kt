package forms

import org.openqa.selenium.By.cssSelector
import testFramework.elements.Button

class HelpForm() {
    private var hideBtn = Button(cssSelector("button[class*='bottom']"))

    fun hideForm() = hideBtn.click()
}