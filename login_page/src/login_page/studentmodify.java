/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CRUD (insert, update, delete, findAll)
 *
 */
public class studentmodify {

    public static List<QLSV1> findAll() {
        List<QLSV1> studentList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select *from studentmanagement.student";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                QLSV1 std = new QLSV1(resultSet.getInt("id"),
                        resultSet.getString("fullname"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phone_number"),
                        resultSet.getString("address"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return studentList;
    }

    public static void insert(QLSV1 std) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "872004@abcxyz");

            //query
            String sql = "insert into student(id , fullname, gender , email, phone_number, address) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setInt(1, std.getId());
            statement.setString(2, std.getFullname());
            statement.setString(3, std.getGender());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            statement.setString(6, std.getAddress());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void update(QLSV1 std) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "872004@abcxyz");

            //query
            String sql = "update student set fullname=?,gender=?,address=?,email=?,phone_number=? where id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, std.getId());
            statement.setString(2, std.getFullname());
            statement.setString(3, std.getGender());
            statement.setString(6, std.getAddress());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "872004@abcxyz");

            //query
            String sql = "delete from student where id = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }

    public static List<QLSV1> findByFullname(String fullname) {
        List<QLSV1> studentList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "872004@abcxyz");

            //query
            String sql = "select * from student where fullname like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + fullname + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                QLSV1 std = new QLSV1(resultSet.getInt("id"),
                        resultSet.getString("fullname"), resultSet.getString("gender"),
                        resultSet.getString("email"), resultSet.getString("phone_number"),
                        resultSet.getString("address"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(studentmodify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return studentList;
    }
}
