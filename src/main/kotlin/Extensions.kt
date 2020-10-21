import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

fun WebDriverWait.waitForElement(by: By) {
    this.until(
        ExpectedConditions
            .presenceOfElementLocated(by)
    )
}
