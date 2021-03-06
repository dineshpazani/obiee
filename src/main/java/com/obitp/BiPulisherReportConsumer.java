package com.bip.report.consumer;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.oracle.xmlns.oxp.service.v2.AccessDeniedException_Exception;
import com.oracle.xmlns.oxp.service.v2.InvalidParametersException_Exception;
import com.oracle.xmlns.oxp.service.v2.OperationFailedException_Exception;
import com.oracle.xmlns.oxp.service.v2.ReportRequest;
import com.oracle.xmlns.oxp.service.v2.ReportResponse;
import com.oracle.xmlns.oxp.service.v2.ReportService;

public class BiPulisherReportConsumer {
	
	private static String SERVICE_URL = "https://xxxxxx/xmlpserver/services/v2/ReportService";

	private static String REPORT_PATH = "/xxxx/BIPReport.xdo";

	private static String REPORT_FORMAT = "xxx";

	private static String USERNAME = "xxxx";

	private static String PASSWORD = "xxxx";
	

	

	public static void main(String[] args) {
		System.out.println("BI Publisher Report Generator");

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		try {

			factory.setServiceClass(ReportService.class);
			factory.setAddress(SERVICE_URL);
			ReportService runReportResponse = (ReportService) factory.create();

			ReportRequest reportRequest = new ReportRequest();
			reportRequest.setReportAbsolutePath(REPORT_PATH);
			reportRequest.setAttributeFormat(REPORT_FORMAT);
			reportRequest.setSizeOfDataChunkDownload(-1);
			// Anirban_roy04@infosys.com/AJan@2018
			ReportResponse res = runReportResponse.runReport(reportRequest, USERNAME, PASSWORD);

			byte[] data = res.getReportBytes();

			FileOutputStream fo = new FileOutputStream("output." + reportRequest.getAttributeFormat());
			fo.write(data);
			fo.close();

			System.out.println("Done ==========> " + "output." + reportRequest.getAttributeFormat());

		} catch (OperationFailedException_Exception | AccessDeniedException_Exception
				| InvalidParametersException_Exception | IOException e) {
			e.printStackTrace();
		}
	}
}
