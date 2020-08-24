package erp_jsp_exam.ds;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    
    public static Connection getConnection() {
        Connection conn = null;
        String proptiesPath = "oracle_db.properties";
        
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(proptiesPath)) {
            Properties props = new Properties();
            props.load(is);
            
            String url = props.getProperty("url");

            conn = DriverManager.getConnection(url, props);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
