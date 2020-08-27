package erp_jsp_exam.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp_jsp_exam.dao.impl.DepartmentDaoImpl;
import erp_jsp_exam.dto.Department;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {

    @Test
    public void testSelectDepartmentByAll() {
        System.out.println("testSelectDepartmentByAll()");
        List<Department> list = DepartmentDaoImpl.getInstance().selectDepartmentByAll();
        Assert.assertNotNull(list);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void testSelectDepartmentByNo() {
        System.out.println("testSelectDepartmentByNo()");
        Department dept = DepartmentDaoImpl.getInstance().selectDepartmentByNo(new Department(1));
        Assert.assertNotNull(dept);
        System.out.println(dept);
    }

    @Test
    public void test1InsertDepartment() {
        System.out.println("testInsertDepartment()");
        int res = DepartmentDaoImpl.getInstance().insertDepartment(new Department(5, "마케팅", 10));
        Assert.assertEquals(1, res);
    }

    @Test
    public void test2UpdateDepartment() {
        System.out.println("testUpdateDepartment()");
        Department findDept = DepartmentDaoImpl.getInstance().selectDepartmentByNo(new Department(5));
        System.out.println("update before : " + findDept);
        findDept.setName("인사");
        findDept.setFloor(20);
        int res = DepartmentDaoImpl.getInstance().updateDepartment(findDept);
        Assert.assertEquals(1, res);
        Department updatedDept = DepartmentDaoImpl.getInstance().selectDepartmentByNo(new Department(5));
        System.out.println("update after : " + updatedDept);
    }

    @Test
    public void test3DeleteDepartment() {
        System.out.println("testDeleteDepartment()");
        int res = DepartmentDaoImpl.getInstance().deleteDepartment(new Department(5));
        Assert.assertEquals(1, res);
    }

}
