package erp_jsp_exam;

import java.sql.Connection;

import erp_jsp_exam.ds.HikariCPJAVA;

public class TestMain {

    public static void main(String[] args) {
        /*        Connection con = JdbcUtil.getConnection();
        System.out.println(con);*/
        
        Connection con = HikariCPJAVA.getConnection();
        System.out.println(con);
    }

}
