package testFramework.elements

import org.openqa.selenium.By
import org.openqa.selenium.Keys.CONTROL

class InputField(by: By) : BaseElement(by) {
    fun clearAndType(text: String) {
        getElement().apply {
            sendKeys(CONTROL, "a")
            sendKeys(text)
        }
    }
}