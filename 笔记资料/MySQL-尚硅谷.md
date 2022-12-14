一、数据库的概念
    (一)DB数据库(Database)
    (二)DBMS数据库管理系统(Database Management System)
    (三)SQL结构化查询语言(Structured Query Language)

二、ORM映射(Object Relational Mapping)
    (一)概念：
        1.数据库中一个表 <----> Java或Python中的一个类
        2.表中的一条数据 <----> 类中的一个对象
        3.表中的一个列 <----> 类中的一个字段(属性)

三、关系模型
    1.一对一
    2.一对多
    3.多对多
    4.自我引用

四、MySQL的指令
    cmd指令
        (1)指令
            -u:用户名
            -p：密码
            -P：端口号
            -h：ip地址
        (2)服务的启动和停止
            启动：net start MySQL服务名
            停止：net stop MySQL服务名
        (3)登录和登出
            登录：
                "mysql -u用户名 -p"  回车enter后输密码
            登出：
                "quit"
    MySQL自带的客户端指令

五、操作数据库数据的语法
    (一)DDL数据定义语言
        1.CREATE
        2.ALTER
        3.DROP
        4.RENAME
        5.TRUNCATE
    (二)DML数据操作语言
        1.INSERT
        2.DELETE
        3.UPDATE
        4.SELECT
            (1)通用语法：
                SELECT 字段 FROM 表名;
            (2)伪表语法：
                SELECT ... FROM DUAL(伪表);
            (3)别名语法：
                SELECT 字段 别名 FROM 表名; 语法：字段后空格+别名(或者加AS/别名加双引号"")，结果集返回字段名为别名的结果集
            (4)去除重复行DISTINCT
                SELECT DISTINCT 字段 FROM 表名;
            (5)空值参与运算
                *空值不等于0
                *1.IFNULL(参数1,参数2)：如果参数1是NULL，则用参数2代替运算
            (6)着重号``
                *1.修饰关键字(或保留字)使之成为字段名或表名
            (7)查询常数
                *1.SELECT 常数 字段 FROM 表名;
                数据库中不存在的字段，往返回的结果集里添加一列都是此常数的字段
            (8)显示表结构
                *1.DESCRIBE 表名;
                *2.DESC 表名;
            (9)过滤数据
                *1.WHERE
                    {1}SELECT 字段 FROM 表名 WHERE 字段的条件;
                    {2}WHERE必须放在FROM后，不能分开
                    {3}因为只要有NULL参与等于判断，结果就为NULL，所以想查询值为NULL的行要使用安全等于 <=>
                *2.HAVING
                    {1}如果过滤条件出现了聚合函数，则必须使用HAVING来替换WHERE，否则报错
                    {2}HAVING必须写在GROUP BY后面
                    {3}当过滤条件中没有聚合函数时，条件声明在WHERE和HAVING中都可以，但是建议声明在WHERE中
                *3.WHERE和HAVING的对比
                    {1}使用范围：HAVING的适用范围更广
                    {2}如果没有聚合函数，WHERE的执行效率比HAVING更高(在关联查询中，WHERE是先筛选后连接，HAVING是先连接后筛选)
                    {3}
            (10)排序ORDER BY
                *默认情况下，查询出的数据是按照添加顺序显示的
                *列的别名只能在ORDER BY中使用，不能在WHERE中使用，因为查询过程中执行WHERE部分在执行SELECT部分之前，执行ORDER BY部分在执行SELECT部分之后
                *1.升序ASC和降序DESC
                    SELECT 字段 FROM 表名 ORDER BY 作为排序条件的字段 DESC(ASC);
                *2.二级排序
                    SELECT 字段 FROM 表名 ORDER BY 作为排序条件的字段1 DESC(ASC)，作为排序条件的字段2 DESC(ASC);
            (11)分页LIMIT
                注意点
                    *LIMIT写在ORDER BY后
                *1.语法
                    SELECT 字段 FROM 表名 LIMIT 偏移量(指针的位置),显示多少数据;
                        eg:
                            SELECT 字段 FROM 表名 LIMIT 0,20; 显示偏移量0的前20条记录
                *2.公式：
                    LIMIT (pageNum-1)*pageSize,pageSize
                *3.MySQL8.0新特性
                    LIMIT ... OFFSET ...
                        eg:
                            SELECT 字段 FROM 表名 LIMIT 偏移量(指针的位置),显示多少数据;
                            等价于
                            SELECT 字段 FROM 表名 LIMIT 显示多少数据 OFFSET 偏移量(指针的位置);
            (12)多表查询
                *1.连接条件
                    用WHERE实现
                    用JOIN... ON实现
                *2.表的别名
                    {1}表的别名可以在SELECT和WHERE中使用，声明别名后，只能使用别名
                    {2}如果有n个表实现多表查询，则需要至少n-1个连接条件
                *3.分类：
                    角度1：
                        {1}等值连接
                        {2}非等值连接
                    角度2：
                        {1}自连接
                        {2}非自连接
                    角度3
                        {1}内连接
                        {2}外连接
                            [1]左外连接：两表在连接过程中除了返回满足连接条件的行以外还返回左表中不满足条件的行
                            [2]两表在连接过程中除了返回满足连接条件的行以外还返回右表中不满足条件的行
                            [3]外连接语法
                                92语法
                                    使用+号
                                         MySQL不支持92版外连接的写法
                                99语法
                                    OUTER可省略
                                    左外连接使用
                                        LEFT OUTER JOIN ...ON
                                    右外连接使用
                                        RIGHT OUTER JOIN ...ON
                                    满外连接
                                        FULL OUTER JOIN ...ON(MySQL不满足此写法)
                                        使用UNION ALL或者UNION实现满外连接
                *4.99语法的新特性
                    {1}自然连接NATURAL JOIN:它会帮你自动查询两张连接表中所有相同的字段，然后进行等值连接
                    {2}等值连接USING(字段)：两张表中相同的字段
            (13)分组GROUP BY
                SELECT 字段 FROM 表名 GROUP BY 字段;
                *1.
                    SELECT中出现的非组函数的字段必须声明在GROUP BY中，反之GROUP BY中声明的字段可以不出现在SELECT中
                *2.
                    GROUP BY声明在FROM后面，WHERE后面，ORDER BY前面，LIMIT前面
                *3.
                    在GROUP BY后加上WITH ROLLUP，找到没有分组的数据，此时不能使用ORDER BY进行排序(ORDER BY和WITH ROLLUP是排斥的)
            (14)过滤HAVING
                {1}如果过滤条件出现了聚合函数，则必须使用HAVING来替换WHERE，否则报错
                {2}HAVING必须写在GROUP BY后面
                {3}当过滤条件中没有聚合函数时，条件声明在WHERE和HAVING中都可以，但是建议声明在WHERE中
            (15)子查询
                #注意点
                    *1.子查询要包含在括号内
                    *2.将子查询放在查询条件的右边(增强可读性)
                    *3.单行操作符对应单行子查询，多行操作符对应多行子查询
                子查询的分类：
                    *1.单行子查询和多行子查询
                    *2.
                        相关子查询(子查询返回的数据和主查询相关)
                        和
                        不相关子查询(子查询返回的数据和主查询不相关)
                操作符：
                    *1.单行操作符
                        {1}=
                        {2}!=
                        {3}>
                        {4}>=
                        {5}<
                        {6}<=
                    *2.多行操作符
                        {1}IN
                        {2}ANY
                            需要和单行操作符一起使用，和子查询返回的某一个值做比较
                        {3}ALL
                            需要和单行操作符一起使用，和子查询返回的所有值做比较
                        {4}SOME
                            ANY的别名，作用相同
    (三)DCL数据控制语言
        1.COMMIT
        2.ROLLBACK
        3.SAVEPOINT
        4.GRANT
        5.REVOKE
    (四)运算符
        算数运算符
            1.加 +
            2.减 -
            3.乘 *
            4.除 /或DIV
            5.求余数 %或MOD
        比较运算符
            注意点：
                *字符串存在隐式转换，如果转换不成功，则看做0
                *两边都是字符串的话，则按照ANSI的比较规则进行比较
                *只要有NULL参与判断，结果就为NULL
            1.等于 =
            2.安全等于 <=>
            3.不等于 <>或!=
            4.小于 <
            5.小于等于 <=
            6.大于 >
            7.大于等于 >=
        非符号算数运算符(关键字)
            ![1](./MySQL_pic/%E9%9D%9E%E7%AC%A6%E5%8F%B7%E8%BF%90%E7%AE%97%E7%AC%A6.PNG)
            注意点：
                *BETWEEN 下限 AND 上限，下限和上限的位置不能对调
                *在单引号内''的%代表不确定个数的不确定字符；_代表一个不确定字符，配合LIKE使用；如想查询包含_的值，则在_前使用转移字符\，使用ESCAPE可以指定某个字符作为转移字符
        逻辑运算符
            1.OR或||
            2.AND或&&
            3.NOT或!
            4.XOR: 逻辑异或
                条件1 XOR 条件2
                条件1满足 条件2不满足返回真(反之亦然)
        位运算符
            1.& 按位与
            2.| 按位或
            3.^ 按位异
            4.~ 按位取反
            5.>>
            6.<<
    (五)管理数据库
        (1)查看当前连接中的数据库都有哪些
             SHOW DATABASE;
        (2)切换数据库
            USE 数据库名;
        (3)查看当前使用的数据库
            SELECT DATABASE() FROM DUAL;
        (4)查看当前数据库中保存的数据表
            SHOW TABLE;
        (5)查看指定数据库下保存的数据表
            SHOW TABLES FROM 数据库名;
        (6)创建数据库
                *1.CREATE DATABASE 数据库名;
                *2.CREATE DATABASE 数据库名 CHARACTER SET ''; 显示指明要创建的数据库的字符集
                *3.CREATE DATABASE IF NOT EXISTS 数据库名 CHARACTER SET '';
                    如果要创建的数据库不存在则创建成功，如果存在则失败，但不会报错
        (7)更改数据库字符集
                ALTER DATABASE 数据库名 CHARACTER SET '';
        (8)删除数据库
            *1.DROP DATABASE 数据库名;
            *2.DROP DATABASE IF EXISTS 数据库名;
                    如果要删除的数据库存在则删除成功；如果不存在则失败，但不会报错
        (9)创建数据库
            *1.CREATE DATABASE 数据库名;
            *2.CREATE DATABASE 数据库名 CHARACTER SET ''; 显示指明要创建的数据库的字符集
            *3.CREATE DATABASE IF NOT EXISTS 数据库名 CHARACTER SET '';
                如果要创建的数据库不存在则创建成功，如果存在则失败，但不会报错
        (10)创建表
            查看表结构
                    SESC 表名;
            查看创建表的语句结构
                    SHOW CREATE TABLE 表名;
            *1.方式一：
                    需要用户具备创建表的权限
                    CREATE IF NOT EXISTS TABLE 表名(
                        字段名 数据类型,
                        字段名 数据类型,
                        ...,
                        ...,
                        ...
                    )CHARACTER SET '';指定字符集可以省略
            *2.方式二：
                    基于现有的表，复制查询的表结构和表数据
                    CREATE TABLE 表名1 AS SELECT 字段名 FROM 表名2;
        (11)修改表
            *1.添加字段：
                {1}默认添加到表中最后一个字段的位置：
                        ALTER TABLE 表名 ADD 字段名 数据类型;
                {2}添加到表中第一个字段的位置：
                        ALTER TABLE 表名 ADD 字段名 数据类型 FIRST;
                {3}添加到表中某个字段后的位置：
                        ALTER TABLE 表名 ADD 字段名1 数据类型 AFTER 字段名2;
            *2.修改一个字段：数据类型、长度、默认值等
                ALTER TABLE 表名 MODIFY 字段名 数据类型 DEFAULT '';
            *3.重命名一个字段
                ALTER TABLE 表名 CHANGE 被修改字段名 修改后的字段名 数据类型;
            *4.删除一个字段
                ALTER TABLE 表名 DROP COLUMN 字段名;
            *5.重命名表
                RENAME TABLE 被修改的表名 TO 修改后的表名;
            *6. 删除表
                DROP TABLE IF EXISTS 表名;
            *7.清空表
                TRUNCATE TABLE 表名;   一旦执行此操作，表中数据是不能回滚的
                DELETE FROM:一旦执行此操作，数据可以实现回滚
