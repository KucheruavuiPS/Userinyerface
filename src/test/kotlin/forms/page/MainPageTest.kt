package forms.page

import org.openqa.selenium.WebDriver
import org.testng.Assert.assertFalse
import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import testFramework.Browser.getDriver
import testFramework.Browser.browserSetUp

class MainPageTest {
    private lateinit var driver: WebDriver

    @org.testng.annotations.BeforeMethod
    fun setUp() {
        browserSetUp()
        driver = getDriver()
    }

    @Test
    fun testCaseOne() {
        MainPage().apply {
            assertTrue(openWelcomePage(), "Welcome page wasn't opened")
            assertTrue(clickHere(), "First form wasn't opened")
            assertTrue(fillRegForm(), "Second form wasn't opened")
            assertTrue(chooseInterestsAndLoadAvatar(), "Third form wasn't opened")
        }
    }

    @Test
    fun testCaseTwo() {
        MainPage().apply {
            assertTrue(openWelcomePageAndClickHere(), "Welcome page wasn't opened")
            assertTrue(hideHelpForm(), "Help form wasn't hidden")
        }
    }

    @Test
    fun testCaseThree() {
        MainPage().apply {
            assertTrue(openWelcomePageAndClickHere(), "Welcome page wasn't opened")
            assertFalse(acceptCookies(), "Cookies form wasn't hidden")
        }
    }

    @Test
    fun testCaseFour() {
        MainPage().apply {
            assertTrue(openWelcomePageAndClickHere(), "Welcome page wasn't opened")
            assertTrue(isTimerStartedFromZero(), "Timer don't started from zero")
        }
    }

    @org.testng.annotations.AfterMethod
    fun tearDown() {
        driver.quit()
    }


}