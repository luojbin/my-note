# JavaScript 面向对象编程

## 1. 创建对象

### 1.1. json 创建对象

### 1.2. Object 创建对象

## 2. JavaScript 对象的属性和方法


声明变量后, 直接在变量名后加属性定义语句

> var obj = {};
> obj.name = "Tom";

## 3. JavaScript 对象的特点

1. new Object() 和 JSON 语法创建的对象没有差别  
	JSON 语法简洁方便, 更加容易使用  
2. 对象可以随时添加属性  
	> 对象.属性 = 值
	
3. 不存在的属性, 值是 undefined  
	相当于 false, 利用这个特点可以检测属性是否存在

		if(! obj.age){
			console.log('没有age属性');	
		}

4. JS 对象可以随时删除属性, 执行后该对象没有该属性, 则返回true
	> delete 对象.属性

5. JS 对象没有封装性可言, 数据随时可以修改
6. JavaScript 不完全支持面向对象的三大特征(封装, 继承, 多态), 不是完整意义上的面向对象语言
7. JavaScript 对象相当于是一个散列表, 可以随时put进去键值对作为对象的属性
	为对象添加属性, 就是是添加了 key: value
	访问对象的属性, 就是是获取 value=get(key)

## 4. JS 对象的方法
js 对象的方法, 本质上也是一个属性, 这个属性的值是一个函数对象
> var obj = {};
> obj.name = 'tom';
> obj.who = function(){console.log(this.name);};

调用 JS 对象的方法
要在方法名后面加括号.
> 对象名.方法名();

若不添加括号, 则获取该属性所指定的函数对象
> 对象名.方法名;


JavaScript 所有方法都有返回值, 不指定的时候, 就是 undefined.
在调用 js 对象的方法时, 先将方法体执行, 而后返回该函数方法的返回值.

	var obj={};
	> undefined
	
	obj.name='tom';
	> "tom"
	
	obj
	> Object { name: "tom" }
	
	obj.who=function(){console.log(this.name)};
	> function obj.who()
	
	obj
	> Object { name: "tom", who: obj.who() }

	obj.who;
	> function obj.who()
	
	obj.who();
	tom 			//obj.who()方法体中的输出语句
	> undefined		//obj.who()方法的返回值 

	obj.who2=function(){return this.name;};
	> function obj.who2()
	
	obj
	> Object { name: "tom", who: obj.who(), who2: obj.who2() }
	
	obj.who2();
	> "tom"

可以将js 对象的方法删除, 像删除属性一样的删除
> delete 对象.方法名

可以修改 js 对象的方法, 像修改属性一样, 重新赋值
> 对象.方法名=function(){新方法体}

## JavaScript 方法没有重载
js 方法没有重载, 重复定义同名方法时, 会覆盖之前定义的方法
js 调用方法时不考虑参数列表, 只根据方法名绑定

## 使用 JSON 直接声明属性和方法
> var 对象名 = { 属性1:值1, 方法1:function(){方法体} }

## 默认的变量和函数
在网页中, 直接声明的变量和函数, 是 window 对象的属性和方法, 是全局变量.
 
