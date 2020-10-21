package forms

import DOMAIN
import MAIL
import PASSWORD
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.By.xpath
import testFramework.elements.Button
import testFramework.elements.CheckBox
import testFramework.elements.InputField

class RegisterForm() {
    private var pwdInput = InputField(cssSelector("input[placeholder*='Password']"))
    private var mailInput = InputField(cssSelector("input[placeholder*='email']"))
    private var domainInput = InputField(cssSelector("input[placeholder*='Domain']"))
    private var openerBtn = Button(cssSelector("div[class*='opener']"))
    private var domainZoneBtn = Button(xpath("//div[contains(text(), '.org')]"))
    private var chkBox = CheckBox(cssSelector("label[for*='accept']"))
    private var nextBtn = Button(xpath("//a[contains(text(), 'Next')]"))

    fun fillForm() {
        fillPassword()
        fillMail()
        fillDomain()
        selectDomain()
        chkBox.check()
        nextBtn.click()
    }

    private fun fillPassword(password: String = PASSWORD) = pwdInput.clearAndType(password)

    private fun fillMail(mail: String = MAIL) = mailInput.clearAndType(mail)

    private fun fillDomain(domain: String = DOMAIN) = domainInput.clearAndType(domain)

    private fun selectDomain() {
        openerBtn.click()
        domainZoneBtn.click()
    }
}