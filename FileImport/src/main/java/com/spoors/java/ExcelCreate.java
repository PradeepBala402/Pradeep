package com.spoors.java;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;

public class ExcelCreate {
	private static final String Excel_Sheet = "/home/spoors/Documents/CreateExcel.xls";

	public static void main(String[] args) {
		WritableWorkbook mywork = null;
		System.out.println("ExcelCreate.main()");
		try {
			mywork = Workbook.createWorkbook(new File(Excel_Sheet));
			WritableSheet sheet = mywork.createSheet("Sheet 1", 0);
			Label label = new Label(0, 0, "Test Count");
			sheet.addCell(label);
			Number number = new Number(0, 1, 1);
			sheet.addCell(number);
			Label label1 = new Label(1, 0, "pass");
			sheet.addCell(label1);
			Label label2 = new Label(1, 1, "Result");
			sheet.addCell(label2);
			number = new Number(0, 2, 2);
			sheet.addCell(number);
			Label label3 = new Label(1, 2, "passed2");
			sheet.addCell(label3);
			mywork.write();
		} catch (IOException io) {
			io.printStackTrace();
		} catch (WriteException we) {
			we.printStackTrace();
		}
		finally {
			if(mywork!=null) {
				try {
					mywork.close();
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
