# JavaScript 动态脚本语言

1. 概述
2. 三种调用方式
3. 基本API

## 一.概述
**JavaScript** 是嵌入在HTML中, 在浏览器中运行的脚本语言, 具有与Java, c语言类似的语法.

1. 一种网页编程技术, 用来向 HTML 页面添加交互行为
2. 直接嵌入 HTML 页面
3. 由浏览器解释执行代码, 不需进行预编译

#### JavaScript发展史
最早由网景公司在 Netscape 2.0 首先推出了 JavaScript, 当是命名参考了Java的名称
现在由 **ECMA** 组织维护 JavaScript 标准

#### JavaScript 特点
可以使用任何文本编辑工具辨析
由浏览器内置的JavaScript 引擎执行代码

- 解释执行:事先不编译, 逐行执行
- 基于对象:内置大量线程对象

适宜:

- 客户端数据机选
- 客户端表单合法性验证
- 浏览器事件的触发
- 网页特殊显示效果制作
- 服务器的异步数据提交

## 二.使用 JavaScript

### 1.事件定义式
- 在定义事件时直接写入JavaScript 脚本代码, 要用**双引号**把 JavaScript 语句括起来
- 事件: 是用户的操作(动作), 是 JavaScript 调用的时机
如单击事件, 双击事件...
> &lt;标签 **事件 = "JavaScript"** /&gt; 

		<input type="button" value="按钮1" onclick="alert('hello,tarena!');" />

### 2.嵌入式
- 在页面内任意位置, 嵌入 **&lt;script&gt; &lt;/script&gt;** 标签, 在标签中定义 JavaScript 函数

	- JavaScript 的函数都是公有的静态函数
	- JavaScript 的函数都有返回值, 返回值类型不用声明
	- JavaScript 中使用引号时, 单引号与双引号效果相同
	
> function 函数名(参数列表){函数体}
	
	//定义函数
	<script>
		function f2(){
			alert("hello 传奇");
		}
	</script>

	//调用函数
	<input type="button" value="按钮2" onclick="f2();" />
#### 嵌入式调用的第二种方式
嵌入式调用 JavaScript, 除了定义函数, 还可以直接写 JavaScript 代码.
- 直接写js代码, 此时的代码在页面加载的同时就将执行, 并且可以阻塞页面的后续加载


### 3.文件调用式

- 将 JavaScript 代码写入一个单独的.js文件, HTML 文件引用该 .js 文件
- js文件是纯文本文件, 不需要包含 &lt;script&gt; 标签, 直接书写 js 代码
- 引入文件时, 相当于把 JavaScript 代码复制到该位置

> &lt;script src="js文件路径"&gt; &lt;/script&gt; 

	<script src="demojs.js"></script>

#### script标签
1. 可以用来定义嵌入式 JavaScript 函数
2. 可以用来引用文件调用式 JavaScript 代码

- 若在同一个script标签中, 既引用了外部js文件, 又定义新的JavaScript函数代码, 则对内部函数的定义有严格要求
- 不建议在一个script标签中同时执行两种调用方式.

### 4.JavaScript 的代码错误
- JavaScript 是解释性代码, 若编写时代码错误, 编辑器中并无明显提示, 只有最后执行时, 页面中得不到理想效果.

1. **查看错误信息**
页面执行出错时, 可以在浏览器控制台查看错误信息
不管能否看懂, 都必须去看, 对于反复出现的错误要记住
**· IE:** 状态栏, 开发工具
**· Firefox, Chrome:** 错误控制台


2. **打桩**
隔一段代码, 输出一次当前信息, 看程序执行到什么地方出错
打桩还可跟踪程序执行的过程, 检验变量在当前语句是否正确

3. **排除法定位故障点**
每次注释掉一部分代码, 看代码是否还有问题
建议采用二分法, 每次注释一半的可疑代码

## 三.JavaScript 基本语法

