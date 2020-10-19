package testFramework.elements

import org.openqa.selenium.WebDriver
import testFramework.baseElements.BaseElement

class CheckBox(xpath: String, driver: WebDriver) : BaseElement(xpath, driver) {
    fun check(){
        this.getElement()
        this.element.click()
    }
}