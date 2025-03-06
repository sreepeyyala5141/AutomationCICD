package rahulsheetyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportobject() {
		
		 String path = System.getProperty("user.dir")+"\\report\\index.html";
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("web Automation results");
			reporter.config().setDocumentTitle("Test Results");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Rahulshetty");
			return extent;
		
	}

}