六、基本规则
    1.每条命令以;或\g或\G结束
    2.关键字不能被缩写也不能分行
    3.关于标点符号
        (1)必须保证所有括号()/单引号''/双引号""是成对结束的
        (2)必须使用英文状态下的半角输入方式
        (3)字符串型和日期时间类型的数据可以使用单引号''表示
        (4)列的别名，尽量别使用双引号""，而且不建议省略as
    4.SQL大小写规范
        (1)MySQL在windows环境下大小写不敏感
        (2)MySQL在linux环境下大小写敏感
    5.SQL书写规范
        (1)数据库名、表名、表别名、字段名、字段别名等都小写
        (2)SQL关键字、函数名、绑定变量等都大写
    6.注释
        (1)#  单行注释
        (2)/*
            */  多行注释
        (3)-- 单行注释，--后需要加空格
    7.

七、单行函数
    (一)常用函数
        ![1](./MySQL_pic/MySQL%E5%B8%B8%E7%94%A8%E5%87%BD%E6%95%B0.PNG)
        ![1](./MySQL_pic/MySQL%E5%B8%B8%E7%94%A8%E5%87%BD%E6%95%B02.PNG)
        ![1](./MySQL_pic/MySQL%E5%B8%B8%E7%94%A8%E5%87%BD%E6%95%B03.PNG)
        ![1](./MySQL_pic/MySQL%E5%B8%B8%E7%94%A8%E5%87%BD%E6%95%B04.PNG)
        ![1](./MySQL_pic/MySQL%E5%B8%B8%E7%94%A8%E5%87%BD%E6%95%B05.PNG)
    (二)字符串函数
        ![1](./MySQL_pic/%E5%AD%97%E7%AC%A6%E4%B8%B2%E5%87%BD%E6%95%B01.PNG)
    (三)时间日期函数
        1.获取日期时间
            ![1](./MySQL_pic/%E6%97%B6%E9%97%B4%E5%87%BD%E6%95%B0.PNG)
        2.日期与时间戳的转换
            ![1](./MySQL_pic/%E6%97%B6%E9%97%B4%E5%87%BD%E6%95%B01.PNG)
        3.获取月份、星期、星期数、天数等函数
            ![1](./MySQL_pic/%E6%97%B6%E9%97%B4%E5%87%BD%E6%95%B03.PNG)
        4.时间和秒钟转换的函数
            ![1](./MySQL_pic/%E6%97%B6%E9%97%B4%E5%87%BD%E6%95%B04.PNG)
    (四)流程控制函数
        ![1](./MySQL_pic/%E6%B5%81%E7%A8%8B%E6%8E%A7%E5%88%B6%E5%87%BD%E6%95%B0.PNG)
    (五)加密与解密函数
        ![1](./MySQL_pic/%E5%8A%A0%E5%AF%86%E4%B8%8E%E8%A7%A3%E5%AF%86%E5%87%BD%E6%95%B0.PNG)
        #注意点：
            1.PASSWORD()加密函数在MySQL8.0中被弃用
            2.MD5()和SHA()加密函数是不可逆的，只能加密不能解密
            3.SHA()加密函数比MD5()加密函数安全
    (六)MySQL信息函数
        ![1](./MySQL_pic/MySQL%E4%BF%A1%E6%81%AF%E5%87%BD%E6%95%B0.PNG)
    (七)其他函数
        ![1](./MySQL_pic/%E5%85%B6%E4%BB%96%E5%87%BD%E6%95%B0.PNG)
        #注意点
            1.如果FORMAT(value,n)参数n小于或等于0，则只保留整数部分

