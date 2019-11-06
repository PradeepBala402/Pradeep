package com.spoors.service;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.result.Row;
import com.spoors.bean.Person;
import com.spoors.dao.PersonDao;

  
import jxl.Sheet;
import jxl.Workbook;

@Service
public class PersonFileUploadService {
	@Autowired
	private PersonDao personDao;

	public String uploadFile(String filePath) {
		Workbook workbook = null;
		Sheet sheet = null;
		Person person = new Person();
		try {
			workbook = Workbook.getWorkbook(new File(filePath));
			sheet = workbook.getSheet(0);
			String Header_details = "name,gender,addrs,imgLoc";
			String headerNames[] = Header_details.split(",");
			// Read Each Row
			List<Person> personList = new ArrayList<>();
			Iterator<Person> rowIterator = ((List<Person>) sheet).iterator();
			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();
				// Person person=new Person();
				int count = 0;
				while (count < headerNames.length) {
					String methodName = "set" + headerNames[count];
					String inputCellValue = getCellValueBasedOnType(row, count++);
					setValueIntoObject(person, Person.class, methodName, "String", inputCellValue);
				}
				personList.add(person);
			}
			personDao.saveFileDataInDB(personList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";

	}

	public static HSSFWorkbook getWorkBook(File fileName) {
		HSSFWorkbook workbook = null;
		try {
			String myFileName = fileName.getName();
			String extension = myFileName.substring(myFileName.lastIndexOf("."));
			if (extension.equalsIgnoreCase(".xls")) {
				workbook = new HSSFWorkbook(new FileInputStream(fileName));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return workbook;
	}

	private void setValueIntoObject(Person person, Class<Person> class1, String methodName, String string,
			String inputCellValue) 
		throws SecurityException, NoSuchMethodException, ClassNotFoundException, NumberFormatException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
			
		
			
			Method meth = class1.getMethod(methodName, Class.forName(string));
			Person t = class1.cast(person);
			 
			 if("java.lang.Double".equalsIgnoreCase(string))
			{
				meth.invoke(t, Double.parseDouble(inputCellValue));
			}else if(!"java.lang.Integer".equalsIgnoreCase(string))
			{
				meth.invoke(t, inputCellValue);
			}
			else
			{
				meth.invoke(t, Integer.parseInt(inputCellValue));
			}		 		
		}

	

	public String getCellValueBasedOnType(Row rowData, int columnPosition) {
		/*
		 * String cellValue=null; Cell cell = ((Sheet) rowData).getCell(columnPosition);
		 * if(cell!=null){ if(cell.getCellType()==Cell) { String
		 * inputCellValue=cell.getStringCellValue(); if(inputCellValue.endsWith(".0")){
		 * inputCellValue=inputCellValue.substring(0, inputCellValue.length()-2); }
		 * cellValue=inputCellValue; } else if
		 * (cell.getCellType()==Cell.CELL_TYPE_NUMERIC) { Double doubleVal = new
		 * Double(((Cell) cell).getNumericCellValue()); cellValue=
		 * Integer.toString(doubleVal.intValue()); } }
		 */
		return null;
	}
}
