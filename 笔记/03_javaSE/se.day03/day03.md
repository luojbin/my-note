# Java API

## Object

### toString() 

返回对象的描述字符串。

### equals

用于比较两个对象是否相等。

## 包装类

将基本类型包装对象。

1. 包装类包装的是基本类型数据
2. 基本类型计算性能好
	- 包装类型计算性能差
3. 每个基本类型对应一个包装类型
	- byte  ->  Byte
	- short ->  Short
	- int   ->  Integer
	- long  ->  Long
	- float ->  Float
	- double -> Double
	- boolean -> Boolean
	- char    -> Charcater

### 包装类用于将基本类型包装为对象

案例：
	
	int n = 5;
	Integer i = new Integer(n);
	Integer j = Integer.valueOf(n);

	Double d = new Double(0.5);
	Double k = Double.valueOf(0.5);

### Java 5 提供了 “自动包装”

案例：

	Integer i = new Integer(5);
	Integer j = Integer.valueOf(5);
	Integer k = 5;//Java 5 自动包装功能
	
	System.out.println(k);//5
	System.out.println(i);//5
	System.out.println(j);//5
		
### Number

* 数字类型包装类型的父类 Number
* Number 中定义了 子类的公共方法
	- intValue()
	- doubleValue()
	- longValue()
	- floatValue()
* 全部子类都继承这些功能
* Number 可以定义变量引用任何子类型实例

案例：

	Integer i=6;//自动包装
	//将Integer转换为 double类型数据
	double d = i.doubleValue();
	System.out.println(d); //6.0
	//读取整数类型
	int n = i.intValue();
	System.out.println(n);
	//Java5 以后提供了自动拆包
	int m = i;//编译后 i.intValue();
	System.out.println(m); 
	
	Double x = 6.6;
	double y = x.doubleValue();
	int k = x.intValue();
	double z = x;//x.doubleValue();
	System.out.println(x);
	System.out.println(y);
	System.out.println(z);
	System.out.println(k);
	
	Number num = 6.0;
	System.out.println(num);//toString() 

### 包装类中声明的每种类型的 “极值”

案例：

	int max = Integer.MAX_VALUE;
	int min = Integer.MIN_VALUE;
	System.out.println(max);
	System.out.println(min);
	
	double dmax = Double.MAX_VALUE;
	System.out.println(dmax);

> 每种类型的极值都定义对应的包装类中。

### 包装类中提供了 字符串类转换为基本类型的方法

* Integer.parseInt()
* Double.parseDouble()
* Boolean.parseBoolean()

案例：

	String str = "-12561";
	int i = Integer.parseInt(str);
	System.out.println(i);//
	
	//str = "Abnc123";
	//i = Integer.parseInt(str);
	
	str = "3.14";
	double pi = Double.parseDouble(str);
	System.out.println(pi);
	
	str = "true";
	boolean b = Boolean.parseBoolean(str);
	System.out.println(str);

### 自动拆包和自动包装 

Java5 为了方便程序员，提供了自动包装和自动拆包

> 注意: 包装类型计算性能没有基本类型好，要尽量避免大量使用包装类进行计算。

案例：

	Integer i = 5;//自动包装
	int j = i;//自动拆包
	
	int num = i * 6 + j;
	Integer x = i * 6 + j;
	
	System.out.println(num);
	System.out.println(x);


## 时间 API

### 计算机里的时间原理

- 计算机中的时间是一个毫秒数
- 从1970年元旦开始累积
- 1970年以前是负数

### Date 类型

1. 默认的Date类型对象中封装当前系统时间毫秒
2. getTime 获取时间毫秒数 
3. 修改date中的毫秒数
4. Date 重写了toString 方法

案例：

		//默认的Date类型中封装了系统时间毫秒
		Date date = new Date();
		//获取时间毫秒数
		long now = date.getTime();
		System.out.println(now);
		long y=now/1000/60/60/24/365 + 1970;
		System.out.println(y); 
		//date 重写了toString();
		System.out.println(date); 
		
		int year = date.getYear();
		System.out.println(year); 
		//修改date中的毫秒数
		//0毫秒代表 GTM 时间的1970年元旦
		date.setTime(-1000L*60*60*24);
		System.out.println(date); 
		year = date.getYear();
		System.out.println(year);	

