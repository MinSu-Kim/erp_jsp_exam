package erp_jsp_exam.dao;

import org.junit.Assert;
import org.junit.Test;

import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Employee;

public class LoginTest {
    
    @Test
    public void testLoginCheckTrue() {
        System.out.println("testLoginCheckTrue()");
        Employee emp = new Employee(4377);
        emp.setPwd("1234");
        int res = EmployeeDaoImpl.getInstance().loginCheck(emp);
        Assert.assertEquals(1, res);
    }
    
    @Test
    public void testLoginCheckFalse() {
        System.out.println("testLoginCheckTrue()");
        Employee emp = new Employee(4377);
        emp.setPwd("1235");
        int res = EmployeeDaoImpl.getInstance().loginCheck(emp);
        Assert.assertEquals(0, res);
    }
    
}
