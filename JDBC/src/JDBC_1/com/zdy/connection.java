package JDBC_1.com.zdy;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class connection {
    public static void main(String[] args) throws Exception {
//        获取Properties文件输入流
        InputStream resourceAsStream = connection.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        创建Properties对象
        Properties properties = new Properties();
//        加载Properties文件输入流
        properties.load(resourceAsStream);
//        通过key获取value值
        String driverClass = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
//        Driver driver  = new com.mysql.cj.jdbc.Driver();
        Class.forName(driverClass);

//        Driver driver = (Driver)clazz.newInstance();
//        //使用DriverManager.registerDriver()获取驱动的注册信息(可省略，因为Driver类的静态代码块已经自动注册)
//        DriverManager.registerDriver(driver);
        //使用DriverManager.getConnection()获取数据库连接
        Connection connect = DriverManager.getConnection(url, user, password);
        System.out.println(connect);
    }
}
