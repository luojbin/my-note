# █ Groovy

# 一. Groovy 与 Java

Groovy 是一种基于 JVM 的脚本语言, 与 JVM 语言的老大哥 JAVA 有着密切的联系, 因此 Groovy 与 Java 语法非常相似, 许多语法规则都是一样的

# 二. Groovy 基础



## 1. 基本语素

### 类型

基本类型(java8类+String), 引用类型

Gradle 预设了三个主要的类型, 对应三个主要的 gradle 脚本文件(`.gradle`)

- Project -> build.gradle
- Gradle -> init.gradle
- Settings -> settings.gradle

### 变量

groovy 同时支持动态类型和静态类型

```groovy
// 声明动态类型, 使用 def 关键字
def intVar = 123;
def douVar = 1.23;
def strVar = "string";

// 声明静态类型, 使用具体类名
int intVar2 = 123;
double douVar2 = 1.23;
String strVar2 = "String";
```

### 运算符

## 2. 流程控制

### 条件结构

#### if 分支

#### switch 分支

### 循环结构

#### for 循环

#### while 循环

#### do…while 循环

## 3. 方法

## 4. 异常处理

## 5. 面向对象

### 继承 extends

### 实现 implement

### 内部类 

### 泛型

# 三. Groovy 特性

Groovy 在 java 基础上提供了很多新的特性, 使得代码编写更加容易

## 1. 一切都是对象

## 2. 正则表达式

## 3. 文件 IO

## 4. 特征 trait

## 5. 面向对象

## 6. 泛型

## 7. 闭包

类似 lambda 表达式, 是一段代码块

闭包内使用 `${变量名}` 引用外部变量或闭包参数

## 8. 集合