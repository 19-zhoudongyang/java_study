package JDBC_1.com.zdy.Apache_DBUtils.QueryRunner;

import JDBC_1.com.zdy.CustomersBean;
import JDBC_1.com.zdy.JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SelectTest {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth from customers where id > ?";
        //实例化BeanHandler
//        BeanHandler<CustomersBean> handler = new BeanHandler<>(CustomersBean.class);
       //获取记录
        //实例化BeanListHandler
        BeanListHandler<CustomersBean> listHandler = new BeanListHandler<>(CustomersBean.class);
        //获取记录
        List<CustomersBean> list = queryRunner.query(connection, sql, listHandler, 10);
        list.forEach(System.out::println);
    }
}
