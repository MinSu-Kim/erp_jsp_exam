package erp_jsp_exam.dao;

import java.util.List;

import erp_jsp_exam.dto.Department;

public interface DepartmentDao {
    
    List<Department> selectDepartmentByAll();

}