### 1.JavaScript 的注释
JavaScript的注释方式与Java相同
> //单行注释
> /* 多行注释 */

### 2.语句
- 表达式, 关键字, 运算符组成
- 大小写敏感
- 使用分号或换行结束, 一行中有多个语句时不能省略分号
- 推荐加上分号, 减少错误和歧义

### 3.标识符
- 标识符

	- 由不以数字开头的字母,下划线,美元符号组成
	- 常用于标识函数,变量等名称
	- 见名知意,小驼峰命名法
	- JavaScript 有一些保留字,不可声明为标识符

### 4.变量
#### 声明变量
JavaScript 的变量没有类型, 称为弱类型语言, Java的变量有明确类型, 称为强类型语言
统一使用关键字 **var** 声明变量
变量没有类型, 但变量引用的数据是有类型的
> var x,y;

#### 变量初始化
使用 **=** 赋值, 未初始化的默认值为 **undefined**

### 5.数据类型
##### 特殊类型
- null: 空
- undefined: 未定义

##### 内置对象(基本类型)
- Number: 数字
- String: 字符串
- Boolean: 布尔
- Function: 函数
- Array: 数组

##### 外部对象
- window: 浏览器对象
- document: 文档对象

##### 自定义对象
- Object: 自定义对象

#### 类型转换
JavaScript 属于松散类型的程序语言
- 变量在声明是不需要指定数据类型
- 变量所引用的数据有类型
不同类型数据在计算过程中会自动进行转换

- 数字值 + 字符串: 数字转换为字符串
- 数字值 + 布尔值: true转换1, false转为0
- 字符串 + 布尔值: 布尔转换为字符串true或false
- 布尔值 + 布尔值: 布尔值转换为数值1或0进行计算

#### 强制转换函数
- toString( 表达式 )
所有数据类型都可以转换为String类型

- parseInt( 表达式 )
转换为整数, 若失败则返回 **NaN** ( not a number)

		console.log(parseInt("3.14"));	//3
		console.log(parseInt(3.14));	//3
		console.log(parseInt("good"));	//NaN
		console.log(parseInt(true));	//NaN

- parseFloat( 表达式 )
转换为浮点数, 若失败则返回 **NaN** ( not a number)

- typeOf( 表达式 )
查询当前类型

- isNaN( 表达式 )
判断被测表达式是不是一个数,
如果不是数则返回 true , 是一个数则返回 false
实际判断结果不太理想, 实际工作中通常使用正则表达式来判断

		console.log(isNaN(3.14));		//false
		console.log(isNaN("3.14"));		//false	
		console.log(isNaN("abc"));		//true
		console.log(isNaN(true));		//false
	
		//矛盾的情况, 空串非NaN, 解析结果却是NaN
		console.log(isNaN(""));			//false
		console.log(parseInt(""));		//NaN

### 6.运算符
JavaScript 的运算符, 与 Java 中的相似, 只有部分小区别
#### 6.1. 算术运算
- **+ 加 :** 可以表示数值的加法运算, 也可以用于字符串连接
- **- 减 :** 可以表示数值的减法运算, 也可以用于表示负数
- **乘 :** 同Java中乘法一样
- **/ 除 :** 整型数值相除可以得到浮点数
- **++ 递增 :** i++ 等价于 i = i + 1
- **-- 递减 :** i-- 等价于 i = i - 1

#### 6.2.关系运算
用于判断数据之间的大小关系, 关系表达式的值为boolean类型

- **&gt;**  大于
- **&lt;**  小于
- **=**     等于
- **!=**    不等于
- **&gt;=** 大于等于
- **&lt;=** 小于等于

#### 6.3.全等
JavaScript 中除了普通的双等号表示数值相等, 还可以用三等号表示全等
**全等**: 类型相同, 数值相同
> 变量1 === 变量2

