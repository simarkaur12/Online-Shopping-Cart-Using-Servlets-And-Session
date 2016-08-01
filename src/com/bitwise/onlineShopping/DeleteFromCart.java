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
 * Servlet implementation class DeleteFromCart
 */
@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFromCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession ssn = request.getSession();

		String name= (String) ssn.getAttribute("name");
		if(name==null){
			out.println("<font color='red'>You are logged out.Login Again</font>");
			request.getRequestDispatcher("/Login.jsp").include(request, response);
		}
		else{
			deleteFromCart(request, response, out, name);
		}	
	}

	private void deleteFromCart(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String name)
			throws ServletException, IOException {
		String itemToDelete = request.getParameter("deleteItems");
		HashMap<String, ArrayList<Item>> itemsInCart = new ShoppingUserDetails().getShoppingCart();
		if(itemsInCart.containsKey(name)){
			itemsInCart.get(name).remove(itemToDelete);
		}
		out.println("<font color='blue'>Item Deleted</font>");
		request.getRequestDispatcher("/FetchUserSelectedItem").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
