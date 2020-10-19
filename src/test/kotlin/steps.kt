import pages.Userinyerface
import org.testng.Assert

fun openPageAndClickHere(page: Userinyerface){
    Assert.assertTrue(page.openWelcomePage(), "Main page not opened")
    Assert.assertTrue(page.openNextPage(), "Next page not opened")
}