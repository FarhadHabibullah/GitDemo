package Planit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	public static ExtentReports getReportObject(){
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html";	
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Interview Automation Test");
		reporter.config().setDocumentTitle("Test results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Farhad");
		
		return extent;
		
	}

}
