package erp_jsp_exam.dao;

import java.util.List;

import erp_jsp_exam.dto.Employee;

public interface EmployeeDao {
    Employee selectEmployeeByNo(Employee emp);
    List<Employee> selectEmployeeByAll();

    int insertEmployee(Employee emp);
    int updateEmployee(Employee emp);
    int deleteEmployee(Employee emp);
    
    int loginCheck(Employee emp);
}