**不全等**
> 变量1 !== 变量2

	console.log("运算符测试");
	var k = "5";
	var t = 5;
	console.log(k==t);	//true
	console.log(k===t);	//false

#### 6.4.逻辑运算
逻辑非 !
逻辑与 &&
逻辑或 ||

##### && 与 &
使用&&的时候, 
如果前面结果是false 或 空值, 则该语句短路, 不再执行后续语句
如果前面结果是true 或 非空值, 则该语句继续执行后续判断, 最终返回右侧语句的结果

使用&时, 
一旦遇到false 或 空值, 则该短路短路, 不再执行后续语句,返回0
如果语句执行完了都没有遇到 false 或 空值, 则返回1

需要确保两个检查方法都正确执行, 可以使用

#### 6.5.条件运算
条件运算, 即三目运算符
先计算布尔式的值, 如果为true, 则执行表达式1, 否则执行表达式2
> 布尔式 ? 表达式1 : 表达式2 

## 四.流程控制

### 1.分支结构
- if语句
- switch-case语句

### 2.循环结构
- for循环
- while循环
- do-while循环

### 3.JavaScript 中的条件表达式
JavaScript中的流程控制结构, 与Java中的基本相同
**区别:** 
Java 中的条件表达式必须返回布尔值
JavaScript 中的条件表达式可以返回任意类型的值

![](CSS_snap1.png)

 - 所有表示空的值, 都是false
 - 所有表示非空的值, 都是true

		var c = "false";
		if(c){
			console.log("c是true");
		}else{
			console.log("c是false");
		}

	可以使用短路与实现条件分支

		c && console.log("c是true");

##### 猜数字
![](web05_3.png)

#### 六.事件
### 1.单击事件

1. 弹出提示框
> alert('弹出框内容');

2. 控制台输出
> console.log("输出内容");

3. 获取外部对象
> document.getElementById("元素ID");

4. 获取对象的值
> 外部对象.value;

5. 输出内容
> 外部对象.innerHTML = 输出内容;

***
# day06

## 五.对象

### 一.String(手册)
- 和Java差不多

### 二.Number(*)
- toFixed(n)

### 三.数组(*)
- 如何创建数组
- 数组倒转方法
- 数组排序方法(*)

![](web06_1.png)

### 四.Math(手册)
- 和Java差不多

### 五.Date
1. 如何创建日期对象
2. 如何格式化日期对象
3. 如何读写时间分量

![](web06_2.png)

### 六.RegExp(***)
## 1.正则对象
- 如何创建正则对象
- test() ***
- exec()

![](web06_3.png)

## 2.字符串支持正则的方法(手册)
- replace()
- match()
- search()

# 七.Function对象(*)
JavaScript 不能重载, 但是支持多参数列表
建议声明参数, 参数名不可以用关键字

- arguments *
- eval *


![](web06_4.png)

匿名函数
全局函数

### 1.JavaScript对象概述
- 对象是 JavaScript 中最重要的API
- JavaScript 包含多种对象
	
	- 内置对象
	- 外部对象
	- 自定义对象

### 2.String
### 3.Number
> number对象.toFixed(小数位) 

### 4.Array
JavaScript 中的数组, 都相当于 Java 中的 Object 数组, 允许存有所有类型数组

任何方式创建的数组, 本质是一样的, 相当于Object 数组, 也是集合

### RegExp对象


	var reg = /^\d+$/ ;
	var reg = new RegExp("^\d+$");

校验正则表达式
> Reg对象.test(字符串)


### 6.正则表达式对象
#### 6.1.如何创建正则对象
创建正则表达式对象, 有两种方式, 可以设置工作模式
工作模式有三种
	
- 默认模式
- **i** 忽略大小写模式
忽略匹配中的大小写检测

- **g** 全局模式
设定当前匹配为全局模式
 
> var 变量名 = / 正则表达式 / 模式标记; 
> var 变量名 = new RegExp("正则表达式" [ , 模式标记 ] );

	var str = "you can you up , no can no bb";
	var reg = /no/;
		
