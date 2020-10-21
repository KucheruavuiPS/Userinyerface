package testFramework.elements

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import testFramework.Browser.getDriver

open class BaseElement(private val by: By) {
    private val driver: WebDriver = getDriver()
    private lateinit var element: WebElement

    fun getElement(): WebElement {
        element = driver.findElement(by)
        return element
    }
}