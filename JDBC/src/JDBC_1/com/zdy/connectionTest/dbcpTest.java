package JDBC_1.com.zdy.connectionTest;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class dbcpTest {
    public static void main(String[] args) {
        BasicDataSource dataSource = null;

        Connection connection = null;
        try {
            //创建dbcp的数据库连接池
            dataSource = new BasicDataSource();
            //设置基本信息
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/test");
            dataSource.setUsername("root");
            dataSource.setPassword("Weizijierhuo0214");
            //获取数据库连接
            connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
