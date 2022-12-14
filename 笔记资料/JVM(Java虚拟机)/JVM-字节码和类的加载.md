<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

<!-- code_chunk_output -->

- [一、Class文件结构](#一class文件结构)
  - [概述](#概述)
    - [字节码文件的跨平台性](#字节码文件的跨平台性)
    - [java的前端编译器](#java的前端编译器)
    - [透过字节码指令看代码细节](#透过字节码指令看代码细节)
  - [虚拟机的基石：Class文件](#虚拟机的基石class文件)
  - [Class文件结构](#class文件结构)
    - [魔数：Class文件的标志](#魔数class文件的标志)
    - [魔数：Class文件版本号](#魔数class文件版本号)
    - [常量池：存放所有常量](#常量池存放所有常量)
      - [常量池计数器](#常量池计数器)
      - [常量池表](#常量池表)
        - [字面量和符号引用](#字面量和符号引用)
        - [常量类型和结构](#常量类型和结构)
    - [访问标识](#访问标识)
    - [类索引、父类索引、接口索引集合](#类索引父类索引接口索引集合)
    - [字段表集合](#字段表集合)
      - [字段计数器](#字段计数器)
      - [字段表](#字段表)
    - [方法表集合](#方法表集合)
      - [方法计数器](#方法计数器)
      - [方法表](#方法表)
    - [属性表集合](#属性表集合)
      - [属性计数器](#属性计数器)
      - [属性表](#属性表)
        - [方法里的属性表](#方法里的属性表)
    - [小结](#小结)
  - [使用javap指令解析Class文件](#使用javap指令解析class文件)
    - [解析字节码的作用](#解析字节码的作用)
    - [javac -g操作](#javac--g操作)
    - [javap的用法](#javap的用法)
    - [使用举例](#使用举例)
    - [总结](#总结)
- [二、字节码指令集与解析举例](#二字节码指令集与解析举例)
  - [概述](#概述-1)
    - [执行模型](#执行模型)
    - [字节码与数据类型](#字节码与数据类型)
    - [指令分类](#指令分类)
      - [加载与存储指令](#加载与存储指令)
        - [复习：再谈操作数栈与局部变量表](#复习再谈操作数栈与局部变量表)
        - [局部变量压栈指令](#局部变量压栈指令)
        - [常量入栈指令](#常量入栈指令)
        - [出栈装入局部变量表指令](#出栈装入局部变量表指令)
      - [算数指令](#算数指令)
        - [所有算数指令](#所有算数指令)
        - [关于++运算符](#关于运算符)
        - [比较指令的说明](#比较指令的说明)
      - [类型转换指令](#类型转换指令)
        - [宽化类型转换](#宽化类型转换)
        - [窄化类型转换](#窄化类型转换)
      - [对象的创建与访问指令](#对象的创建与访问指令)
        - [创建指令](#创建指令)
        - [字段访问指令](#字段访问指令)
        - [数组操作指令](#数组操作指令)
        - [类型检查指令](#类型检查指令)
      - [方法调用与返回指令](#方法调用与返回指令)
        - [方法调用指令](#方法调用指令)
        - [返回指令](#返回指令)
      - [操作数栈管理指令](#操作数栈管理指令)
      - [控制转移指令](#控制转移指令)
        - [条件跳转指令](#条件跳转指令)
        - [比较条件跳转指令](#比较条件跳转指令)
        - [多条件分支跳转指令](#多条件分支跳转指令)
        - [无条件跳转指令](#无条件跳转指令)
      - [异常处理指令](#异常处理指令)
        - [抛出异常指令](#抛出异常指令)
        - [异常处理与异常表](#异常处理与异常表)
      - [同步控制指令](#同步控制指令)
        - [方法级的同步](#方法级的同步)
        - [方法内指定指令序列的同步](#方法内指定指令序列的同步)
- [三、类的加载过程详解](#三类的加载过程详解)
  - [概述](#概述-2)
  - [过程一：Loading(加载)阶段](#过程一loading加载阶段)
    - [加载完成的操作](#加载完成的操作)
    - [二进制流的获取方式](#二进制流的获取方式)
    - [类模型与Class实例的位置](#类模型与class实例的位置)
    - [数组类的加载](#数组类的加载)
  - [过程二：Linking(链接)阶段](#过程二linking链接阶段)
    - [Verification(验证)](#verification验证)
    - [Preparation(准备)](#preparation准备)
    - [Resolution(解析)](#resolution解析)
  - [过程三：Initialization(初始化)阶段](#过程三initialization初始化阶段)
    - [static与final的搭配问题](#static与final的搭配问题)
    - [\< clinit \>()的线程安全性](#-clinit-的线程安全性)
    - [类的初始化情况：主动使用vs被动使用](#类的初始化情况主动使用vs被动使用)
  - [过程四：类的Using(使用)](#过程四类的using使用)
  - [过程五：类的Unloading(卸载)](#过程五类的unloading卸载)
    - [回顾：方法区的垃圾回收](#回顾方法区的垃圾回收)
- [四、再谈类的加载器](#四再谈类的加载器)
  - [概述](#概述-3)
    - [大厂面试题](#大厂面试题)
    - [类加载的分类](#类加载的分类)
    - [类加载器的必要性](#类加载器的必要性)
    - [命名空间](#命名空间)
    - [类加载机制的基本特征](#类加载机制的基本特征)
  - [复习：类的加载器分类](#复习类的加载器分类)
    - [引导类加载器](#引导类加载器)
    - [拓展类加载器](#拓展类加载器)
    - [系统类加载器](#系统类加载器)
    - [用户自定义类加载器](#用户自定义类加载器)
  - [测试不同的类加载器](#测试不同的类加载器)
  - [ClassLoader源码分析](#classloader源码分析)
    - [ClassLoader的主要方法](#classloader的主要方法)
    - [SecureClassLoader与URLClassLoader](#secureclassloader与urlclassloader)
    - [ExtClassLoader与AppClassLoader](#extclassloader与appclassloader)
    - [Class.forname()与ClassLoader.loadClass()](#classforname与classloaderloadclass)
  - [双亲委派模型](#双亲委派模型)
    - [定义与本质](#定义与本质)
    - [优势与劣势](#优势与劣势)
    - [破坏双亲委派机制](#破坏双亲委派机制)
      - [破坏双亲委派机制1](#破坏双亲委派机制1)
      - [破坏双亲委派机制2](#破坏双亲委派机制2)
      - [破坏双亲委派机制3](#破坏双亲委派机制3)
    - [热替换的实现](#热替换的实现)
  - [沙箱安全机制](#沙箱安全机制)
    - [JDK1.0时期](#jdk10时期)
    - [JDK1.1时期](#jdk11时期)
    - [JDK1.2时期](#jdk12时期)
    - [JDK1.6时期](#jdk16时期)
  - [自定义类的加载器](#自定义类的加载器)
    - [实现方式](#实现方式)
  - [Java9新特性](#java9新特性)

<!-- /code_chunk_output -->

# 一、Class文件结构
## 概述
### 字节码文件的跨平台性
>>> ![1](JVM_pic-mid/JVM01.PNG)
### java的前端编译器
>>> ![1](JVM_pic-mid/JVM02.PNG)
>>> ![1](JVM_pic-mid/JVM03.PNG)
>>> ![1](JVM_pic-mid/JVM04.PNG)
>>> ![1](JVM_pic-mid/JVM05.PNG)
>>> ![1](JVM_pic-mid/JVM06.PNG)
>>> ![1](JVM_pic-mid/JVM07.PNG)
>>> ![1](JVM_pic-mid/JVM08.PNG)
### 透过字节码指令看代码细节
>>> ![1](JVM_pic-mid/JVM09.PNG)
## 虚拟机的基石：Class文件
>>> ![1](JVM_pic-mid/JVM10.PNG)
>>> ![1](JVM_pic-mid/JVM11.PNG)
>>> ![1](JVM_pic-mid/JVM12.PNG)
>>> ![1](JVM_pic-mid/JVM13.PNG)
## Class文件结构
>> ![1](JVM_pic-mid/JVM14.PNG)
>> ![1](JVM_pic-mid/JVM15.PNG)
>> ![1](JVM_pic-mid/JVM16.PNG)
>> ![1](JVM_pic-mid/JVM17.PNG)
>> ![1](JVM_pic-mid/JVM18.PNG)
>> ![1](JVM_pic-mid/JVM19.PNG)
### 魔数：Class文件的标志
>>> ![1](JVM_pic-mid/JVM20.PNG)
### 魔数：Class文件版本号
>>> ![1](JVM_pic-mid/JVM21.PNG)
>>> ![1](JVM_pic-mid/JVM22.PNG)
### 常量池：存放所有常量
>>> ![1](JVM_pic-mid/JVM23.PNG)
>>> ![1](JVM_pic-mid/JVM25.PNG)
>>> ![1](JVM_pic-mid/JVM24.PNG)
#### 常量池计数器
>>>> ![1](JVM_pic-mid/JVM26.PNG)
#### 常量池表
>>>> ![1](JVM_pic-mid/JVM27.PNG)
>>>> ![1](JVM_pic-mid/JVM28.PNG)
##### 字面量和符号引用
>>>>> ![1](JVM_pic-mid/JVM29.PNG)
>>>>> ![1](JVM_pic-mid/JVM30.PNG)
>>>>> ![1](JVM_pic-mid/JVM31.PNG)
>>>>> ![1](JVM_pic-mid/JVM32.PNG)
##### 常量类型和结构
>>>>> ![1](JVM_pic-mid/JVM33.PNG)
>>>>> ![1](JVM_pic-mid/JVM34.PNG)
>>>>> ![1](JVM_pic-mid/JVM35.PNG)
>>>>> ![1](JVM_pic-mid/JVM36.PNG)
>>>>> ![1](JVM_pic-mid/JVM37.PNG)
### 访问标识
>>> ![1](JVM_pic-mid/JVM38.PNG)
>>> ![1](JVM_pic-mid/JVM39.PNG)
>>> ![1](JVM_pic-mid/JVM40.PNG)
### 类索引、父类索引、接口索引集合
>>> ![1](JVM_pic-mid/JVM41.PNG)
>>> ![1](JVM_pic-mid/JVM42.PNG)
### 字段表集合
>>> ![1](JVM_pic-mid/JVM43.PNG)
#### 字段计数器
>>> ![1](JVM_pic-mid/JVM44.PNG)
#### 字段表
>>> ![1](JVM_pic-mid/JVM45.PNG)
>>> ![1](JVM_pic-mid/JVM46.PNG)
>>> ![1](JVM_pic-mid/JVM47.PNG)
>>> ![1](JVM_pic-mid/JVM48.PNG)
>>> ![1](JVM_pic-mid/JVM49.PNG)
>>> ![1](JVM_pic-mid/JVM50.PNG)
### 方法表集合
>>> ![1](JVM_pic-mid/JVM51.PNG)
#### 方法计数器
>>>> ![1](JVM_pic-mid/JVM52.PNG)
#### 方法表
>>>> ![1](JVM_pic-mid/JVM53.PNG)
>>>> ![1](JVM_pic-mid/JVM54.PNG)
### 属性表集合
>>> ![1](JVM_pic-mid/JVM55.PNG)
#### 属性计数器
#### 属性表
>>>> ![1](JVM_pic-mid/JVM56.PNG)
>>>> ![1](JVM_pic-mid/JVM57.PNG)
>>>> ![1](JVM_pic-mid/JVM58.PNG)
##### 方法里的属性表
>>>>> ![1](JVM_pic-mid/JVM59.PNG)
>>>>> ![1](JVM_pic-mid/JVM60.PNG)
### 小结
## 使用javap指令解析Class文件
### 解析字节码的作用
>>> ![1](JVM_pic-mid/JVM61.PNG)
### javac -g操作
>>> ![1](JVM_pic-mid/JVM62.PNG)
### javap的用法
>>> ![1](JVM_pic-mid/JVM63.PNG)
>>> ![1](JVM_pic-mid/JVM64.PNG)
>>> ![1](JVM_pic-mid/JVM65.PNG)
### 使用举例
### 总结
>>> ![1](JVM_pic-mid/JVM66.PNG)
---
# 二、字节码指令集与解析举例
## 概述
>> ![1](JVM_pic-mid/JVM67.PNG)
### 执行模型
>>> ![1](JVM_pic-mid/JVM68.PNG)
### 字节码与数据类型
>>> ![1](JVM_pic-mid/JVM69.PNG)
>>> ![1](JVM_pic-mid/JVM70.PNG)
### 指令分类
>>> ![1](JVM_pic-mid/JVM71.PNG)
#### 加载与存储指令
>>>> ![1](JVM_pic-mid/JVM72.PNG)
##### 复习：再谈操作数栈与局部变量表
>>>>> ![1](JVM_pic-mid/JVM73.PNG)
>>>>> ![1](JVM_pic-mid/JVM74.PNG)
>>>>> ![1](JVM_pic-mid/JVM75.PNG)
>>>>> ![1](JVM_pic-mid/JVM76.PNG)
>>>>> ![1](JVM_pic-mid/JVM77.PNG)
>>>>> ![1](JVM_pic-mid/JVM78.PNG)
##### 局部变量压栈指令
>>>>> ![1](JVM_pic-mid/JVM79.PNG)
##### 常量入栈指令
>>>>> ![1](JVM_pic-mid/JVM80.PNG)
>>>>> ![1](JVM_pic-mid/JVM81.PNG)
>>>>> ![1](JVM_pic-mid/JVM82.PNG)
##### 出栈装入局部变量表指令
>>>>> ![1](JVM_pic-mid/JVM83.PNG)
#### 算数指令
>>>> ![1](JVM_pic-mid/JVM84.PNG)
>>>> ![1](JVM_pic-mid/JVM85.PNG)
>>>> ![1](JVM_pic-mid/JVM86.PNG)
##### 所有算数指令
>>>>> ![1](JVM_pic-mid/JVM87.PNG)
##### 关于++运算符
##### 比较指令的说明
>>>>> ![1](JVM_pic-mid/JVM87.PNG)
>>>>> ![1](JVM_pic-mid/JVM88.PNG)
#### 类型转换指令
>>>> ![1](JVM_pic-mid/JVM89.PNG)
##### 宽化类型转换
>>>>> ![1](JVM_pic-mid/JVM90.PNG)
>>>>> ![1](JVM_pic-mid/JVM91.PNG)
>>>>> ![1](JVM_pic-mid/JVM92.PNG)
##### 窄化类型转换
>>>>> ![1](JVM_pic-mid/JVM93.PNG)
>>>>> ![1](JVM_pic-mid/JVM94.PNG)
>>>>> ![1](JVM_pic-mid/JVM95.PNG)
#### 对象的创建与访问指令
>>>> ![1](JVM_pic-mid/JVM96.PNG)
##### 创建指令
>>>>> ![1](JVM_pic-mid/JVM97.PNG)
##### 字段访问指令
>>>>> ![1](JVM_pic-mid/JVM98.PNG)
>>>>> ![1](JVM_pic-mid/JVM99.PNG)
##### 数组操作指令
>>>>> ![1](JVM_pic-mid/JVM100.PNG)
>>>>> ![1](JVM_pic-mid/JVM101.PNG)
##### 类型检查指令
>>>>> ![1](JVM_pic-mid/JVM102.PNG)
#### 方法调用与返回指令
##### 方法调用指令
>>>>> ![1](JVM_pic-mid/JVM103.PNG)
##### 返回指令
>>>>> ![1](JVM_pic-mid/JVM104.PNG)
>>>>> ![1](JVM_pic-mid/JVM105.PNG)
#### 操作数栈管理指令
>>>> ![1](JVM_pic-mid/JVM106.PNG)
>>>> ![1](JVM_pic-mid/JVM107.PNG)
#### 控制转移指令
>>>> ![1](JVM_pic-mid/JVM108.PNG)
##### 条件跳转指令
>>>>> ![1](JVM_pic-mid/JVM109.PNG)
>>>>> ![1](JVM_pic-mid/JVM110.PNG)
##### 比较条件跳转指令
>>>>> ![1](JVM_pic-mid/JVM111.PNG)
##### 多条件分支跳转指令
>>>>> ![1](JVM_pic-mid/JVM112.PNG)
>>>>> ![1](JVM_pic-mid/JVM113.PNG)
##### 无条件跳转指令
>>>>> ![1](JVM_pic-mid/JVM114.PNG)
#### 异常处理指令
##### 抛出异常指令
>>>>> ![1](JVM_pic-mid/JVM115.PNG)
##### 异常处理与异常表
>>>>> ![1](JVM_pic-mid/JVM116.PNG)
#### 同步控制指令
>>>> ![1](JVM_pic-mid/JVM117.PNG)
##### 方法级的同步
>>>>> ![1](JVM_pic-mid/JVM118.PNG)
>>>>> ![1](JVM_pic-mid/JVM119.PNG)
##### 方法内指定指令序列的同步
>>>>> ![1](JVM_pic-mid/JVM120.PNG)
>>>>> ![1](JVM_pic-mid/JVM121.PNG)
---
# 三、类的加载过程详解
## 概述
>> ![1](JVM_pic-mid/JVM129.PNG)
>> ![1](JVM_pic-mid/JVM122.PNG)
## 过程一：Loading(加载)阶段
### 加载完成的操作
>>> ![1](JVM_pic-mid/JVM123.PNG)
### 二进制流的获取方式
>>> ![1](JVM_pic-mid/JVM124.PNG)
### 类模型与Class实例的位置
>>> ![1](JVM_pic-mid/JVM125.PNG)
>>> ![1](JVM_pic-mid/JVM126.PNG)
>>> ![1](JVM_pic-mid/JVM127.PNG)
### 数组类的加载
>>> ![1](JVM_pic-mid/JVM128.PNG)
## 过程二：Linking(链接)阶段
### Verification(验证)
>>> ![1](JVM_pic-mid/JVM130.PNG)
>>> ![1](JVM_pic-mid/JVM131.PNG)
>>> ![1](JVM_pic-mid/JVM132.PNG)
>>> ![1](JVM_pic-mid/JVM133.PNG)
>>> ![1](JVM_pic-mid/JVM134.PNG)
>>> ![1](JVM_pic-mid/JVM135.PNG)
### Preparation(准备)
>>> ![1](JVM_pic-mid/JVM136.PNG)
>>> ![1](JVM_pic-mid/JVM137.PNG)
### Resolution(解析)
>>> ![1](JVM_pic-mid/JVM138.PNG)
>>> ![1](JVM_pic-mid/JVM139.PNG)
>>> ![1](JVM_pic-mid/JVM140.PNG)
>>> ![1](JVM_pic-mid/JVM141.PNG)
## 过程三：Initialization(初始化)阶段
>> ![1](JVM_pic-mid/JVM142.PNG)
### static与final的搭配问题
>>> ![1](JVM_pic-mid/JVM143.PNG)
### < clinit >()的线程安全性
>>> ![1](JVM_pic-mid/JVM144.PNG)
### 类的初始化情况：主动使用vs被动使用
>>> ![1](JVM_pic-mid/JVM145.PNG)
>>> ![1](JVM_pic-mid/JVM146.PNG)
>>> ![1](JVM_pic-mid/JVM147.PNG)
## 过程四：类的Using(使用)
>> ![1](JVM_pic-mid/JVM148.PNG)
## 过程五：类的Unloading(卸载)
>> ![1](JVM_pic-mid/JVM149.PNG)
>> ![1](JVM_pic-mid/JVM150.PNG)
>> ![1](JVM_pic-mid/JVM151.PNG)
>> ![1](JVM_pic-mid/JVM153.PNG)
### 回顾：方法区的垃圾回收
>>> ![1](JVM_pic-mid/JVM152.PNG)
---
# 四、再谈类的加载器
## 概述
>> ![1](JVM_pic-mid/JVM154.PNG)
### 大厂面试题
### 类加载的分类
>>> ![1](JVM_pic-mid/JVM155.PNG)
### 类加载器的必要性
>>> ![1](JVM_pic-mid/JVM156.PNG)
>>> ![1](JVM_pic-mid/JVM157.PNG)
### 命名空间
>>> ![1](JVM_pic-mid/JVM158.PNG)
### 类加载机制的基本特征
>>> ![1](JVM_pic-mid/JVM159.PNG)
## 复习：类的加载器分类
>> ![1](JVM_pic-mid/JVM160.PNG)
>> ![1](JVM_pic-mid/JVM161.PNG)
>> ![1](JVM_pic-mid/JVM162.PNG)
### 引导类加载器
>>> ![1](JVM_pic-mid/JVM163.PNG)
>>> ![1](JVM_pic-mid/JVM164.PNG)
>>> ![1](JVM_pic-mid/JVM165.PNG)
### 拓展类加载器
>>> ![1](JVM_pic-mid/JVM166.PNG)
### 系统类加载器
>>> ![1](JVM_pic-mid/JVM167.PNG)
### 用户自定义类加载器
>>> ![1](JVM_pic-mid/JVM168.PNG)
## 测试不同的类加载器
>> ![1](JVM_pic-mid/JVM169.PNG)
>> ![1](JVM_pic-mid/JVM170.PNG)
>> ![1](JVM_pic-mid/JVM171.PNG)
## ClassLoader源码分析
>> ![1](JVM_pic-mid/JVM172.PNG)
### ClassLoader的主要方法
>> ![1](JVM_pic-mid/JVM173.PNG)
>> ![1](JVM_pic-mid/JVM174.PNG)
>> ![1](JVM_pic-mid/JVM175.PNG)
### SecureClassLoader与URLClassLoader
>>> ![1](JVM_pic-mid/JVM176.PNG)
>>> ![1](JVM_pic-mid/JVM177.PNG)
### ExtClassLoader与AppClassLoader
>>> ![1](JVM_pic-mid/JVM178.PNG)
>>> ![1](JVM_pic-mid/JVM179.PNG)
### Class.forname()与ClassLoader.loadClass()
>>> ![1](JVM_pic-mid/JVM180.PNG)
## 双亲委派模型 
### 定义与本质
>>> ![1](JVM_pic-mid/JVM181.PNG)
>>> ![1](JVM_pic-mid/JVM182.PNG)
>>> ![1](JVM_pic-mid/JVM183.PNG)
### 优势与劣势
>>> ![1](JVM_pic-mid/JVM184.PNG)
>>> ![1](JVM_pic-mid/JVM185.PNG)
>>> ![1](JVM_pic-mid/JVM186.PNG)
### 破坏双亲委派机制
#### 破坏双亲委派机制1
>>>> ![1](JVM_pic-mid/JVM187.PNG)
#### 破坏双亲委派机制2
>>>> ![1](JVM_pic-mid/JVM188.PNG)
>>>> ![1](JVM_pic-mid/JVM189.PNG)
#### 破坏双亲委派机制3
>>>> ![1](JVM_pic-mid/JVM190.PNG)
>>>> ![1](JVM_pic-mid/JVM191.PNG)
### 热替换的实现
>>> ![1](JVM_pic-mid/JVM192.PNG)
>>> ![1](JVM_pic-mid/JVM193.PNG)
## 沙箱安全机制
>> ![1](JVM_pic-mid/JVM194.PNG)
### JDK1.0时期
>>> ![1](JVM_pic-mid/JVM195.PNG)
### JDK1.1时期
>>> ![1](JVM_pic-mid/JVM196.PNG)
### JDK1.2时期
>>> ![1](JVM_pic-mid/JVM197.PNG)
>>> ![1](JVM_pic-mid/JVM198.PNG)
### JDK1.6时期
>>> ![1](JVM_pic-mid/JVM199.PNG)
## 自定义类的加载器
>> ![1](JVM_pic-mid/JVM200.PNG)
>> ![1](JVM_pic-mid/JVM201.PNG)
### 实现方式
>>> ![1](JVM_pic-mid/JVM202.PNG)
>>> ![1](JVM_pic-mid/JVM203.PNG)
## Java9新特性
>> ![1](JVM_pic-mid/JVM204.PNG)
>> ![1](JVM_pic-mid/JVM205.PNG)
>> ![1](JVM_pic-mid/JVM206.PNG)
>> ![1](JVM_pic-mid/JVM207.PNG)
>> ![1](JVM_pic-mid/JVM208.PNG)
>> ![1](JVM_pic-mid/JVM209.PNG)
---