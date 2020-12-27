package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;
import com.util.HibernateUtil;


@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session sess = sessionFactory.openSession();		
		
		try {
			Transaction transaction = sess.beginTransaction();
			User u = new User();
			boolean isAvailable[] = {true};
			
			List<User> userList = sess.createQuery("from User").list();
			userList.forEach(user -> {
				if (user.getName().equalsIgnoreCase(name)) {
					isAvailable[0] = false;
				}
			});
			
			if (isAvailable[0]) {
				u = new User(name, password);
				sess.save(u);
				transaction.commit();
				
				request.getRequestDispatcher("registration.jsp").include(request, response);
				out.println("<h4 style='text-align:center'>Congratualations " + name+ " you have successfully registered<h4>");
			}
			else {
				request.getRequestDispatcher("registration.jsp").include(request, response);
				out.println("<p style='color:red;text-align:center;'>Please select another username this one already exists<p>");
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
