package erp_jsp_exam.listener;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@WebListener
public class HikariCPListener implements ServletContextListener {
    private static HikariDataSource ds;

    public void contextDestroyed(ServletContextEvent sce)  { 
        if (ds != null) ds.close();
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("contextInitialized 시작");
        String hikariConfig = sce.getServletContext().getInitParameter("hikariConfig");
        Properties prop = new Properties();
        try {
            prop.load(new StringReader(hikariConfig));
            prnProperties(prop);
//            loadJDBCDriver(prop);
            initConnectionPool(prop);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }

    
    private void prnProperties(Properties prop) {
        for( Entry<Object, Object> e : prop.entrySet()) {
            System.out.printf("%s -> %s%n", e.getKey(), e.getValue());
        }
    }
    
    private void initConnectionPool(Properties prop) {
        try {
            HikariConfig cfg = new HikariConfig(prop);
            ds = new HikariDataSource(cfg);
            System.out.println(ds);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