八、多行函数(聚合函数)
    1.AVG()平均函数
    2.SUM()总数函数
    3.MAX()求最大的函数
    4.MIN()求最小的函数
    5.COUNT():计算指定字段在查询结构中出现的个数
    #注意点：
        (1)如果需要统计表中的记录数，COUNT(*)/COUNT(1)/COUNT(具体字段)哪一个效率高
            *1.如果使用MyISAM存储引擎，效率相同
            *2.如果使用的是InnoDB存储引擎  
                COUNT(*)=COUNT(1)>COUNT(具体字段)

九、SQL语句的执行过程
    FROM...--> ON --> (LEFT/RIGHT JOIN) --> WHERE --> GROUP BY --> HAVING --> SELECT --> DISTINCT --> ORDER BY --> LIMIT

十、数据类型
    ![1](./MySQL_pic/MySQL%E7%9A%84%E6%95%B0%E6%8D%AE%E7%B1%BB%E5%9E%8B.PNG)
    1.整型
        ![1](./MySQL_pic/%E6%95%B4%E5%BD%A2%E6%95%B0%E6%8D%AE%E7%B1%BB%E5%9E%8B.PNG)
        (1)声明指定位宽配合ZEROFILL强制显示指定位数，不足补0占位，超过正常显示；使用ZEROFILL的字段自动添加UNSIGNED
        (2)适用场景
            ![1](./MySQL_pic/%E6%95%B4%E5%BD%A2%E6%95%B0%E6%8D%AE%E7%B1%BB%E5%9E%8B%E9%80%82%E7%94%A8%E5%9C%BA%E6%99%AF.PNG)
    2.浮点型
        ![1](./MySQL_pic/%E6%B5%AE%E7%82%B9%E6%95%B0%E6%8D%AE%E7%B1%BB%E5%9E%8B.PNG)
    3.定点数类型
        ![1](./MySQL_pic/%E5%AE%9A%E7%82%B9%E6%95%B0.PNG)
    4.位类型
        ![1](./MySQL_pic/%E4%BD%8D%E7%B1%BB%E5%9E%8B.PNG)
    5.日期与时间类型
        ![1](./MySQL_pic/%E6%97%A5%E6%9C%9F%E4%B8%8E%E6%97%B6%E9%97%B4%E7%B1%BB%E5%9E%8B.PNG)
        (1)YEAR取值规则
            ![1](./MySQL_pic/YEAR%E5%8F%96%E5%80%BC%E8%A7%84%E5%88%99.PNG)
    6.文本字符串类型
        ![1](./MySQL_pic/%E6%96%87%E6%9C%AC%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%B1%BB%E5%9E%8B.PNG)
        (1)CHAR需要预先定义长度，否则默认长度为1个字符
        (2)VARCHAR需要预先定义长度，否则报错
        (3)CHAR和VARCHAR的使用场景
            ![1](./MySQL_pic/CHAR%E5%92%8CVARCHAR%E7%9A%84%E4%BD%BF%E7%94%A8%E5%9C%BA%E6%99%AF.PNG)
        (4)CHAR和VARCHAR在不同引擎下的性能
            ![1](./MySQL_pic/CHAR%E5%92%8CVARCHAR%E5%9C%A8%E4%B8%8D%E5%90%8C%E5%BC%95%E6%93%8E%E4%B8%8B%E7%9A%84%E6%80%A7%E8%83%BD.PNG)
    7.枚举类型
    8.集合类型
        ![1](./MySQL_pic/%E9%9B%86%E5%90%88%E7%B1%BB%E5%9E%8B.PNG)
        (1)集合类型可以包含0个或多个成员，成员的上限为64个
    9.二进制字符串类型
        ![1](./MySQL_pic/%E4%BA%8C%E8%BF%9B%E5%88%B6%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%B1%BB%E5%9E%8B.PNG)
        ![1](./MySQL_pic/%E4%BA%8C%E8%BF%9B%E5%88%B6%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%B1%BB%E5%9E%8B2.PNG)
        (1)BINARY需要预先定义长度，否则默认长度为1个字节
        (2)VARBINARY需要预先定义长度，否则报错
    10.JSON类型

