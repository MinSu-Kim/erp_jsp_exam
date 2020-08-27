package erp_jsp_exam.service;

import java.util.List;

import erp_jsp_exam.dao.DepartmentDao;
import erp_jsp_exam.dao.EmployeeDao;
import erp_jsp_exam.dao.TitleDao;
import erp_jsp_exam.dao.impl.DepartmentDaoImpl;
import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dao.impl.TitleDaoImpl;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;

public class EmployeeService {
    private EmployeeDao empDao = EmployeeDaoImpl.getInstance();
    private DepartmentDao deptDao = DepartmentDaoImpl.getInstance();
    private TitleDao titleDao = TitleDaoImpl.getInstance();

    public List<Employee> showEmployeeList() {
        return empDao.selectEmployeeByAll();
    }

    public List<Department> showDepartmentList() {
        return deptDao.selectDepartmentByAll();
    }

    public List<Title> showTitleList() {
        return titleDao.selectTitleByAll();
    }
}