package erp_jsp_exam.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {

    @Test
    public void testSelectEmployeeByAll() {
        System.out.println("testSelectEmployeeByAll()");
        List<Employee> list = EmployeeDaoImpl.getInstance().selectEmployeeByAll();
        Assert.assertNotNull(list);
        list.stream().forEach(System.out::println);
    }
    
    @Test
    public void testSelectEmployeeByNo() {
        System.out.println("testSelectEmployeeByNo()");
        Employee emp = EmployeeDaoImpl.getInstance().selectEmployeeByNo(new Employee(4377));
        Assert.assertNotNull(emp);
        System.out.println(emp);
    }
    
    @Test
    public void test1InsertEmployee() {
        System.out.println("testInsertEmployee()");
        Employee newEmp = new Employee(1004, "박규영", new Title(5), 
                new Employee(3426), 1500000, new Department(1), new Date());
        int res = EmployeeDaoImpl.getInstance().insertEmployee(newEmp);
        Assert.assertEquals(1, res);
    }

    @Test
    public void test2UpdateEmployee() {
        System.out.println("testUpdateEmployee()");
        Calendar hireDate = GregorianCalendar.getInstance();
        hireDate.clear();
        hireDate.set(2010, 8, 01);
        
        Employee updateEmp = EmployeeDaoImpl.getInstance().selectEmployeeByNo(new Employee(1004));
        System.out.println("before : " + updateEmp);
        
        updateEmp.setName("박규영2");
        updateEmp.setTitle(new Title(4));
        updateEmp.setManager(new Employee(4377));
        updateEmp.setSalary(3500000);
        updateEmp.setDept(new Department(2));
        updateEmp.setHireDate(hireDate.getTime());
        
        int res = EmployeeDaoImpl.getInstance().updateEmployee(updateEmp);
        Employee findEmp = EmployeeDaoImpl.getInstance().selectEmployeeByNo(new Employee(1004));
        System.out.println("after : " + findEmp);
        Assert.assertEquals(1, res);
    }

    @Test
    public void test3DeleteEmployee() {
        System.out.println("testDeleteEmployee()");
        int res = EmployeeDaoImpl.getInstance().deleteEmployee(new Employee(1004));
        Assert.assertEquals(1, res);
    }

}
