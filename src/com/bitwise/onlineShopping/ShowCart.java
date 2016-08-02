package com.bitwise.onlineShopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession ssn  = request.getSession();
		String name= (String)ssn.getAttribute("name");

		if(name==null){
			out.println("<font color='red'>You are logged out.Login Again</font>");
			request.getRequestDispatcher("/Login.jsp").include(request, response);
		}
		else{
			ShowCArt(out, name);
		}
	}

	private void ShowCArt(PrintWriter out, String name) {
		HashMap<String, ArrayList<Item>> shoppingCart = new ShoppingUserDetails().getShoppingCart();
		out.println("<font size='4' color='green'>Your Selected Items:</font><br>");
		if(shoppingCart.containsKey(name)){
			for(Item item : shoppingCart.get(name)){
				out.println("<br>"+item.getName()+", Cost="+item.getCost());
			}
		}
		out.println("<br><br><br><font color='green'>If you don't want to purchase some item, Remove some items from cart:-<br><br></font> ");
		out.println("<form action='FetchUserSelectedItem' method='post'>"+ "<input type='submit' value='Delete from Cart'>"+ "</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