#### 6.2. 检测str中是否包含与reg匹配的子串
> 正则对象.test(字符串)

	console.log(reg.test(str));
		
#### 6.3 exec()
提取匹配的子串, 返回格式为[正则表达式, index: 下标, input: 检验的字符串]
若无匹配的子串, 则返回 null

1) 普通模式, 只检验有无, 找到第一个就结束

	console.log(reg.exec(str));

2) 全局模式, 第N次调用, 则从str中找到第N个匹配的子串

	reg = /no/g;
	console.log(reg.exec(str));
	console.log(reg.exec(str));
	console.log(reg.exec(str));

***

# day07

# 外部对象
JavaScript 脚本语言, 可以访问操作浏览器对象, 这些对象是 JavaScript 脚本以外的东西, 称为**外部对象**.
外部对象是由浏览器提供的, 是一系列的API, 是一组规范和规则

- 接口:

	- 狭义: interface, 提供一些抽象的方法标准规范
	- 广义: 程序的定义/调用方式, 是一组标准规范

## 一.概述
### 1.1. BOM 浏览器对象
**Browser Object Model**: 浏览器对象模型, 用来访问和操纵浏览器窗口, 使 JavaScript 有能力与浏览器对话
浏览器是一个软件, 浏览器的开发人员按照面向对象思想, 把浏览器及其子功能模块视为对象.

- 通过使用 BOM, 可以移动窗口, 更改状态栏文本, 执行其他不与页面内容发生直接联系的操作
- 没有相关标准, 但被广泛支持



### 1.2. DOM 文档对象
**Document Object Model**: 文档对象模型, 用来操作文档
BOM 中最重要的一个部分, 代表整个网页.

- 定义了访问和操作 HTML 文档的标准方法
- 应用程序通过对 DOM 树的操作, 来实现对 HTML 文档数据的操作

![](web07_1.png)

## 二.window对象
表示浏览器窗口

- 所有 JavaScript 全局对象, 函数, 以及变量均自动成为 window 对象的成员

包含以下部分:

- history: 历史记录
- navigator: 浏览器相关嘻嘻
- document: 网页文档
- location: 地址
- screen: 当前屏幕对象

### 2.1. 对话框
#### alert
提示对话框, 显示给定字符串的提示信息
> alert( 提示信息 )

#### confirm
确认对话框, 显示给定字符串的提示信息, 让用户确认操作
按"确定"按钮返回true, 其他操作返回false
> confirm( 确认信息 )

	// 演示confirm 方法
	function f1(){
		var b = confirm("您确定要清空购物车?");
		if(b){
			console.log("购物车已清空");
		}
	}

### 2.2. 定时器
多用于网页动态时钟, 制作倒计时, 跑马灯效果等
启动定时器相当于启动了一个新的线程, 主线程在启动定时器线程后会继续执行后续命令, 主线程与定时器线程并发执行, 不会相互等待.

#### 2.2.1 周期性时钟
以一定的间隔执行代码, 循环往复

- **设置定时器**
给定执行语句 exp, 并设置时间间隔 time (毫秒), 将会周期性触发代码 exp
该方法会返回定时器对象的ID, 这个ID是定时器的唯一标识, 用来停止该定时器.
> setInterval( exp, time )

- **停止定时器**
通过定时器的 ID, 停止相应的定时器
> clearInterval( ID )

演示:

	function f2() {
		//启动周期性定时器, 每隔1000毫秒调用一次该函数
		var n = 5;
		//返回的ID是定时器的唯一标识, 用来停止该定时器
		var id = setInterval(function(){
			console.log("执行定时器");
			console.log(n--);
			if(n==0){
				//停止定时器
				clearInterval(id);
				//执行一次性的延迟命令
				console.log("Duang!");
			}
		}, 1000);
	}

