package erp_jsp_exam.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp_jsp_exam.dao.impl.TitleDaoImpl;
import erp_jsp_exam.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {

    @Test
    public void testSelectTitleByNo() {
        System.out.println("testSelectTitleByNo()");
        Title findTitle = TitleDaoImpl.getInstance().selectTitleByNo(new Title(1));
        Assert.assertNotNull(findTitle);
        System.out.println(findTitle);
    }

    @Test
    public void testSelectTitleByAll() {
        System.out.println("testSelectTitleByAll()");
        List<Title> list = TitleDaoImpl.getInstance().selectTitleByAll();
        Assert.assertNotNull(list);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void test1InsertTitle() {
        System.out.println("testInsertTitle()");
        Title newTitle = new Title(6, "인턴");
        int res = TitleDaoImpl.getInstance().insertTitle(newTitle);
        Assert.assertEquals(1, res);
    }

    @Test
    public void test2UpdateTitle() {
        System.out.println("testUpdateTitle()");
        Title findTitle = TitleDaoImpl.getInstance().selectTitleByNo(new Title(6));
        System.out.println("update before : " + findTitle);
        findTitle.setName("계약직");
        int res = TitleDaoImpl.getInstance().updateTitle(findTitle);
        Assert.assertEquals(1, res);
        
        Title updatedTitle = TitleDaoImpl.getInstance().selectTitleByNo(new Title(6));
        System.out.println("update after : " + updatedTitle);
        
    }

    @Test
    public void test3DeleteTitle() {
        System.out.println("testDeleteTitle()");
        Title newTitle = new Title(6);
        int res = TitleDaoImpl.getInstance().deleteTitle(newTitle);
        Assert.assertEquals(1, res);
    }

}
