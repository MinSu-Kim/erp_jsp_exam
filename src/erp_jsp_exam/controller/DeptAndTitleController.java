package erp_jsp_exam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Title;
import erp_jsp_exam.service.DeptAndTitleService;

@WebServlet("/DeptAndTitleController")
public class DeptAndTitleController extends HttpServlet {
    DeptAndTitleService service;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        service = new DeptAndTitleService();
    }
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Department> deptList = service.showDepartmentList();
	    List<Title> titleList = service.showTitleList();
	    
	    System.out.println(deptList);
	    System.out.println(titleList);
	    
	    request.setAttribute("deptList", deptList);
	    request.setAttribute("titleList", titleList);
	    
	    request.getRequestDispatcher("deptAndtitleList.jsp").forward(request, response);
    }
}