十一、事务
    1.COMMIT: 提交数据，一旦执行COMMIT，则数据永久的保存在数据库中，意味着数据不可以回滚
    2.ROLLBACK:回滚数据，一旦执行ROLLBACK，则可以实现数据的回滚，回滚到最近的一次COMMIT之后
    #注意点：
        *1.
            {1}DDL的操作一旦执行不可回滚，因为DDL操作执行后，一定会执行一次COMMIT，而此COMMIT操作不受SET autocommit = FALSE影响
            {2}DML默认情况下一旦执行也不可回滚。但是如果在执行DML前，执行了SET autocommit = FALSE，则执行的DML操作就可以实现回滚

十二、MySQL8新特性
    (一)DDL的原子化
        执行一旦报错就回滚

十三、约束
    (一)概念：对表中字端的限制
    (二)约束的分类
        角度：
            1.约束的字段的个数
                (1)单列约束
                (2)多列约束
            2.约束的作用范围
                (1)将此约束声明在对应字段的后面
                (2)在表中所有字段都声明完，在所有的字段后声明的约束
            3.约束的作用(或功能)
                (1)NOT NULL(非空约束)
                (2)UNIQUE(唯一性约束)
                (3)PRIMARY KEY(主键约束)
                    添加主键约束
                        *1.方式一：声明在"字段名 数据类型"后
                        *2.方式二：起别名方式，在所有声明的字段后声明"CONSTRAINT 别名 PRIMARY KEY(字段名)" 都是MySQL的主键名总是PRIMARY，就算起别名也不起作用
                        *3.方式三：ALTER TABLE 表名 ADD PRIMARY KEY (字段名);
                    <!-- 删除主键约束
                        ALTER TABLE 表名 DROP PRIMARY KEY
                     -->
                (4)FOREIGN KEY(外键约束)
                    添加外键约束
                        *1.方式一：创建从表时，声明在最后一个字段之后
                            {1}
                                CONSTRAINT 约束名 FOREIGN KEY (从表字段) REFERENCES 主表名(主表字段) ON UPDATE 等级 ON DELETE RESTRICT;
                            {2}
                                FOREIGN KEY (从表字段) REFERENCES 主表名(主表字段) ON UPDATE 等级 ON DELETE RESTRICT;
                        *2.方式二：
                            ALTER TABLE 从表名 ADD CONSTRAINT 约束名 FOREIGN KEY (从表字段) REFERENCES 主表名(主表字段) ON UPDATE 等级 ON DELETE RESTRICT;
                    删除外键约束
                        流程：
                        *1.查看约束名和删除外键约束
                            {1}查看某表约束名
                                SELECT * FROM information_schema.table_constraints WHERE table_name = '表名称';
                            {2}
                                ALTER TABLE 从表面 DROP FOREIGN KEY 外键约束名;
                        *2.查看索引名和删除索引
                            SHOW INDEX FROM 表名称;
                            ALTER TABLE 从表名 DROP INDEX 索引名;
                        <!-- 约束等级-->
                            ![1](./MySQL_pic/%E5%A4%96%E9%94%AE%E7%BA%A6%E6%9D%9F%E7%AD%89%E7%BA%A7.PNG)
                        <!-- 注意点
                            *1.如果要删除的表有外键约束，先删主表，再删从表
                            *2.如果要删除数据，先删从表中依赖主表的数据，然后才能删主表数据
                            *3.添加外键约束主表的被依赖字段必须是唯一性键列或主键列
                        -->
                (5)CHECK(检查约束)
                (6)DEFAULT(默认值约束)
                (7)AUTO_INCREMENT(自增约束)
                    添加自增约束
                        *1.方式一：ALTER TABLE 表名 MODIFY 字段名 数据类型 AUTO_INCREMENT;
                    删除自增约束
                        *1.方式一：ALTER TABLE 表名 MODIFY 字段名 数据类型;
                    <!-- 注意点
                        *1.一个表最多只能有一个自增长列
                        *2.自增长列约束的列必须是键列(主键列，唯一键列)
                        *3.自增约束的列的数据必须是整数类型
                        *4.如果自增列指定了0和null，会在当前最大值的基础上自增；如果自增列手动指定了具体值，直接赋值为具体值
                     -->

