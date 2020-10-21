package forms.page

import AVATAR
import MAIN_PAGE_LINK
import TIMEOUT
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import forms.HelpForm
import forms.RegisterForm
import forms.Uploader
import org.openqa.selenium.By
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.By.xpath
import org.openqa.selenium.TimeoutException
import testFramework.Browser.getDriver
import testFramework.elements.Button
import waitForElement

class MainPage() {
    private val driver: WebDriver = getDriver()
    private val zeroTimerXpath: By = xpath("//div[contains(text(),'00:00:00')]")
    private val hiddenHelpForm: By = cssSelector("div[class*='is-hidden']")
    private val cookieForm: By = cssSelector("div[class*='cookies']")
    private val firstFormCss: By = cssSelector("div[class*='login-form']")
    private val secondFormCss: By = cssSelector("div[class*='avatar-and-interests__form']")
    private val thirdFormCss: By = cssSelector("div[class*='personal-details']")
    private val welcomePageXpath: By = xpath("//p[contains(text(), 'welcome')]")
    private var interestItem: String = "//div[contains(@class, 'item')][%d]//label"
    private var avatarUploader = Uploader(xpath("//a[contains(text(), 'upload')]"))
    private var unselectAllBtn = Button(cssSelector("label[for*='unselect']"))
    private var hereBtn = Button(cssSelector("a[class*='start']"))
    private var cookieAcceptBtn = Button(xpath("//button[contains(text(), 'no')]"))
    private var avatarNextBtn = Button(xpath("//button[text()='Next']"))
    private var helpForm = HelpForm()
    private var regForm = RegisterForm()

    fun openWelcomePage(): Boolean {
        driver.get(MAIN_PAGE_LINK)
        return presenceOfElement(welcomePageXpath)
    }

    fun openWelcomePageAndClickHere(): Boolean {
        return if (openWelcomePage()) {
            clickHere()
            true
        } else {
            false
        }
    }

    fun clickHere(): Boolean {
        hereBtn.click()
        return presenceOfElement(firstFormCss)
    }

    fun fillRegForm(): Boolean {
        regForm.fillForm()
        return presenceOfElement(secondFormCss)
    }

    fun hideHelpForm(): Boolean {
        helpForm.hideForm()
        return presenceOfElement(hiddenHelpForm)
    }

    fun acceptCookies(): Boolean {
        cookieAcceptBtn.click()
        return presenceOfElement(cookieForm)
    }

    fun chooseInterestsAndLoadAvatar(): Boolean {
        chooseThreeInterests()
        uploadAvatarAndClickNext()
        return presenceOfElement(thirdFormCss)
    }

    private fun chooseThreeInterests() {
        unselectAllBtn.click()
        for (number in 1..3) {
            Button(xpath(interestItem.format(number)))
                .click()
        }
    }

    private fun uploadAvatarAndClickNext(filePath: String = AVATAR) {
        avatarUploader.addAvatar(filePath)
        avatarNextBtn.click()
    }

    fun isTimerStartedFromZero(): Boolean {
        return presenceOfElement(zeroTimerXpath)
    }

    private fun presenceOfElement(by: By): Boolean {
        return try {
            WebDriverWait(driver, TIMEOUT)
                .waitForElement(by)
            true
        } catch (e: TimeoutException) {
            false
        }
    }
}