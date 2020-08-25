package erp_jsp_exam.service;

import erp_jsp_exam.dao.DepartmentDao;
import erp_jsp_exam.dao.EmployeeDao;
import erp_jsp_exam.dao.TitleDao;
import erp_jsp_exam.dao.impl.DepartmentDaoImpl;
import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dao.impl.TitleDaoImpl;

public class EmployeeService {
    private EmployeeDao empDao = EmployeeDaoImpl.getInstance();
    private DepartmentDao deptDao = DepartmentDaoImpl.getInstance();
    private TitleDao titleDao = TitleDaoImpl.getInstance();
    
    
}
