package com.example.employee;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name="EmployeeListServlet",value="employeeList")
public class employeeListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee> employees = EmployeeDAO.getAllEmployees();

			request.setAttribute("employees", employees);

			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

