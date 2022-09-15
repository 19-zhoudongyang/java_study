package JDBC_1.com.zdy;

import JDBC_1.com.zdy.JDBCUtils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementQueryUtils {
    public static <T> List<T> getInstance(Class<T> clazz , String sql, Object...args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = JDBCUtils.getConnection();
//            String sql = "Select * from customers WHERE id > ?";
            preparedStatement = connection.prepareStatement(sql);
            for(int i = 0; i < args.length; i++){
                preparedStatement.setObject(1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = metaData.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while (resultSet.next()){
//                使用反射动态创造对象
                T t = clazz.newInstance();
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
                    field.set(t,columValue);
                }
                list.add(t);
            }
            return list;
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
