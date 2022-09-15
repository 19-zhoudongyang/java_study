package JDBC_1.com.zdy.Apache_DBUtils.QueryRunner;

import JDBC_1.com.zdy.JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        int i = queryRunner.update(connection, sql, "周", "91239123@qq.com", "2000-02-14");
        if (i == 0){
            System.out.println("添加失败");
        }else{
            System.out.println("成功添加了"+i+"条记录");
        }
    }
}
