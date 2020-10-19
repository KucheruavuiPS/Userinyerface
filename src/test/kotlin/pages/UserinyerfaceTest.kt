package pages

import openPageAndClickHere
import org.openqa.selenium.WebDriver
import org.testng.Assert
import org.testng.annotations.Test
import testFramework.Browser
import java.util.concurrent.TimeUnit

class UserinyerfaceTest {
    private lateinit var driver: WebDriver
    private lateinit var mainPage: Userinyerface

    @org.testng.annotations.BeforeMethod
    fun setUp() {
        driver = Browser().getDriver().also { it.manage().timeouts().implicitlyWait(Config.TIMEOUT, TimeUnit.SECONDS) }
    }

    @Test
    fun testCaseOne() {
        mainPage = Userinyerface(driver)
        openPageAndClickHere(mainPage)
        Assert.assertTrue(mainPage.fillRegForm(), "Registration form not filled")
        Assert.assertTrue(mainPage.chooseThreeInterests(), "Can't choose three interests")
        Assert.assertTrue(mainPage.uploadAvatarAndClickNext(), "Can't add new avatar")
    }

    @Test
    fun testCaseTwo() {
        mainPage = Userinyerface(driver)
        openPageAndClickHere(mainPage)
        Assert.assertTrue(mainPage.hideHelpForm(), "Can't hide help form")
    }

    @Test
    fun testCaseThree() {
        mainPage = Userinyerface(driver)
        openPageAndClickHere(mainPage)
        Assert.assertTrue(mainPage.acceptCookies(), "Can't accept cookies")
    }

    @Test
    fun testCaseFour() {
        mainPage = Userinyerface(driver)
        openPageAndClickHere(mainPage)
        Assert.assertTrue(mainPage.isTimerStartFromZero(), "Timer started not from zero")
    }

    @org.testng.annotations.AfterMethod
    fun tearDown() {
        driver.quit()
    }
}