package erp_jsp_exam.service;

import java.util.List;

import erp_jsp_exam.dao.EmployeeDao;
import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Employee;

public class EmployeeService {
    private EmployeeDao empDao = EmployeeDaoImpl.getInstance();

    public List<Employee> showEmployeeList() {
        return empDao.selectEmployeeByAll();
    }

}