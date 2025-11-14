package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.CommonMethods;

public class Hooks extends CommonMethods {
    ExtentReports extent = ExtentReportManager.getInstance();
    ExtentTest test;
    @Before
    public void beforeScenario(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }
    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Scenario failed");
        } else {
            test.log(Status.PASS, "Scenario passed");
        }
        extent.flush();
    }
}
