package connect;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectsql {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studentmanager";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "quan1502";

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        try (Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD)) {
            String query = "SELECT * FROM studentmanager.student";
            try (PreparedStatement statement = conn.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String MSSV = resultSet.getString(1);
                    String HoTen = resultSet.getString(2);
                    String Gender = resultSet.getString(3);
                    String SDT = resultSet.getString(4);
                    String Email=resultSet.getString(5);
                    String Diachi = resultSet.getString(6);

                    // Hiển thị dữ liệu tiếng Việt đúng cách
                    System.out.println(MSSV + "  " + HoTen + " " + Gender + " " + SDT + " " + Email + " " +Diachi);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Xảy ra lỗi: " + ex.getMessage());
        }
    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Kết nối thành công!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Kết nối thất bại: " + ex.getMessage());
        }
        return conn;
    }
}