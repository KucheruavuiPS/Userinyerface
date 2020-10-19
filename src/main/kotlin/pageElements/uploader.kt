package pageElements

import org.openqa.selenium.WebDriver
import testFramework.baseElements.BaseElement
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.io.File

class Uploader(
    xpath: String,
    driver: WebDriver
) : BaseElement(xpath, driver) {
    fun addAvatar(filePath: String) {
        this.getElement()
        element.click()
        val avatarAbsPath = (File(filePath)).absolutePath
        val strSelection = StringSelection(avatarAbsPath)
        val clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard
        clipboard.setContents(strSelection, null)
        val robot = Robot()
        robot.delay(300)
        robot.keyPress(KeyEvent.VK_ENTER)
        robot.keyRelease(KeyEvent.VK_ENTER)
        robot.keyPress(KeyEvent.VK_CONTROL)
        robot.keyPress(KeyEvent.VK_V)
        robot.keyRelease(KeyEvent.VK_V)
        robot.keyRelease(KeyEvent.VK_CONTROL)
        robot.keyPress(KeyEvent.VK_ENTER)
        robot.delay(500)
        robot.keyRelease(KeyEvent.VK_ENTER)
    }
}
