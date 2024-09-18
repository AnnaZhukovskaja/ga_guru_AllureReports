package ga_guru_allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Search repository {repository} ")
    public void searchForRepository(String repository) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repository);
        $("#query-builder-test").submit();
    }

    @Step("Click on repository {repository}")
    public void clickOnRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Open Issues Tab")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Check Issue {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).shouldHave(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
