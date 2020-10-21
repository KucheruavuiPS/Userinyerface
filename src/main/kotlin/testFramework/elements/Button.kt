package testFramework.elements

import org.openqa.selenium.By

class Button(by: By) : BaseElement(by) {

    fun click() = getElement().click()
}
