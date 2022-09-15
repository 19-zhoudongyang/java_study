一、JDBC的体系结构
    1.面向应用的API：Java API，抽象接口，供应用程序开发人员使用(连接数据库，执行SQL语句，获得结果)
    2.面向数据库的API：Java DRIVER API，供开发商开发数据库驱动用

二、JDBC程序编写步骤
    [1](./JDBC_pic/JDBC%E7%9A%84%E4%BD%BF%E7%94%A8%E6%B5%81%E7%A8%8B.PNG)

三、获取数据库连接
    {一}方式一：
        [1](./JDBC_pic/JDBC%E8%8E%B7%E5%8F%96%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E7%9A%84%E6%96%B9%E5%BC%8F1.PNG)
    {二}方式二
        [1](./JDBC_pic/JDBC%E8%8E%B7%E5%8F%96%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E7%9A%84%E6%96%B9%E5%BC%8F2.PNG)
    {三}方式三
        [1](./JDBC_pic/JDBC%E8%8E%B7%E5%8F%96%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E7%9A%84%E6%96%B9%E5%BC%8F3.PNG)
    {四}方式四
        [1](./JDBC_pic/JDBC%E8%8E%B7%E5%8F%96%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E7%9A%84%E6%96%B9%E5%BC%8F4.PNG)
    {五}方式五
        [1](./JDBC_pic/JDBC%E8%8E%B7%E5%8F%96%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E7%9A%84%E6%96%B9%E5%BC%8F5.PNG)

四、使用PreparedStatement操作数据库
    {一}使用Statement操作数据库表的弊端和使用PreparedStatement操作数据库表的优势
        1.SQL注入问题：通过在SQL语句中添加非法的SQL语句段或命令以达到恶意行为的做法
        2.PreparedStatement对sql语句进行了预编译，逻辑结构锁死，无法通过输入非法的sql语句段或命令改变其逻辑
        3.Statement需要反复校验sql语句，而PreparedStatement对sql语句进行了预编译，只校验一次(对批量操作数据有优势)
        4.PreparedStatement可以操作Blob类型的数据，Statement不行
    {二}使用PreparedStatement(从Statement扩展而来)替代Statement
        [1](./JDBC_pic/%E4%BD%BF%E7%94%A8PreparedStatement%201.PNG)
        [1](./JDBC_pic/%E4%BD%BF%E7%94%A8PreparedStatement%202.PNG)
        [1](./JDBC_pic/%E4%BD%BF%E7%94%A8PreparedStatement%203.PNG)
    {三}ORM编程思想(object relational mapping)
        1.一个数据表对应一个java类
        2.表中的一条记录对应java类的一个对象
        3.表中的一个字段对应java类的一个属性
    {四}查询
        1.使用JDBC查询返回结果集
            [1](./JDBC_pic/%E4%BD%BF%E7%94%A8JDBC%E6%9F%A5%E8%AF%A2%E8%BF%94%E5%9B%9E%E7%BB%93%E6%9E%9C%E9%9B%86.PNG)
        2.使用JDBC查询返回结果集查询字段名的两种方法
            [1](./JDBC_pic/%E4%BD%BF%E7%94%A8JDBC%E6%9F%A5%E8%AF%A2%E8%BF%94%E5%9B%9E%E7%BB%93%E6%9E%9C%E9%9B%86%E6%9F%A5%E8%AF%A2%E5%AD%97%E6%AE%B5%E5%90%8D%E7%9A%84%E4%B8%A4%E7%A7%8D%E6%96%B9%E6%B3%95.PNG)
            <!-- 如果sql中没有给字段起别名，则获取的就是字段名 -->
    {五}操作Blob类型
        1.setBlob(int,FileinputStream)方法填充占位符
    {六}批量插入
        [1](./JDBC_pic/%E6%89%B9%E9%87%8F%E6%8F%92%E5%85%A5.PNG)
        1. 使用addBatch、executeBatch()、clearBatch()
        2.开启mysql批处理
            <!-- mysql服务器是默认关闭批处理的，需要设置参数开启 -->
            [1](./JDBC_pic/%E5%BC%80%E5%90%AFmysql%E6%89%B9%E5%A4%84%E7%90%86.PNG)
        3.设置不允许自动提交
            [1](./JDBC_pic/%E8%AE%BE%E7%BD%AE%E4%B8%8D%E5%85%81%E8%AE%B8%E8%87%AA%E5%8A%A8%E6%8F%90%E4%BA%A4.PNG)
    {七}加入事务的使用
        1.事务：一组逻辑操作单元，使数据从一种状态变换到另一种状态(一组逻辑操作单元，一个或多个DML操作)
        2.
            (1)DDL操作一旦执行便自动提交
            (2)DML操作默认情况下一旦执行自动提交，可通过set autocommit = false 的方式取消DML操作的自动提交
            (3)默认在关闭连接时，会自动的提交数据
        3.使用事务
            (1)设置不允许自动提交
            [1](./JDBC_pic/%E8%AE%BE%E7%BD%AE%E4%B8%8D%E5%85%81%E8%AE%B8%E8%87%AA%E5%8A%A8%E6%8F%90%E4%BA%A4.PNG)
            (2)在try-catch-finally里使用DML操作，并在catch里设置connection.rollback()回滚
            (3)在finally里提交事务connection.commit()
            <!-- 使用连接池在把连接放回到连接池之前，需要先把自动提交事务恢复：set autocommit = true -->
        4.事务的ACID属性
            [1](./JDBC_pic/%E4%BA%8B%E5%8A%A1%E7%9A%84ACID%E5%B1%9E%E6%80%A7.PNG)
        5.事务隔离级别和并发问题
            (1)并发问题
                [1](./JDBC_pic/%E4%BA%8B%E5%8A%A1%E7%9A%84%E5%B9%B6%E5%8F%91%E9%97%AE%E9%A2%98.PNG)
            (2)隔离级别
                [1](./JDBC_pic/%E4%BA%8B%E5%8A%A1%E7%9A%84%E9%9A%94%E7%A6%BB%E7%BA%A7%E5%88%AB.PNG)
            (3)设置数据库的隔离级别
                connection.setTransactionIsolation()

