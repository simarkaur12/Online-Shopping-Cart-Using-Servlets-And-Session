package com.bitwise.onlineShopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class filterShoppingLogin
 */
@WebFilter("/filterShoppingLogin")
public class filterShoppingLogin implements Filter {

    /**
     * Default constructor. 
     */
    public filterShoppingLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HashMap<String, String> map = new ShoppingUserDetails().getUserLogin();
		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession ssn = req.getSession();
		
		String uid = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(uid+","+password);
		if(uid=="" && password==""){
			out.print("<font color='red'>Please Fill the values first</font>");
			request.getRequestDispatcher("/Login.jsp").include(request, response);
		}
		else {
			checkInDatabase(request, response, chain, map, out, ssn, uid, password);
		}
	}

	private void checkInDatabase(ServletRequest request, ServletResponse response, FilterChain chain, HashMap<String, String> map, PrintWriter out, HttpSession ssn, String uid, String password) throws IOException, ServletException {
		if(map.containsKey(uid) && map.containsValue(password)) {
			ssn.setAttribute("name", uid);
			out.println("<font color='green'><h3>Welcome "+uid+"</h3></font>");
			chain.doFilter(request, response);
		}
		else {
			out.print("<font color='red'>Invalid UserId And password</font>");
			request.getRequestDispatcher("/Login.jsp").include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
