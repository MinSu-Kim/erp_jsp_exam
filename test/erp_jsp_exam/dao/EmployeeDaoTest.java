package erp_jsp_exam.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Employee;

public class EmployeeDaoTest {

    @Test
    public void testSelectEmployeeByAll() {
        List<Employee> list = EmployeeDaoImpl.getInstance().selectEmployeeByAll();
        Assert.assertNotNull(list);
        list.stream().forEach(System.out::println);
    }
    
    @Test
    public void testSelectEmployeeByNo() {
        Employee emp = EmployeeDaoImpl.getInstance().selectEmployeeByNo(new Employee(4377));
        Assert.assertNotNull(emp);
        System.out.println(emp);
    }
    
    @Test
    public void testInsertEmployee() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateEmployee() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteEmployee() {
        fail("Not yet implemented");
    }

}