五、DAO
    (一)定义通用的dao抽象类
    (二)定义对于的类的dao接口规范
        声明方法和形参
    (三)定义同时继承抽象类和实现接口的实现类(子类)
    (四)优化
        [1](./JDBC_pic/%E5%9C%A8%E6%8A%BD%E8%B1%A1%E6%B3%9B%E5%9E%8B%E7%88%B6%E7%B1%BBDAO%E4%B8%AD%E8%8E%B7%E5%8F%96%E5%AD%90%E7%B1%BB%E7%9A%84%E8%BF%90%E8%A1%8C%E6%97%B6%E7%B1%BBclass.PNG)

六、数据库连接池
    (一)c3p0
        1.配置方式
            (1)xml(配置文件名必须叫做c3p0-config.xml)
                *1.
                    [1](./JDBC_pic/c3p0xml%E9%85%8D%E7%BD%AE.PNG)
                *2.然后使用构造器获取配置
                    ComboPooledDataSource 变量名 = new ComboPooledDataSource("intergalactoApp");
                *3.使用getConnection()获取连接
                    Connection connection = 变量名.getConnection();
                [1](./JDBC_pic/c3p0%E8%8E%B7%E5%8F%96xml%E9%85%8D%E7%BD%AE.PNG)
            (2)代码配置
               [1](./JDBC_pic/c3p0%E4%BD%BF%E7%94%A8%E4%BB%A3%E7%A0%81%E9%85%8D%E7%BD%AE.PNG)
    (二)dbcp
        1.配置方式
            (1)使用提供的静态方法
                *1.Propertie文件配置：
                    [1](./JDBC_pic/dbcp%E7%9A%84Properties%E9%85%8D%E7%BD%AE.PNG)
                *2.使用BasicDataSourceFactory.createDataSource(Properties properties)读取Properties文件
                    [1](./JDBC_pic/dbcp%E7%9A%84Properties%E6%96%B9%E5%BC%8F%E8%8E%B7%E5%8F%96%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5.PNG)
            (2)代码配置
               [1](./JDBC_pic/dbcp%E4%BB%A3%E7%A0%81%E9%85%8D%E7%BD%AE.PNG)
    (三)druid
        1.配置方式
            (1)使用提供的静态方法
                *1.Propertie文件配置：
                    [1](./JDBC_pic/druid%E7%9A%84Properties%E9%85%8D%E7%BD%AE.PNG)
                *2.使用DruidDataSourceFactory.createDataSource(Properties properties)读取Properties文件
                    [1](./JDBC_pic/druid%E7%9A%84Properties%E6%96%B9%E5%BC%8F%E8%8E%B7%E5%8F%96%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5.PNG)
            (2)代码配置

七、Apache-DBUtils
    (一)QueryRunner
        {一}ResultSetHandler
            1.Bean
                (1)BeanHander:是ResultSetHandler接口的实现类，用于封装表中的一条记录
                    [1](./JDBC_pic/BeanHandler%E7%9A%84%E4%BD%BF%E7%94%A8.PNG)
                (2)BeanListHandler是ResultSetHandler接口的实现类,用于封装表中的多条记录构成的集合
                    [1](./JDBC_pic/BeanListHandler%E7%9A%84%E4%BD%BF%E7%94%A8.PNG)
            2.Map
                (1)MapHandler
                    [1](./JDBC_pic/MapHandler%E7%9A%84%E4%BD%BF%E7%94%A8.PNG)
                (2)MapListHandler
                    [1](./JDBC_pic/MapListHandler%E7%9A%84%E4%BD%BF%E7%94%A8.PNG)
            3.查询特殊值ScalarHandler
                (1)获取表中记录的个数
                    [1](./JDBC_pic/ScalarHandler%E7%9A%84%E4%BD%BF%E7%94%A8.PNG)
                (2)获取某个字段最大值
                    [1](./JDBC_pic/ScalarHandler%E7%9A%84%E4%BD%BF%E7%94%A82.PNG)
            4.自定义ResultSetHandler的实现类
    (二)DbUtils
        {一}使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
            1.可以关闭Connection
            2.可以关闭Statement
            3.可以关闭ResultSet