package JDBC_1.com.zdy;

import JDBC_1.com.zdy.JDBCUtils.JDBCUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;

public class PreparedStatementSelectBlobTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = JDBCUtils.getConnection();
            String sql = "Select * from customers";
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1,10);
            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                CustomersBean customersBean = new CustomersBean();
                for (int i = 0;i < columnCount-1;i++){
                    //获取一行里每一列的数据
                    Object columValue = resultSet.getObject(i + 1);
                    //获取一行里每一列的字段名(表的字段名)
//                    String columnName = metaData.getColumnName(i+1);
                    //获取查询时起的别名(标签)的方法
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //使用反射获得运行时类
                    Field field = CustomersBean.class.getDeclaredField(columnLabel);
                    //将对私有属性赋值的权限开启
                    field.setAccessible(true);
                    //使用反射给对象赋值
                    field.set(customersBean,columValue);
                }
                if (resultSet.getBlob("photo") != null){
                    Blob blob = resultSet.getBlob("photo");
                    System.out.println(resultSet.getBlob(5).length());
                    InputStream inputStream = blob.getBinaryStream();
                    FileOutputStream outputStream = new FileOutputStream("Evergarden.jpg");
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) != -1){
                        outputStream.write(buffer,0,len);
                    }
                }
                System.out.println(customersBean);
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }

    }
}
