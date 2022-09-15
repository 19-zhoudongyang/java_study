package JDBC_1.com.zdy;

import JDBC_1.com.zdy.JDBCUtils.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedStatementInsertCommitTest {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            //      预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            //              填充占位符 ？
            preparedStatement.setString(1,"薇尔莉特");
            preparedStatement.setString(2,"空");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parse = dateFormat.parse("1850-5-20");
            //              填充占位符 ？
            preparedStatement.setDate(3,new Date(parse.getTime()));
            preparedStatement.setBlob(4,ClassLoader.getSystemClassLoader().getResourceAsStream("Violet.jpg"));
            //              执行操作
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
