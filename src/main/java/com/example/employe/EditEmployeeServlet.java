package com.example.employe;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="EditEmployeeServlet",value="/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("here we call him");

		Employee employee = EmployeeDAO.getEmployeeById(id);

		if (employee != null) {
			request.setAttribute("employee", employee);

			RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().println("Employee not found");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		double salary = Double.parseDouble(request.getParameter("salary"));

		EmployeeDAO.updateEmployee(new Employee(id, name, designation, salary));

		response.sendRedirect("employeeList");
	}

}

