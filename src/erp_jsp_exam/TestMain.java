package erp_jsp_exam;

import java.sql.Connection;

import erp_jsp_exam.ds.HikariCPJAVA;
import erp_jsp_exam.dto.Title;

public class TestMain {

    public static void main(String[] args) {
        /*        Connection con = JdbcUtil.getConnection();
        System.out.println(con);*/
        
        Connection con = HikariCPJAVA.getConnection();
        System.out.println(con);
        
        /*reflection */
        
        try {
            Class<?>dtoClass = Class.forName("erp_jsp_exam.dto.Title");
            Title title = (Title) dtoClass.newInstance();
            title.setNo(1);
            title.setName("사장");
            System.out.println(title);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        
    }

}
