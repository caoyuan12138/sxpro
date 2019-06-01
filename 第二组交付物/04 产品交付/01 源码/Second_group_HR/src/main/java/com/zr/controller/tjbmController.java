package com.zr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zr.service.tjbmService;

public class tjbmController extends HttpServlet {

	tjbmService tjbm = new tjbmService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		req.setCharacterEncoding("utf8");
		
		
		String uname = req.getParameter("uname");
		String usname = req.getParameter("usname");
		//有个保存用户的服务
		boolean  flag = tjbm.tjbmByBmName(uname,usname);
		Boolean  f =  new Boolean(flag);
		PrintWriter  wr =  resp.getWriter();
		wr.write(f.toString());
		wr.flush();
		wr.close();
	}
}
