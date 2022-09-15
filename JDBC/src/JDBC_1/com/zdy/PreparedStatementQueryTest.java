package JDBC_1.com.zdy;

import JDBC_1.com.zdy.JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class PreparedStatementQueryTest {
    public static void main(String[] args) throws SQLException {
        String sql = "Select * from customers Where id >= ?";
        List<CustomersBean> list = PreparedStatementQueryUtils.getInstance(CustomersBean.class, sql, 8);
        list.forEach(System.out::println);
    }
}
