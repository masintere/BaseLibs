package com.baselib.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****************************************************************************
 * <b>Title</b>: BaseServlet.java <p/>
 * <b>Project</b>: WebCrescendo <p/>
 * <b>Description: </b> Put Something Here
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jul 22, 2015<p/>
 * @updates:
 ****************************************************************************/
public abstract class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public BaseServlet(){
		super();
	}
	
	public abstract void getAndPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getAndPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getAndPost(request, response);
	}

}
