package erp_jsp_exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import erp_jsp_exam.dao.TitleDao;
import erp_jsp_exam.ds.HikariCPJAVA;
import erp_jsp_exam.dto.Title;

public class TitleDaoImpl implements TitleDao {
    private static final TitleDaoImpl instance = new TitleDaoImpl();

    private TitleDaoImpl() {}

    public static TitleDaoImpl getInstance() {
        return instance;
    }
    
    @Override
    public List<Title> selectTitleByAll() {
        String sql = "SELECT TITLE_NO, TITLE_NAME FROM TITLE";

        try (Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                List<Title> list = new ArrayList<>();
                do {
                    list.add(getTitle(rs));
                } while (rs.next());
                return list;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Title selectTitleByNo(Title title) {
        String sql = "SELECT TITLE_NO, TITLE_NAME FROM TITLE WHERE TITLE_NO=?";
        try (Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);){
            pstmt.setInt(1, title.getNo());
            try(ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                     return getTitle(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private Title getTitle(ResultSet rs) throws SQLException {
        int no = rs.getInt("TITLE_NO");
        String name = rs.getString("TITLE_NAME");
        return new Title(no, name);
    }

    @Override
    public int insertTitle(Title title) {
        String sql = "INSERT INTO TITLE VALUES(?, ?)";
        try(Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, title.getNo());
            pstmt.setString(2, title.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateTitle(Title title) {
        String sql = "UPDATE TITLE SET TITLE_NAME=? WHERE TITLE_NO = ?";
        try(Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, title.getName());
            pstmt.setInt(2, title.getNo());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteTitle(Title title) {
        String sql = "DELETE FROM TITLE WHERE TITLE_NO = ?";
        try(Connection con = HikariCPJAVA.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, title.getNo());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
