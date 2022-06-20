package com.shujuku_liu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class sql_do {
    static Connection conn = null;
    static java.sql.Statement stmt;
    static ResultSet rs;
    static String sql;
    //数据库连接操作
    public static void OpenConn() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/gaoxiao?useSSL=false";//gaoxiao数据库的url
            String username = "root"; String password = "lsjssg666";
            conn = DriverManager.getConnection(url,username,password);
            if(conn != null) System.out.println("数据库连接成功");
        }catch(Exception e) {
            System.err.println("数据库连接："+e.getMessage()+"\n");
        }
    }
    //学生密码表验证登录操作
    public static boolean login(String lname,String lpassword) throws SQLException {
        stmt = conn.createStatement();
        sql = "select 密码 from 学生密码 where 学号="+"'"+lname+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()) {
            if(rs.getString("密码").equals(lpassword)) {
                System.out.println("密码正确！");
                return true;
            }else {
                System.out.println("密码错误！");
                return false;
            }
        }
        return false;
    }
    //老师密码表验证登录操作
    public static boolean login_t(String lname,String lpassword) throws SQLException {
        stmt = conn.createStatement();
        sql = "select 教师密码 from 老师密码 where 教师号="+"'"+lname+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()) {
            if(rs.getString("教师密码").equals(lpassword)) {
                System.out.println("密码正确！");
                return true;
            }else {
                System.out.println("密码错误！");
                return false;
            }
        }
        return false;
    }
    //查询操作
    public ResultSet executeQuery(String sql) {
        stmt = null; rs = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        }catch(SQLException e) {
            System.err.println("查询数据："+e.getMessage());
        }
        return rs;
    }
    //增添数据操作
    public void execute(String sql) {
        stmt = null; rs = null;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt.execute(sql);
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    //关闭statement对象的方法
    public void closeStmt() {
        try {
            stmt.close();
        }catch(SQLException e){
            System.err.println("释放对象"+e.getMessage());
        }
    }
    //关闭数据库的方法
    public void closeConn() {
        try {
            conn.close();
        }catch(SQLException e) {
            System.err.println("释放对象"+e.getMessage());
        }
    }
}