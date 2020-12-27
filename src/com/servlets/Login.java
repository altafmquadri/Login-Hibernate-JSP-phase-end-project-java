package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;
import com.util.HibernateUtil;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sess = sessionFactory.openSession();
		
		
		try {
			Transaction transaction = sess.beginTransaction();
			boolean isCorrect[] = {false};
			
			List<User> userList = sess.createQuery("from User").list();
			userList.forEach(user -> {
				if (user.getName().equalsIgnoreCase(name) && user.getPassword().equals(password)) {
					isCorrect[0] = true;
				}
			});
			
			if (isCorrect[0]) {
				session.setAttribute("name", name);
				response.sendRedirect("dashboard.jsp");
			}
			else {
				session.invalidate();
				request.getRequestDispatcher("login.jsp").include(request, response);
				out.println("<p style='color:red;text-align:center;'>Login credentials are not valid, please try again!<p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
