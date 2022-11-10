[toc]
# JavaSE
## 关于自增运算符++(自减--同理)
> ![1](JavaSE、SSM、框架高级_pic/1.PNG)
> ![1](JavaSE、SSM、框架高级_pic/2.PNG)
---
---
## 关于单例(Singleton)模式
> ![1](JavaSE、SSM、框架高级_pic/3.PNG)
> ![1](JavaSE、SSM、框架高级_pic/4.PNG)
> ![1](JavaSE、SSM、框架高级_pic/5.PNG)
### 饿汉式
#### 直接实例化饿汉式
>>>> ![1](JavaSE、SSM、框架高级_pic/6.PNG)
>>>> ![1](JavaSE、SSM、框架高级_pic/7.PNG)
#### 枚举式
>>>> ![1](JavaSE、SSM、框架高级_pic/8.PNG)
>>>> ![1](JavaSE、SSM、框架高级_pic/9.PNG)
#### 静态代码块饿汉式(适合复杂实例化)
>>>> ![1](JavaSE、SSM、框架高级_pic/10.PNG)
>>>> ![1](JavaSE、SSM、框架高级_pic/11.PNG)
>>>> ![1](JavaSE、SSM、框架高级_pic/12.PNG)
---
### 懒汉式
#### 线程不安全
>>>> ![1](JavaSE、SSM、框架高级_pic/13.PNG)
#### 解决线程不安全:使用同步锁
>>>> ![1](JavaSE、SSM、框架高级_pic/14.PNG)
#### 解决线程不安全:静态内部类形式
>>>> ![1](JavaSE、SSM、框架高级_pic/15.PNG)
---
---
## 关于类和其实例的初始化过程中，其成员变量(静态和非静态)、方法(静态和非静态)、代码块(静态和非静态)、构造器的先后执行顺序
>>> ![1](JavaSE、SSM、框架高级_pic/16.PNG)
>>> ![1](JavaSE、SSM、框架高级_pic/17.PNG)
>>> ![1](JavaSE、SSM、框架高级_pic/21.PNG)
>>> ![1](JavaSE、SSM、框架高级_pic/18.PNG)
>>> ![1](JavaSE、SSM、框架高级_pic/19.PNG)
>>> ![1](JavaSE、SSM、框架高级_pic/20.PNG)
---
---
## 方法的参数传递
>> ![1](JavaSE、SSM、框架高级_pic/22.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/23.PNG)
---
---
## 递归与迭代
>> ![1](JavaSE、SSM、框架高级_pic/24.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/25.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/26.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/27.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/28.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/29.PNG)
---
---
## 成员变量与局部变量
>> ![1](JavaSE、SSM、框架高级_pic/30.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/31.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/32.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/33.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/34.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/35.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/36.PNG)
---
---
## Spring Bean的作用域之间有什么区别
>> ![1](JavaSE、SSM、框架高级_pic/37.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/38.PNG)
---
---
## Spring支持的常用数据库事务传播属性和事务隔离级别
>> ![1](JavaSE、SSM、框架高级_pic/39.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/40.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/41.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/42.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/43.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/44.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/45.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/46.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/47.PNG)
---
---
## SpringMVC中处理post请求中文乱码问题
>> ![1](JavaSE、SSM、框架高级_pic/48.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/49.PNG)
---
---
## SpringMVC的工作流程
### 获取参数的过程
>>> ![1](JavaSE、SSM、框架高级_pic/50.PNG)
---
---
## MyBatis中实体类的属性名和表中的字段名不一样如何处理
### 写SQL语句时给字段起别名(别名与实体类属性名一致)
>>> ![1](JavaSE、SSM、框架高级_pic/51.PNG)
### 在MyBatis全局配置文件中开启驼峰命名规则
>>> ![1](JavaSE、SSM、框架高级_pic/52.PNG)
### 在Mapper映射文件中使用resultMap自定义映射规则
>>> ![1](JavaSE、SSM、框架高级_pic/53.PNG)
---
---
## Git分支相关命令
>> ![1](JavaSE、SSM、框架高级_pic/54.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/55.PNG)
---
---
## MySQL什么时候建索引
>> ![1](JavaSE、SSM、框架高级_pic/56.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/57.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/58.PNG)
---
---
## GC
>> ![1](JavaSE、SSM、框架高级_pic/59.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/60.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/63.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/61.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/62.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/64.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/65.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/66.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/67.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/68.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/69.PNG)
---
---
## 单点登录实现过程
>> ![1](JavaSE、SSM、框架高级_pic/70.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/71.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/72.PNG)
---
---
## 购物车实现过程
>> ![1](JavaSE、SSM、框架高级_pic/73.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/74.PNG)
---
---
## 消息队列在项目中的使用
>> ![1](JavaSE、SSM、框架高级_pic/75.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/76.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/77.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/78.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/79.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/80.PNG)
>> ![1](JavaSE、SSM、框架高级_pic/81.PNG)