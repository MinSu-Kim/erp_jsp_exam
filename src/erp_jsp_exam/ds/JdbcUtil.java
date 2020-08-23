package erp_jsp_exam.ds;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
    private static HikariDataSource ds;

    static {
        String proptiesPath = "db.properties";
        
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(proptiesPath)) {
            Properties props = new Properties();
            props.load(is);
            
            HikariConfig cfg = new HikariConfig(props);
            ds = new HikariDataSource(cfg);
            ds.setMinimumIdle(10);
            ds.setMaximumPoolSize(100);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    private JdbcUtil() {}

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
