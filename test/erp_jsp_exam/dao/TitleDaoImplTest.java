package erp_jsp_exam.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import erp_jsp_exam.dao.impl.TitleDaoImpl;
import erp_jsp_exam.dto.Title;

public class TitleDaoImplTest {

    @Test
    public void testSelectTitleByAll() {
        System.out.println("testSelectTitleByAll()");
        List<Title> list = TitleDaoImpl.getInstance().selectTitleByAll();
        Assert.assertNotNull(list);
        list.stream().forEach(System.out::println);
    }

}