十四、视图(VIEW)
    (一)创建视图
        1.CREATE VIEW 视图名称 AS 查询语句;
            针对单表：
                CREATE VIEW 视图名称 AS SELECT 字段名 FROM 表名;
            针对多表：
                CREATE VIEW 视图名称 AS SELECT 字段名 FROM 表名 JOIN 表名 ON 联表条件;
        2.基于视图创建视图
             CREATE VIEW 视图名称2 AS SELECT 字段名 FROM 视图名称1;
        3.利用视图对数据进行格式化
            CREATE VIEW 视图名称 AS SELECT CONCAT(字段名,字段名) FROM 表名 JOIN 表名 ON 联表条件;
    (二)查询视图
        1.SELECT 字段名 FROM 视图名;
    (三)查看视图
        1.查看数据库的表对象和视图对象：
            SHOW TABLES; //查询当前数据库所有表和视图
        2.查看视图的结构：
            DESCRIBE 视图名称;
        3.查看视图的属性信息：
            SHOW TABLE STATUS LIKE '视图名称';
        4.查看视图的详细定义信息：
            SHOW CREATE VIEW 视图名称;
    (四)更新视图中的数据
        1.插入数据
        2.删除数据
        3.修改数据
            UPDATE 视图名称 SET 字段名 = ... WHERE 字段名 = ...;
        <!-- 不可更新的视图 -->
            ![1](./MySQL_pic/%E4%B8%8D%E5%8F%AF%E6%9B%B4%E6%96%B0%E7%9A%84%E8%A7%86%E5%9B%BE.PNG)
    (五)修改视图
        1.
            CREATE OR REPLACE VIEW 视图名称 AS SELECT 字段名 FROM 表名;
        2.
            ALTER VIEW 视图名称 AS SELECT 字段名 FROM 表名;
    (六)删除视图
        1.
            DROP VIEW IF EXISTS 视图名称;
    (七)视图的优点
        1.操作简单
        2.减少数据冗余
        3.数据安全
        4.适应灵活多变的需求
        5.能够分解复杂的查询数据

