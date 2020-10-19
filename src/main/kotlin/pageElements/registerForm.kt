package pageElements

import org.openqa.selenium.WebDriver
import testFramework.elements.Button
import testFramework.elements.CheckBox
import testFramework.elements.InputField

class RegisterForm(private val driver: WebDriver) {
    private val pwdInputXpath: String = "//div[@class='login-form']//input[@placeholder='Choose Password']"
    private val mailInputXpath: String = "//div[@class='login-form']//input[@placeholder='Your email']"
    private val domainInputXpath: String = "//div[@class='login-form']//input[@placeholder='Domain']"
    private val chkBoxXpath: String = "//div[@class='login-form']//div//span[@class='checkbox']"
    private val openerXpath: String = "//div[@class='login-form']//div[@class='dropdown__opener']"
    private val domainZoneXpath: String = "//div[@class='login-form']//div[@class='dropdown__list']//*[2]"
    private val nextBtnXpath: String = "//div[@class='login-form']//a[text()='Next']"
    lateinit var pwdInput: InputField
    lateinit var mailInput: InputField
    lateinit var domainInput: InputField
    lateinit var openerBtn: Button
    lateinit var domainZoneBtn: Button
    lateinit var chkBox: CheckBox
    lateinit var nextBtn: Button

    fun fillForm() {
        pwdInput = InputField(pwdInputXpath, driver, Constants.PASSWORD).also { it.fill() }
        mailInput = InputField(mailInputXpath, driver, Constants.MAIL).also { it.fill() }
        domainInput = InputField(domainInputXpath, driver, Constants.DOMAIN).also { it.fill() }
        openerBtn = Button(openerXpath, driver).also { it.click() }
        domainZoneBtn = Button(domainZoneXpath, driver).also { it.click() }
        chkBox = CheckBox(chkBoxXpath, driver).also { it.check() }
        nextBtn = Button(nextBtnXpath, driver).also { it.click() }
    }
}