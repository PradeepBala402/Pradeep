package com.spoors.java;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONEx {

	public static void main(String[] args) {
		JSONObject obj=new JSONObject();
		obj.put("name", "subani");
		obj.put("addrs", "hyd");
		JSONArray list=new JSONArray();
		try(FileWriter file=new FileWriter("my.json")) {
			file.write(obj.toString());
			file.flush();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		System.out.println(obj);
	
	}

}
