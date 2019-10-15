package com.spoors.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ExcelRevunueReport extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 
		 Map<String,String> revenueData=(Map<String, String>) model.get("revenueData");
		 HSSFSheet sheet=(HSSFSheet) workbook.createSheet("revenueData");
		 HSSFRow row=sheet.createRow(0);
		 row.createCell(0).setCellValue("month");
		 row.createCell(1).setCellValue("Revenue");
		 int rowNum=1;
		 for(Map.Entry<String,String> entry:revenueData.entrySet()) {
			 HSSFRow row1=sheet.createRow(rowNum++);
			 row1.createCell(0).setCellValue(entry.getKey());
			 row1.createCell(1).setCellValue(entry.getValue());
		 }
		
	}

}
