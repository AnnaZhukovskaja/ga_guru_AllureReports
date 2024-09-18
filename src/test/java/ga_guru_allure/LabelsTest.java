package ga_guru_allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue in repository")
    @Story("Create Issue")
    @Owner("Zhukovskaya Anna")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "githab", url = "https://github.com/")
    @DisplayName("Create Issue for authorized user")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(t -> t.setName("Create Issue for authorized user"));
        Allure.feature("Issue in repository");
        Allure.story("Create Issue");
        Allure.label("owner", "Zhukovskaya Anna");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("githab", "https://github.com/");

    }
}
