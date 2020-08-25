package erp_jsp_exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import erp_jsp_exam.dao.EmployeeDao;
import erp_jsp_exam.ds.HikariCPJAVA;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();

    private EmployeeDaoImpl() {}

    public static EmployeeDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Employee selectEmployeeByNo(Employee emp) {
        String sql = "SELECT EMP_NO , EMP_NAME , TNO , MANAGER , SALARY , DNO , HIREDATE " + 
                     "  FROM EMPLOYEE" + 
                     " WHERE EMP_NO = ?";
        try (Connection con = HikariCPJAVA.getConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, emp.getNo());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return getEmployee(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> selectEmployeeByAll() {
        String sql = "SELECT e.EMP_NO, e.EMP_NAME, e.TNO, e.MANAGER, e.SALARY, e.DNO, e.HIREDATE, t.TITLE_NAME, d.DEPT_NAME, " + 
                     "       m.EMP_NAME MANAGER_NAME" + 
                     "  FROM EMPLOYEE e JOIN TITLE t ON e.TNO = t.TITLE_NO " + 
                     "       LEFT JOIN EMPLOYEE m ON e.MANAGER = m.EMP_NO " + 
                     "       JOIN DEPARTMENT d ON e.DNO = d.DEPT_NO";
        List<Employee> list = null;
        try (Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                list = new ArrayList<>();
                do {
                    list.add(getEmployee(rs));
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Employee getEmployee(ResultSet rs) throws SQLException {
        int no = rs.getInt("EMP_NO");
        String name = rs.getString("EMP_NAME");
        Title title = new Title(rs.getInt("TNO"));
        Employee manager = new Employee(rs.getInt("MANAGER"));
        int salary = rs.getInt("SALARY");
        Department dept = new Department(rs.getInt("DNO"));
        try {
            title.setName(rs.getString("TITLE_NAME"));
        }catch (SQLException e) {}
        try {
            manager.setName(rs.getString("MANAGER_NAME"));
        }catch (SQLException e) {}
        try {
            dept.setName(rs.getString("DEPT_NAME"));
        }catch (SQLException e) {}
        
        Date hireDate = rs.getTimestamp("HIREDATE");
        return new Employee(no, name, title, manager, salary, dept, hireDate);
    }

    @Override
    public int insertEmployee(Employee emp) {
        String sql = "INSERT INTO EMPLOYEE(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE)" + 
                     "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try(Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, emp.getNo());
            pstmt.setString(2, emp.getName());
            pstmt.setInt(3, emp.getTitle().getNo());
            pstmt.setInt(4, emp.getManager().getNo());
            pstmt.setInt(5, emp.getSalary());
            pstmt.setInt(6, emp.getDept().getNo());
            pstmt.setTimestamp(7, new Timestamp(emp.getHireDate().getTime())); //util.Date->sql.Date로 변환
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateEmployee(Employee emp) {
        StringBuilder sql = new StringBuilder("UPDATE EMPLOYEE SET ");
        if (emp.getName()!=null) sql.append("EMP_NAME=?, ");
        if (emp.getTitle()!=null) sql.append("TNO=?, ");
        if (emp.getManager()!=null)sql.append("MANAGER=?, ");
        if (emp.getSalary()!=0) sql.append("SALARY=?, ");
        if (emp.getDept()!=null) sql.append("DNO=?, ");
        if (emp.getHireDate()!=null) sql.append("HIREDATE=?, ");
    
        sql.replace(sql.lastIndexOf(","), sql.length(), " ");
        sql.append("WHERE EMP_NO=?");
    
        try(Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql.toString())){
            int argCnt = 1;
            if (emp.getName()!=null) pstmt.setString(argCnt++, emp.getName());
            if (emp.getTitle()!=null) pstmt.setInt(argCnt++, emp.getTitle().getNo());
            if (emp.getManager()!=null)pstmt.setInt(argCnt++, emp.getManager().getNo());
            if (emp.getSalary()!=0) pstmt.setInt(argCnt++, emp.getSalary());
            if (emp.getDept()!=null)pstmt.setInt(argCnt++, emp.getDept().getNo());
            if (emp.getHireDate()!=null) pstmt.setTimestamp(argCnt++, new Timestamp(emp.getHireDate().getTime()));
            pstmt.setInt(argCnt++, emp.getNo());
            return pstmt.executeUpdate();
        } catch (SQLException e) { 
             e.printStackTrace(); 
        }
        return 0;
    }

    @Override
    public int deleteEmployee(Employee emp) {
        String sql = "DELETE FROM EMPLOYEE WHERE EMP_NO=?";
        try(Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, emp.getNo());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