##### 案例: 时钟
![](web07_2.png)
JavaScript 脚本:

	var id = null;
	function run(){
		//若id非空, 即定时器已启动, 不再启动新的定时器
		if(id){
			return;
		}
		id = setInterval(function(){
			//获得当前时间
			var time = new Date();
			//转换为本地格式
			var now = time.toLocaleTimeString();
			//将时间写入clock
			var clock = document.getElementById("clock");
			clock.innerHTML=now;
		}, 1000);
		
	}
	function pause(){
		clearInterval(id);
		//停止定时器时, 清空id, 以保证下次正常启动
		id = null;
	}
	
页面内容:

	<input type="button" value="run" onclick="run();" />
	<input type="button" value="pause" onclick="pause();" />  
	<p id="clock">当前时间</p>

#### 2.2.2 延迟器时钟
在一个设定的时间间隔之后执行代码, 而不是立即执行

- **设置延迟器**
给定执行语句 exp, 并设置延迟时间 time (毫秒), 延迟结束后触发代码 exp, 执行完毕后自动关闭
该方法会返回定时器对象的ID, 这个ID是定时器的唯一标识, 用来停止该定时器.
> setTimeout( exp, time )

- **停止延迟器**
通过定时器的 ID, 停止相应的定时器
> clearTimeout( ID )

演示:

	//一次性定时器
	//需要在两个方法里用到这个id,要设为全局变量
	var toId;
	function f3(){
		console.log("显示广告");
		//启动一次性定时器
		//推迟5000ms调用函数, 调用一次后自动结束
		toId = setTimeout(function(){
			console.log("自动关闭广告");
		}, 5000);
	}

	function f4(){
		console.log("取消关闭广告");
		//在一次性定时器正在运行, 还未结束时, 可以调用此方法手动提前停止
		clearTimeout(toId);
	}




##### 案例: 限时内撤销

![](web07_3.png)

JavaScript 脚本部分:

	//初始状态下没有发送消息.
	var id = null;
	
	function send(){
		//如果已经有发送中的消息, 则结束方法, 不再发送新消息.
		if(id){
			return;
		}
		//获取信息框
		var p = document.getElementById("statement");
		p.innerHTML = "正在发送...";
		//启动延迟器
		id = setTimeout(function(){
			p.innerHTML = "已发送.";
			//运行后清空id, 以便下次操作
			id = null;
		},3000);
	}
	
	function cancel(){
		//如果没有正在发送的消息, 则不进行撤销操作
		if(id){
			var p = document.getElementById("statement");
			clearTimeout(id);
			id = null;
			p.innerHTML = "已取消发送.";
		}
	}

页面内容部分:

	<input type="button" id="send" value="发送" onclick="send();"/>
	<input type="button" id="cancel" value="撤销" onclick="cancel();"/>
	<p id="statement">等待操作</p>

### 2.3. 子对象

#### location 对象

- href属性表示当前页面的网址, 常用于获取和改变当前浏览的网址, 与超链接相比更灵活, 能够在跳转之前进行一定的逻辑判断.
> location.href=网址

- 重载页面, 效果如同按下刷新按钮
> location.reload()

#### history 对象
包含用户在浏览器窗口中访问过的 URL 记录, 可以通过方法跳转到相应页面

- **forward()**: 前进, 访问下一个页面, 相当于按下浏览器的"前进"按钮.
- **back()**: 后退, 访问上一个页面, 相当于按下浏览器的"前进"按钮.
- **go(n)**: 前往, 访问历史中的一个页面, 相当于按下浏览器的n次的"前进"或"后退"的按钮.

#### screen 对象
包含有关客户端显示屏幕的信息, 常用于获取屏幕的分辨率, 色彩等

- **width / height**: 客户端屏幕尺寸
- **availWidth / availHeight**: 浏览器可用屏幕尺寸

#### navigator 对象
用于获取客户端浏览器和操作系统的信息

