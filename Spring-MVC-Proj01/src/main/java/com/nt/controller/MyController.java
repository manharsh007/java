package com.nt.controller;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MyController implements Controller {


	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long start,end;
		start=System.currentTimeMillis();
		System.out.println("MyController.handleRequest()");
		/*System.out.println(res.getStatus());
		System.out.println(res.getContentType());
		
		System.out.println(req.getContextPath());
		*/
		//Thread.sleep(20000);
		System.out.println(req.getSession());
		System.out.println(req.getPathInfo());
		end=System.currentTimeMillis();
		System.out.println("Time taken "+(end-start)+" ms");
		return new ModelAndView("welcome","sysDate",new Date());
	}

}
