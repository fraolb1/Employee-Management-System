package com.example.employe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static com.example.employe.EmployeeDAO.createEmployee;

@WebServlet(name = "CreateEmployeeServlet", value = "/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String employeeName = request.getParameter("employeeName");
        String employeeDesignation = request.getParameter("employeeDesignation");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));

        Employee newEmployee = new Employee();
        newEmployee.setName(employeeName);
        newEmployee.setDesignation(employeeDesignation);
        newEmployee.setSalary(employeeSalary);

        createEmployee(newEmployee);

        System.out.println("This is the create method.");

        try {
            response.sendRedirect("employeeList");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
