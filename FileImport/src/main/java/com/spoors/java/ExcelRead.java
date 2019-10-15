package com.spoors.java;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelRead {
	private static final String Excel_Loc="/home/spoors/Documents/CreateExcel.xls";
	public static void main(String[] args) {
		Workbook workbook=null;
		System.out.println("ExcelRead.main()");
		try {
			workbook=Workbook.getWorkbook(new File(Excel_Loc));
			Sheet sheet=workbook.getSheet(0);
			Cell cell1=sheet.getCell(0,0);
			System.out.println(cell1.getContents()+":");
			Cell cell2=sheet.getCell(0, 1);
			System.out.println(cell2.getContents()+":");
			Cell cell3=sheet.getCell(1, 0);
			System.out.println(cell3.getContents()+":");
			Cell cell4=sheet.getCell(1, 1);
			System.out.println(cell4.getContents()+":");
			System.out.println(cell1.getContents()+":");
			Cell cell5=sheet.getCell(0,2);
			System.out.println(cell5.getContents()+":");
			Cell cell6=sheet.getCell(1,2);
			System.out.println(cell6.getContents()+":");
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		catch(BiffException be) {
			be.printStackTrace();
		}
		finally {
			if(workbook!=null) {
				workbook.close();
			}
		}
	}

}
