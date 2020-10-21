package testFramework.elements

import org.openqa.selenium.By

class CheckBox(by: By) : BaseElement(by) {

    fun check() = getElement().click()
}