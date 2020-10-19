package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pageElements.HelpForm
import pageElements.RegisterForm
import pageElements.Uploader
import testFramework.elements.Button

class Userinyerface(private val driver: WebDriver) {
    private val hereBtnXpath: String = "//body//p//a[text()='HERE']"
    private val interestItemXpath: String = "//div[contains(@class, 'list')]//div[contains(@class, 'item')][%d]//label"
    private val unselectAllXpath: String = "//div[contains(@class, 'list')]//div[contains(@class, 'item')][21]//label"
    private val uploaderXpath: String = "//div//p//a[contains(text(), 'upload')]"
    private val cookieAcceptXpath: String = "//div//button[contains(text(), 'no')]"
    private val zeroTimerXpath: String = "//div//div[contains(text(),'00:00:00')]"
    private val avatarNextXpath: String = "//div//button[text()='Next']"
    lateinit var avatarUploader: Uploader
    lateinit var helpForm: HelpForm
    lateinit var regForm: RegisterForm
    lateinit var unselectAllBtn: Button
    lateinit var interestBtn: Button
    lateinit var hereBtn: Button
    lateinit var cookieAcceptBtn: Button
    lateinit var avatarNextBtn: Button
    fun openWelcomePage(): Boolean {
        driver.get("https://userinyerface.com/game.html%20target=")
        return true
    }

    fun openNextPage(): Boolean {
        hereBtn = Button(hereBtnXpath, driver)
        hereBtn.getElement()
        hereBtn.click()
        return true
    }

    fun fillRegForm(): Boolean {
        regForm = RegisterForm(driver).also { it.fillForm() }
        return true
    }

    fun chooseThreeInterests(): Boolean {
        unselectAllBtn = Button(unselectAllXpath, driver).also { it.click() }
        for (number in 1..3) {
            val newInterestXpath: String = interestItemXpath.format(number)
            interestBtn = Button(newInterestXpath, driver).also { it.click() }
        }
        return true
    }

    fun uploadAvatarAndClickNext(filePath:String =Constants.AVATAR): Boolean {
        avatarUploader = Uploader(uploaderXpath, driver)
        avatarUploader.addAvatar(filePath)
        avatarNextBtn = Button(avatarNextXpath, driver).also { it.click() }
        return true
    }

    fun hideHelpForm(): Boolean {
        helpForm = HelpForm(driver).also { it.hideForm() }
        return true
    }

    fun acceptCookies(): Boolean {
        cookieAcceptBtn = Button(cookieAcceptXpath, driver).also { it.click() }
        return true
    }

    fun isTimerStartFromZero(): Boolean {
        WebDriverWait(driver, 10).until(
            ExpectedConditions.presenceOfElementLocated(
            By.xpath(zeroTimerXpath)))
        return true
    }
}