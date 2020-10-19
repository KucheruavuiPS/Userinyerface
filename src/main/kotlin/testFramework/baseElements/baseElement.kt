package testFramework.baseElements

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

open class BaseElement(private val xpath: String, private val driver: WebDriver) {
    lateinit var element: WebElement
    fun getElement() {
        element = driver.findElement(By.xpath(xpath))
    }

}