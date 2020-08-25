package erp_jsp_exam.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import erp_jsp_exam.dao.impl.DepartmentDaoImpl;
import erp_jsp_exam.dto.Department;

public class DepartmentDaoTest {

    @Test
    public void testSelectDepartmentByAll() {
        System.out.println("testSelectDepartmentByAll()");
        List<Department> list = DepartmentDaoImpl.getInstance().selectDepartmentByAll();
        Assert.assertNotNull(list);
        list.stream().forEach(System.out::println);
    }

}
