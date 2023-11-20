<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="style/AddEmployee.css" />
    <script>
      function validateEmployeeForm() {
        var employeeName = document.getElementById("employeeName").value;
        var employeeDesignation = document.getElementById(
          "employeeDesignation"
        ).value;
        var employeeSalary = document.getElementById("employeeSalary").value;

        if (
          employeeName === "" ||
          employeeDesignation === "" ||
          employeeSalary === ""
        ) {
          alert("Fill all the fields on the form");
          return false;
        }

        return true;
      }
    </script>
  </head>
  <body>
    <h2>Add Employee</h2>
    <form
      class="container"
      action="createEmployee"
      method="post"
      onsubmit="return validateEmployeeForm()">
      <label for="employeeName">Name:</label>
      <input type="text" id="employeeName" name="employeeName" required /><br />
      <label for="employeeDesignation">Designation:</label>
      <input
        type="text"
        id="employeeDesignation"
        name="employeeDesignation"
        required /><br />
      <label for="employeeSalary">Salary:</label>
      <input
        type="number"
        id="employeeSalary"
        name="employeeSalary"
        required /><br />

      <input type="submit" value="Add Employee" />
    </form>
    <br />
    <a class="view-link" href="employeeList">View Employee List</a>
  </body>
</html>