- **userAgent**: 获取浏览器相关信息

## 三.document 对象

### 3.1. DOM 概述

- 当 HTML 网页被加载到本地时, 浏览器会在本地内存中创建页面的文档对象模型, 称为 **DOM 树**, 其中每个子对象也称为树的**节点**.
- JavaScript 动态操作都是对 DOM 树中的节点对象进行操作, 而不是对 HTML 文件本身进行修改
- 通过可编程的对象模型, JavaScript 可以创建动态的 HTML
- JavaScript 能够实现:

	- 改变页面中所有 HTML 元素
	- 改变页面中所有 HTML 属性
	- 改变页面中所有 CSS 样式
	- 对页面中所有事件作出反应

![](web07_4.png)

### 3.2. 读写

#### 3.2.1 节点信息

- **nodeName**: 
对象节点的信息, 表示节点的名称

	- 元素节点: 标签名
	- 属性节点: 属性名
	- 文本节点: 永远是 #text
	- 文档节点: 永远是 #document

- **nodeType**: 
对象节点的信息, 表示该节点的类型, 用对应数字表示

		var p1 = document.getElementById("p1");
		console.log(p1.nodeName);	//p, 表示该节点为段落元素
		console.log(p1.nodeType);	//1, 表示该节点为元素节点 

#### 3.2.2 节点内容

- **innerHTML**
对象节点的内容, 包括其中的 HTML 标记, 重新赋值时新的 HTML 标记有效

- **innerText**
对象节点的内容, 忽略其中的 HTML 标记, 重新赋值时新的 HTML 标记被视为文本, 不会生效

		// 1) innerHTML
		var p2 = document.getElementById("p2");
		console.log(p2.innerHTML);
		p2.innerHTML="2.DOM提供了<u>查询</u>节点的方法";

		// 2) innerText
		var p3 = document.getElementById("p3");
		console.log(p3.innerText);
		p3.innerText="3.DOM提供了<b>增删</b>节点的方法";

#### 3.2.3 节点的值

除了label之外的表单控件都有值, input select textarea等

> 读: 节点.value
> 写: 节点.value = 新值

#### 3.2.4 节点属性

- **getAttribute**
根据属性名, 获取相应的属性值

- **setAttribute**
根据属性名, 设置相应的属性值

- **removeAttribute**
根据属性名, 删除相应的属性值

		// 1) 通过方法读写任何属性
		var img1 = document.getElementById("img1");
		console.log(img1.getAttribute("src"));
		img1.setAttribute("src","../images/02.jpg");
		img1.removeAttribute("src");

##### 案例: 轮播图片

![](web08_1.png)

样式与脚本

	<style>
		div {
			border:1px solid red;
			width:218px;
			height:218px;
			margin: 30px auto;
		}
		.hide {
			display:none;
		}
		.show {
			display: inline_block;
		}
	</style>
	<script>
		window.onload=function(){
			var n=0;
			setInterval(function(){
				n++;
				//获取所有图片
				var imgs = document.getElementsByTagName("img");
				//将他们都隐藏
				for(var i=0;i<imgs.length;i++){
					imgs[i].className = "hide";
				}
				//将下一个图片显示
				var next = n%imgs.length;
				imgs[next].className="show";
			},2000);	
		};
	</script>

页面内容

	<div>
		<img src="../images/01.jpg" />
		<img src="../images/02.jpg" class="hide"/>
		<img src="../images/03.jpg" class="hide"/>
		<img src="../images/04.jpg" class="hide"/>
		<img src="../images/05.jpg" class="hide"/>
		<img src="../images/06.jpg" class="hide"/>
	</div>

### 3.3. 查询
如果需要操作 HTML 元素, 必须先找到该元素的对应节点

#### 3.3.1. 通过 ID 查询
通过指定的 ID 来返回元素节点, ID 是元素的唯一标识, 能找到唯一的节点, 忽略文档的结构. 
如果 ID 错误, 则返回 null
> document.getElementById("元素ID")

