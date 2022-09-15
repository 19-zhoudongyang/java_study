package JDBC_1.com.zdy;

import JDBC_1.com.zdy.JDBCUtils.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PreparedStatementInsertPicTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSetMetaData metaData = preparedStatement.getMetaData();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parse = sdf.parse("2021-2-13");
            for (int j = 0;j < 100;j++){ for (int i = 1;i<4;i++){
                    preparedStatement.setString(1,"bot"+i);
                    preparedStatement.setString(2,123131+""+j+"@qq.com");
                    preparedStatement.setDate(3,new Date(parse.getTime()));
                    preparedStatement.addBatch();
                    if (j % 5 == 0){
                        preparedStatement.executeBatch();
                        preparedStatement.clearBatch();
                    }
                }
            }
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