### SimpleDateFormat 

SimpleDateFormat 用于将Java系统时候
换算为人类习惯的 年月日 时分秒

案例：

		SimpleDateFormat fmt=
			new SimpleDateFormat();
		Date date = new Date();
		//将系统时间换算为人类习惯的时间
		String str = fmt.format(date);
		System.out.println(str); 

自定义时间格式化显示 

		SimpleDateFormat fmt = 
			new SimpleDateFormat(
				"yyyy年M月d日 HH:mm:ss");
		Date date = new Date();
		System.out.println(date);
		System.out.println(fmt.format(date));  

将字符串解析为 系统时间（毫秒数）

		String str = "1980-5-6";
		String pattern = "yyyy-M-d";
		SimpleDateFormat fmt=
			new SimpleDateFormat(pattern);
		//将字符串时间解析为计算机时间
		Date date=fmt.parse(str);
		System.out.println(date);
		System.out.println(date.getTime());
		
		//解析身份证中的生日
		String id="12345619891405123122x";
		//         012345678901234
		String s = id.substring(6,6+8);
		System.out.println(s); 
		pattern = "yyyyMMdd";
		fmt=new SimpleDateFormat(pattern);
		date = fmt.parse(s);
		System.out.println(date); 

### Calender

历法是替代 Date 类型的API，用于替换Date类型的那些过时的API方法 

		Calendar c1 = 
			new GregorianCalendar();
		Calendar c2 = Calendar.getInstance();
		//默认的Calendar里面封装是当前系统时间
		System.out.println(c1);
		System.out.println(c2);
		//将Calender转换为Date类型
		Date date = c1.getTime();
		SimpleDateFormat fmt =
			new SimpleDateFormat();
		System.out.println(fmt.format(date));
		
		//创建指定年月日的Calender
		Calendar cal = 
			new GregorianCalendar(
				2017, Calendar.MARCH, 6);
		//输出结果：
		date = cal.getTime();
		System.out.println(fmt.format(date)); 

设置时间的分量 

		//默认的Calender是当前时间
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.getTime());
		//利用set方法修改时间分量：
		//修改年份分量
		cal.set(Calendar.YEAR, 2000);
		//修改月份分量
		cal.set(Calendar.MONTH, 
				Calendar.AUGUST);
		//修改日期分量
		cal.set(Calendar.DATE, 1);
		//检查修改的结果：
		System.out.println(cal.getTime());
 		
		//超量更改时间：32天是一个月多一天
		cal.set(Calendar.DATE, 32);
		System.out.println(cal.getTime());

获取时间分量

		Calendar cal = Calendar.getInstance();
		//获取年份分量
		int year=cal.get(Calendar.YEAR);
		System.out.println(year); 
		//获取月份分量
		int month = cal.get(Calendar.MONTH);
		System.out.println(month);
		//获取日期分量
		int d = cal.get(Calendar.DATE);
		System.out.println(d); 
		//获取星期
		int w = cal.get(Calendar.DAY_OF_WEEK);;
		System.out.println(w); 
		
输出每个月的最大日期 

		Calendar cal=Calendar.getInstance();
		
		for(int i=Calendar.JANUARY; 
				i<=Calendar.DECEMBER; i++){
			cal.set(Calendar.MONTH, i);
			cal.set(Calendar.DATE,1);
			int max=cal.getActualMaximum(
				Calendar.DAY_OF_MONTH);
			System.out.println(max); 
		}

日期相对增加方法 add 

		Calendar cal=Calendar.getInstance();
		print(cal); 
		
		//将cal中的当前时间的月份分量上
		//增加5个月的时间。
		cal.add(Calendar.MONTH, -5);
		print(cal); 
		
		cal.add(Calendar.DATE, 5);
		print(cal); 

----------------

##  作业

从SVN中下载作业	





