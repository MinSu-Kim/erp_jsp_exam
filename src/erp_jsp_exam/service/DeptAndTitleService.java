package erp_jsp_exam.service;

import java.util.List;

import erp_jsp_exam.dao.DepartmentDao;
import erp_jsp_exam.dao.TitleDao;
import erp_jsp_exam.dao.impl.DepartmentDaoImpl;
import erp_jsp_exam.dao.impl.TitleDaoImpl;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Title;

public class DeptAndTitleService {
    private DepartmentDao deptDao = DepartmentDaoImpl.getInstance();
    private TitleDao titleDao = TitleDaoImpl.getInstance();

    public List<Title> showTitleList() {
        return titleDao.selectTitleByAll();
    }
    
    public List<Department> showDepartmentList() {
        return deptDao.selectDepartmentByAll();
    }
}
