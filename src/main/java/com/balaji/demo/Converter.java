package com.balaji.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Converter
 */
@WebServlet("/Converter")
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Converter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		if ( request.getMethod().equals("POST") || request.getMethod().equals("GET")) {
			if ( request.getParameter("number") != null ) {
				String sNumber = request.getParameter("number");
				Number2Words number2Words = new Number2Words();
				HttpSession session = request.getSession(false);
				session.setAttribute("result", number2Words.convert(Double.valueOf(sNumber)));
//				request.setAttribute("result", number2Words.convert(Double.valueOf(sNumber)));
//				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
				response.sendRedirect("result.jsp");
//				out.write();
			} else {
				
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
	}

}