十五、存储过程和存储函数
    {一}存储过程
        (一)创建
        <!-- 使用DILIMITER改变结束符号 -->
            DELIMITER //
            CREATE PROCEDURE 存储过程名(IN/OUT/INOUT 参数名 参数类型)
            BEGIN
                SELECT 字段名 INTO(使用INOUT需要使用此关键字) FROM ....
            END //
            DELIMITER ;
        (二)调用存储过程
            1.IN或OUT
                SET @变量名 = ... ;
                CALL 存储过程名(OUT:@参数名/IN或INOUT:参数值或者@变量名);
    {二}存储函数
        (一)创建
            ![1](./MySQL_pic/%E5%87%BD%E6%95%B0%E6%8A%A5%E9%94%99%E5%A4%84%E7%90%86%E6%96%B9%E6%B3%95.PNG)
            <!-- 使用DILIMITER改变结束符号 -->
            DELIMITER //
            CREATE FUNCTION 存储函数名(参数名 参数类型,....)
            RETURN 返回值类型
            BEGIN
                RETURN (SELECT 字段名 INTO(使用INOUT需要使用此关键字) FROM ....)
            END //
            DELIMITER ;
        (二)调用存储过程
            SET @变量名 = ... ;
            SELECT 存储函数名(实参列表或@变量名);
    {三}存储函数和存储过程的区别
        1.返回值：
            存储过程有0个或多个返回值；存储函数只有一个
        2.应用场景
            存储过程一般用于更新；存储函数一般用于查询结果为一个值并返回时
        3.存储函数可以放在查询语句中使用，存储过程不行
    {四}存储过程和函数的查看、修改和删除
        (一)查看
            创建信息：
                SHOW CREATE PROCEDURE 存储过程名;
                SHOW CREATE PROCEDURE 存储函数名;
            状态信息：
                SHOW PROCEDURE STATUS;
                SHOW PROCEDURE STATUS LIKE '存储过程名';
                SHOW PROCEDURE STATUS LIKE '存储函数名';
            通用查看：
                SELECT * FROM information_schema.Routines WHERE ROUTINES_NAME = '存储过程名'('存储函数名');
                <!-- 如果存储过程和存储函数重名了 -->
                <!-- 注意类型填写的'FUNCTION'或'PROCEDURE'一定要大写 -->
                SELECT * FROM information_schema.Routines WHERE ROUTINES_NAME = '存储过程名'('存储函数名') AND ROUTINE_TYPE = 'FUNCTION'('PROCEDURE');
        (二)修改
            修改特性
                ALTER PROCEDURE 存储过程名(存储函数名) 权限... COMMENT '注释信息';
        (三)删除
            DROP FUNCTION IF EXISTS 存储过程名(存储函数名);
    {五}存储过程的优点和缺点
        (一)优点
            1.存储过程可以一次编译多次使用
            2.可以减少开发工作量
            3.存储过程的安全性强
            4，可以减少网络传输量
            5.良好的封装性
        (二)缺点
            1.可移植性差
            2.调试困难
            3.存储过程的版本管理很困难
            4.它不适合高并发的场景

