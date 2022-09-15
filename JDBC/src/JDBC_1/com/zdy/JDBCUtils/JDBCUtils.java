package JDBC_1.com.zdy.JDBCUtils;

import JDBC_1.com.zdy.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //        获取Properties文件输入流
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//        创建Properties对象
        Properties properties = new Properties();
//        加载Properties文件输入流
        properties.load(resourceAsStream);
//        通过key获取value值
        String driverClass = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
//        Driver driver  = new com.mysql.cj.jdbc.Driver();
        Class.forName(driverClass);

//        Driver driver = (Driver)clazz.newInstance();
//        //使用DriverManager.registerDriver()获取驱动的注册信息(可省略，因为Driver类的静态代码块已经自动注册)
//        DriverManager.registerDriver(driver);
        //使用DriverManager.getConnection()获取数据库连接
        return DriverManager.getConnection(url, user, password);
    }
    public static void closeResource(Connection connection, Statement preparedStatement, ResultSet resultSet){
        try {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
