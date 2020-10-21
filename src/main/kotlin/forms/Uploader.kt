package forms

import org.openqa.selenium.By
import testFramework.elements.BaseElement
import java.awt.Robot
import java.awt.Toolkit.getDefaultToolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent.*
import java.io.File

class Uploader(by: By) : BaseElement(by) {
    fun addAvatar(filePath: String) {
        getElement().click()
        val avatarAbsPath = (File(filePath))
            .absolutePath
        val strSelection = StringSelection(avatarAbsPath)
        val clipboard = getDefaultToolkit()
            .systemClipboard
        clipboard.setContents(strSelection, null)
        Robot().apply {
            delay(dellay)
            keyPress(VK_ENTER)
            keyRelease(VK_ENTER)
            keyPress(VK_CONTROL)
            keyPress(VK_V)
            keyRelease(VK_V)
            keyRelease(VK_CONTROL)
            keyPress(VK_ENTER)
            delay(dellay)
            keyRelease(VK_ENTER)
        }
    }

    companion object {
        const val dellay = 400
    }
}
