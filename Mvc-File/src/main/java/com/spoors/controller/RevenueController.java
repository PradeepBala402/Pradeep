package com.spoors.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class RevenueController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String output = ServletRequestUtils.getStringParameter(request, "output");
		Map<String, String> revenueData = new HashMap<String, String>();
		revenueData.put("jan-2019","20000");
		revenueData.put("Feb-2019","30000");
		revenueData.put("Mar-2019","40000");
		revenueData.put("Apr-2019","50000");
		revenueData.put("May-2019","60000");
		if(output==null || "".equals(output)) {
			return new ModelAndView("RevenueSummary","revenueData",revenueData);
		}
			else if("Excel".equals(output.toUpperCase())) {
				return new ModelAndView("ExcelRevenueSummary","revenueData",revenueData);
			}
			else {
		return new ModelAndView("RevenueSummary","revenueData",revenueData);
			}
	}

}
