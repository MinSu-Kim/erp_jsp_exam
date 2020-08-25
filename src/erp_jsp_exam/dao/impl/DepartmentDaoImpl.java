package erp_jsp_exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import erp_jsp_exam.dao.DepartmentDao;
import erp_jsp_exam.ds.HikariCPJAVA;
import erp_jsp_exam.dto.Department;

public class DepartmentDaoImpl implements DepartmentDao {
    private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();

    private DepartmentDaoImpl() {}

    public static DepartmentDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Department> selectDepartmentByAll() {
        String sql = "SELECT DEPT_NO, DEPT_NAME, FLOOR FROM DEPARTMENT";
        
        try (Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                List<Department> list = new ArrayList<>();
                do {
                    list.add(getDepartment(rs));
                } while (rs.next());
                return list;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Department getDepartment(ResultSet rs) throws SQLException {
        int no = rs.getInt("DEPT_NO");
        String name = rs.getString("DEPT_NAME");
        int floor = rs.getInt("FLOOR");
        return new Department(no, name, floor);
    }

}
