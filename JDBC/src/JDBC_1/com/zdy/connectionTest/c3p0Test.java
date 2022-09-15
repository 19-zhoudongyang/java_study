package JDBC_1.com.zdy.connectionTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class c3p0Test {
    public static void main(String[] args) {
        //获取配置文件输入流
        InputStream resourceAsStream =
                c3p0Test.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = null;
        ComboPooledDataSource dataSource = null;
        try {
            //读取输入流
            properties = new Properties();
            properties.load(resourceAsStream);
            //获取value值
            String driverClass = properties.getProperty("driverClass");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            //配置数据库连接池
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            //设置数据库连接池的连接数
            dataSource.setInitialPoolSize(10);
            //从连接池获取数据库连接
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
