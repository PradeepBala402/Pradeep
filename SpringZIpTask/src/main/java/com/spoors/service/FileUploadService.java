package com.spoors.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoors.bean.Person;
import com.spoors.dao.PersonDao;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Service
public class FileUploadService {
	@Autowired
	private PersonDao dao;

public String importFile(String name){
Workbook workbook=null;
String fname = "/home/spoors/Documents/ExcelZip/"+name;
try {
	workbook=Workbook.getWorkbook(new File(fname));
	Sheet sheet=workbook.getSheet(0);
	List<Person> list=new ArrayList<Person>();
	for(int j=1;j<sheet.getRows();j++)
	{
		Person person=new Person();
		for(int i=0;i<sheet.getColumns();i++) {
			if(i==0) {
				Cell cell1=sheet.getCell(i, j);
				person.setName(cell1.getContents());
		}
			if(i==1) {
				Cell cell1=sheet.getCell(i, j);
				person.setGender(cell1.getContents());
		}
			if(i==2) {
				Cell cell1=sheet.getCell(i, j);
				person.setAddrs(cell1.getContents());
		}
			if(i==3) {
				Cell cell1=sheet.getCell(i, j);
				person.setImgLoc(cell1.getContents());
		}
		}
		dao.save(person);
		list.add(person);
		}	
}
catch(Exception e) {
	e.printStackTrace();
}
return fname;

}
}
