package testFramework.elements

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import testFramework.baseElements.BaseElement

class InputField(xpath: String, driver: WebDriver, private val text:String) : BaseElement(xpath, driver) {
    fun fill() {
        this.getElement()
        this.element.sendKeys(Keys.CONTROL, "a")
        this.element.sendKeys(text)
    }
}