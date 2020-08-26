package erp_jsp_exam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.service.EmployeeService;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    EmployeeService service;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        service = new EmployeeService();
    }
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Employee> emplist = service.showEmployeeList();
	    request.setAttribute("emplist", emplist);
	    request.getRequestDispatcher("emplist.jsp").forward(request, response);
    }
}
