package erp_jsp_exam.ds;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class HikariCPJNDI {
    private static DataSource ds;

    static {
        try {
            InitialContext ic= new InitialContext();                
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/jspdb");
            System.out.println("ds : " + ds);
        } catch (NamingException e) {
            e.printStackTrace();
        } 
    }
    
    private HikariCPJNDI() {}

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