十六、变量、流程控制和游标
    {一}变量
        (一)系统变量
            1.全局系统变量GLOBAL
            2.会话系统变量SESSION
        <!--  -->
        <!-- 查看所有全局变量 -->
            SHOW GLOBAL VARIABLES;
        <!-- 查看所有会话变量 -->
            SHOW SESSION VARIABLES;
            SHOW VARIABLES;
        <!-- 查看满足条件的部分系统变量 -->
            SHOW GLOBAL VARIABLES LIKE '%标识符%';
        <!-- 查看满足条件的部分会话变量 -->
            SHOW SESSION VARIABLES LIKE '%标识符%';
        <!-- 查看指定的系统变量 -->
            SELECT @@global.变量名;
            3.使用
                *1.全局系统变量
                    SET @@global.变量名 = 变量值;
                    或
                    SET GLOBAL 变量名 = 变量值;
                *2.会话系统变量
                    SET @@session.变量名 = 变量值;
                    或
                    SET SESSION 变量名 = 变量值;
        (二)用户自定义变量
            1.会话用户变量(使用@开头)
                (1)变量的定义
                    SET @会话用户变量 = 值;
                    或
                    SELECT 表达式 INTO @会话用户变量 [FROM 等子句];
                    或
                    SELECT @会话用户变量 := 表达式 [FROM 等子句];
                (2)作用域为当前会话
            2.局部变量
                (1)变量的定义
                    DELIMITER //
                    CREATE FUNCTION(PROCEDURE) 存储函数(存储过程)名((IN/OUT/INOUT)参数名 参数类型,....)
                    RETURN 返回值类型
                    BEGIN
                        <!-- DECLARE 局部变量名 数据类型 DEFAULT 默认值(没有默认值默认为NULL); -->
                        RETURN (SELECT 字段名 INTO(使用INOUT需要使用此关键字) FROM ....)
                    END //
                    DELIMITER ;
                (2)变量的定义的条件
                    *1.使用DECLARE声明
                    *2.声明在BEGIN...END中(存储过程、存储函数中)
                    *3.DECLARE的方式声明的局部变量必须声明在BEGIN中的首行位置
                (2)作用域为存储过程和存储函数
    {二}流程控制
        (一)条件判断语句：IF语句和CASE语句
            1.IF语句
                IF 表达式 THEN 操作1;
                ELSEIF 表达式2 THEN 操作2;
                ...
                ELSE 操作N;
                END IF;
            2.CASE语句
                CASE 
                WHEN 条件1 THEN 结果1或语句1(如果是语句需要加分号)
                WHEN 条件2 THEN 结果2或语句2(如果是语句需要加分号)
                ELSE 结果n或语句n(如果是语句需要加分号)
                END [CASE](如果是放在BEGIN...END中需要加上CASE，如果放在SELECT后面不需要)
        (二)循环语句：LOOP、WHILE和REPEAT语句
            1.LOOP语句
                [loop_label:] LOOP
                    循环执行的语句
                    使用LEAVE结束循环;
                END LOOP[loop_label  ]
            2.WHILE语句
                [while_lable:] WHILE 循环条件 DO
                    循环体
                END WHILE [while_lable:]
            3.REPEAT语句
                [repeat_lable:] REPEAT
                    循环体语句;
                    UNTIL 结束循环的条件表达式;
                END REPEAT [repeat_lable:]
        (三)跳转语句：ITERATE和LEAVE语句
    {三}游标
        1.游标的使用
            *1.声明
                DECLARE 游标名 CURSOR FOR 结果集名或查询语句;
            *2.打开游标
                OPEN 游标名;
            *3.使用游标
                FETCH 游标名 INTO 字段名1,...;
            *4.关闭游标
                CLOSE 游标名;
        2.注意点
            <!-- 游标必须在声明处理程序之前被声明，并且变量和条件还必须在声明游标或处理程序之前被声明 -->