#### 3.3.2. 通过层次 (节点关系) 查询
遵循文档的层次结构, 根据当前节点在文档中的位置, 可以查找 父/子 节点
若查询结果可能为复数, 要注意给该api加s

- **获取父节点**
获取当前节点的父级节点
每个节点仅有一个父节点, 该查询将返回一个节点
> 当前节点.parentNode

- **获取子节点**(含文本元素)
用这种方式获取的子节点, 包含了父级标签之下的所有 HTML 内容
把文本内容也视为子节点, 包括所有的空格和回车
每个节点可以有多个子节点, 该查询将返回一个集合, 要加s
> 当前节点.childNodes

- **获取子节点**(指定类型节点)
通常我们不需要文本节点, 在获取子节点时可以指定子节点的类型
该查询将返回一个集合, 要加s
> 当前节点.getElementsByTagName("指定类型标签")

- **获取兄弟节点**
JavaScript 未提供直接查询兄弟节点的查询方法.
需要先查出父节点, 再获取子节点列表, 要加s
对于子节点列表, 可以使用下标获取指定的节点
> 当前节点.parentNode.getElementsByTagName("指定类型标签")
> 当前节点.parentNode.getElementsByTagName("指定类型标签")[节点下标]


#### 3.3.3. 通过标签名查询
根据指定的标签名, 返回所有的元素, 忽略文档的结构
如果标签名称错误, 则返回长度为 0 的节点列表

#### 3.3.4. 通过 name 属性查询


### 3.4. 增删

#### 3.4.1. 新增节点对象
创建节点对象时, 要指定该节点的类型, 但并未指定节点所在位置
此时节点对象只存在内存中, 没有添加到 DOM 树之中, 是游离的节点
> var 新节点 = document.createElement("节点类型");

#### 3.4.2. 追加节点
把新创建的节点, 追加到父级节点下, 作为该父级节点的最后一个子节点
> 当前节点.appendChild(新节点)

	//创建新节点
	var li = document.createElement("li");
	//修改此li
	li.innerHTML = "天津"
	//追加新节点
	var ul = document.getElementById("city");
	ul.appendChild(li);

#### 3.4.2. 插入节点
把新创建的节点, 追加到父级节点下, 插入到某个已有节点之前
> 父类节点.insertBefore(新节点, 插入位置节点)

	//创建节点
	var li = document.createElement("li");
	//修改节点
	li.innerHTML="石家庄";
	//插入节点
	var ul = document.getElementById("city");
	var gz = document.getElementById("gz");
	ul.insertBefore(li,gz);

#### 3.4.3. 删除节点
删除节点时, 要从父级节点定位, 由父级节点去执行删除操作
> 父级节点.removeChild( 要删除的节点 )

	//通过父亲删除孩子
	var ul = document.getElementById("city");
	var gz = document.getElementById("gz");
	ul.removeChild(gz);

##### 案例: 省市选择

![](web08_2.png)

脚本部分:
	
	<script>
	var cities;
	window.onload = function() {
		//查询所有的城市(模拟)
		cities = [
			[ "石家庄", "廊坊", "保定" ], 
			[ "济南", "青岛", "烟台" ],
			[ "南京", "苏州", "无锡" ]
		];

	}
	function f1() {
		console.log("test");
		//获取省份(下标)
		var p = document.getElementById("province").value;
		console.log(p);
		//获取本省的城市列表
		var pcities = cities[p];
		//先删除旧的城市
		var select = document.getElementById("city");
		
		//通过遍历删除各个城市
		/*
		var options = select.getElementsByTagName("option");
		for (var i = options.length - 1; i > 0; i--) {
			select.removeChild(options[i]);
		}
		*/
		
		//通过重置删除城市
		select.innerHTML="<option>请选择</option>";
		
		//如果有城市, 再追加新的城市
		if (pcities) {
			for (var i = 0; i < pcities.length; i++) {
				var option = document.createElement("option");
				option.innerHTML = pcities[i];
				select.appendChild(option);
			}
		}
	}
	</script>
	
