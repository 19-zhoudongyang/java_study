package JDBC_1.com.zdy.connectionTest;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class dbcpPropertiesTest {
    private static DataSource dataSource;
    //使用静态代码块创建数据库连接池，只加载一次
    static {
        Properties properties = new Properties();
        InputStream resourceAsStream =null ;
        try{
            //读取properties文件
            resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            properties.load(resourceAsStream);
            //使用静态方法BasicDataSourceFactory.createDataSource(Properties properties)读取数据源
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //获取数据库连接
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(connection);

    }
}
