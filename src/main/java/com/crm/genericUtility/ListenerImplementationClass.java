package com.crm.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

	public void onStart(ITestContext context) {
		
		//Configure the report
				ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
				htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
				htmlreport.config().setTheme(Theme.DARK);
				htmlreport.config().setReportName("VTiger Reports");
				
				report=new ExtentReports();
				report.attachReporter(htmlreport);
				report.setSystemInfo("Base Browser","Chrome");
				report.setSystemInfo("OS", "windows");
				report.setSystemInfo("Base-URL", "http://localhost:8888");
				report.setSystemInfo("Reporter Name ", "anamikap");
		
	}

	public void onTestFailure(ITestResult result) {

		
		String Failedscript=result.getMethod().getMethodName();
		JavaUtility jLib=new JavaUtility();
		String fs="FailedSript" +jLib.getSystemDateAndTimeInFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File path=new File("./Screenshot/"+fs+".png");
		String filepath=path.getAbsolutePath();
		
		try {
			FileUtils.copyFile(src, path);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	test.addScreenCaptureFromPath(filepath);
	test.log(Status.FAIL, result.getThrowable());
	Reporter.log("---TestScript Execution skipped---");
		
				
	}

	public void onTestSkipped(ITestResult result) {
		
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--Skipped--");
		Reporter.log("----TestScript Execution skipped--");
		
		
	}

	public void onTestStart(ITestResult result) {
		
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		
		Reporter.log("--- testscript execution started---");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"--passed--");
		Reporter.log("----TestScript Execution successfully--");
		
		
	}
}