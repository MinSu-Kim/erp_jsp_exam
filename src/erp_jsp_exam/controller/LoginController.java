package erp_jsp_exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.service.EmployeeService;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeService service;

    @Override
    public void init() throws ServletException {
        service = new EmployeeService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int empNo = Integer.parseInt(request.getParameter("empNo").trim());
        String pwd = request.getParameter("pwd").trim();

        Employee emp = new Employee(empNo);
        emp.setPwd(pwd);

        int res = service.loginCheck(emp);
        System.out.println("login result : " + res);
    }

}
