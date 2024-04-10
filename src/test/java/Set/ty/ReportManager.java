package Set.ty;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initializeReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/login-report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logStep(String stepDetails) {
        test.info(stepDetails);
    }

    public static void logPass(String passDetails) {
        test.pass(passDetails);
    }

    public static void logFail(String failDetails) {
        test.fail(failDetails);
    }

    public static void flushReport() {
        extent.flush();
    }
}

