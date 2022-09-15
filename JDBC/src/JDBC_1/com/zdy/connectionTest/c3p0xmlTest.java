package JDBC_1.com.zdy.connectionTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class c3p0xmlTest {
    public static void main(String[] args) {
        //获取配置文件输入流

        ComboPooledDataSource dataSource;
        try {
            //获取配置
            dataSource = new ComboPooledDataSource("intergalactoApp");
            //从连接池获取数据库连接
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
