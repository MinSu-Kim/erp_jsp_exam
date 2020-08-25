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

    private Title getTitle(ResultSet rs) throws SQLException {
        int no = rs.getInt("TITLE_NO");
        String name = rs.getString("TITLE_NAME");
        return new Title(no, name);
    }

}
