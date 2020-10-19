package testFramework.elements

import org.openqa.selenium.WebDriver
import testFramework.baseElements.BaseElement

class Button(xpath: String, driver: WebDriver) : BaseElement(xpath, driver) {
    fun click() {
        this.getElement()
        this.element.click()
    }
}