十七、定义条件和处理程序
    {一}定义条件
       (一)定义
        1.使用MySQL_error_code
            DECLARE 条件名 CONDITION FOR 错误码;
        2.使用sqlstate_value
            DECLARE 条件名 CONDITION FOR SQLSTATE '错误码';
    {二}定义处理程序
        (一)定义
            DECLARE 处理方式 HANDLER FOR 错误类型 处理语句;
        (二)处理方式
            (1)CONTINUE
            (2)EXIT
            (3)UNDO(MySQL暂时不支持)
        (三)错误类型
            (1)SQLSTATE '字符串错误码'
            (2)MySQL_error_code
            (3)错误名称
            (4)SQLWARNING:匹配所有以01开头的SQLSTATE错误代码
            (5)NOT FOUND:匹配所有以02开头的SQLSTATE错误代码
            (6)SQLEXCEPTION:匹配所有没有被SQLWARNING或NOT FOUND捕获的SQLSTATE错误代码

十八、触发器
    {一}触发器的使用
        1.语法结构：
            CREATE TRIGGER 触发器名称 {BEFORE|AFTER} {INSERT|UPDATE|DELETE} ON 表名 FOR EACH ROW 触发器执行的语句块;

十九、MySQL8.0的其他新特性
    {一}窗口函数
        (一)窗口函数的使用
            1.语法结构
                函数 OVER ([PARTITION BY 字段名 ORDER BY 字段名 ASC|DESC])
                或者
                函数 OVER 窗口名 ... WINDOW 窗口名 AS([PARTITION BY 字段名 ORDER BY 字段名 ASC|DESC])
            2.窗口函数的种类
                [1](./MySQL_pic/%E7%AA%97%E5%8F%A3%E5%87%BD%E6%95%B0.PNG)
    {二}公用表表达式
        (一)公用表表达式的使用
            WITH 公用表表名 AS (子查询语句)
        (二)递归公用表表达式
            WITH RECURSIVE 公用表表名 AS (子查询语句) SELECT|DELETE|UPDATE 语句;