页面内容

	<body>
	省:
	<select id="province" onchange="f1();">

		<option value="-1">请选择</option>
		<option value="0">河北省</option>
		<option value="1">山东省</option>
		<option value="2">江苏省</option>
	</select> 
	市:
	<select id="city">
		<option>请选择</option>
	</select>
	</body>

##### 案例: 购物车

![](web08_3.png)

![](web08_4.png)

## 四. 自定义对象

### 1.概述
自定义对象是一种特殊的数据类型, 由属性和方法封装而成

- **属性**: 与对象有关的值
> 对象名.属性名

- **方法**: 对象可以执行的行为或可以完成的功能
> 对象名.方法名()


### 2.创建对象
无论用什么方式创建的对象, 都是Object类对象
如果对象需要复用, 建议采用自定义构造器, 对于对象包含的内容更加清晰直观

#### 2.1. 直接量( JSON )
大括号 {} 代表一个对象, 内含多个键值对
key通常是字符串, value可以是任意类型的数据, 还可以是函数
> { "属性名" : "属性值 , "方法名" : function(){} }

	//采用直接量创建对象
	function f1(){
		var stu = {
				"name":"zhangsan",
				"age":25,
				"work":function(){
					alert("学java");
				}
		};
		alert(stu.name);
		alert(stu.age);
		stu.work();
	}
### 3. 构造器
构造器也是函数, 语法规则与普通函数一样, 采用不同命名规则以示区别

- 普通函数: 小驼峰命名法, 首单词小写, 后续单词首字母大写
- 构造器函数: 大驼峰命名法, 所有单词首字母大写

#### 3.1. 内置构造器


#### 3.2. 自定义构造器

## 五. 事件

### 1. 事件概述
#### 1.1. 概述
事件:  指页面元素状态改变, 用户在操作鼠标或键盘时触发的动作

- 鼠标事件
- 键盘事件
- 状态事件: 条件成立时自动触发

#### 1.2. 事件属性
通过一个事件属性, 可以在某个事件发生时,对某个元素进行某种操作

#### 1.3. 事件定义
- 直接定义事件
直观, 但 JavaScript 与 HTML 耦合在一起, 不利于后续维护

- 动态绑定事件
页面加载后, JavaScript 获取节点, 通过修改属性的方式给节点绑定事件

### 2. event 对象
任何事件, 触发后将会产生一个 event 对象
event 对象记录了事件发生时的鼠标位置, 键盘按键状态和触发对象等信息
常用属性: clientx, clientY, cancelBubble 等 

- 如何获取事件对象
需要考虑浏览器的兼容性
	- 在调用函数时传入event
	- 在声明的函数上加参数接收event

- 直接定义的事件
1. 节点在调用函数的时候, 传入参数 event
2. JavaScript 的函数声明中, 接收参数 event

- 动态绑定事件
1. 浏览器会自动传递参数 event
2. JavaScript 的函数声明中, 接收参数 event

对于event对象, 进场需要获得事件源
	- 事件源: 即触发事件的元素( 事件的目标节点 )
	> event.srcElement || event.target
	
动态绑定事件

### 3. 事件处理机制
- 冒泡机制
当处于对象模型底部对象发生时, 会依次激活上层对象定义的同类事件处理.
使用冒泡机制, 可以简化事件的定义, 

- 取消冒泡
可以取消事件的冒泡, 底层对象事件发生时, 只在该对象层次激活事件处理, 而不会继续激活上层对象的事件处理.

- 待解决的问题
在使用冒泡简化事件定义的时候, 需要知道事件发生的具体部位, 称之为事件源
通过事件对象, 可以获得事件源

