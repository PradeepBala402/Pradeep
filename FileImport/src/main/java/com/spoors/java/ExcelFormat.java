package com.spoors.java;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelFormat {
	private static final String Excel_Loc = "/home/spoors/Documents/CreateExcel.xls";

	public static void main(String[] args) {
		System.out.println("ExcelFormat.main()");
		WritableWorkbook workbook=null;
		try {
			workbook=Workbook.createWorkbook(new File( Excel_Loc));
			WritableSheet sheet1=workbook.createSheet("Sheet 1", 0);
			WritableCellFormat cFormat=new WritableCellFormat();
			WritableFont wFont=new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD);
			cFormat.setFont(wFont);
			Label label=new Label(0,0,"Test Count",cFormat);
			sheet1.addCell(label);
			Number number=new Number(0,1,1);
			sheet1.addCell(number);
			Label label1=new Label(1,0,"Result",cFormat);
			sheet1.addCell(label1);
			Label label2=new Label(1,1,"Passed");
			sheet1.addCell(label2);
			Number number1=new Number(0,2,2);
			sheet1.addCell(number1);
			Label label3=new Label(1,2,"Passed 2");
			sheet1.addCell(label3);
			workbook.write();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		catch(WriteException we) {
			we.printStackTrace();
		}
		finally {
			if(workbook!=null) {
				try {
					workbook.close();
				}
				catch(IOException io) {
					io.printStackTrace();
				}
				catch(WriteException we) {
					we.printStackTrace();
				}
			}
		}
	}
}
