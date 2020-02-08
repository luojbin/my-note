# API

## Java中如何比较两个对象

1. 默认比较大小Comparable
	- Java 中定义了一个接口  Comparable
	- 包含比较方法compareTo
		- 返回正数， 第一个对象大
		- 返回负数， 第一个对象小
		- 返回0数， 两个数一样
	- Java中可以比较大小的API都实现了这个接口
		- String 
		- Date 
		- 包装类
		- 等
	- 案例


			public class Demo01 {
				public static void main(String[] args) {
					String s1 = "田";//30000
					String s2 = "中";//20013
					String s3 = "abcd";
					int n1 = s1.compareTo(s2);
					int n2 = s2.compareTo(s1);
					int n3 = s1.compareTo(s3); 
					System.out.println(n1);
					System.out.println(n2);
					System.out.println(n3);
					
				}
			}

2. 定义比较大小  Comparator 
	- 声明了用于比较任意对象的方法 compare

	- 案例：

			public class Demo03 {
				public static void main(String[] args) {
					Product p1 = 
						new Product("新西兰空气", 5.9);
					Product p2 = 
						new Product("加勒比海海水", 6);
					Product p3 = 
						new Product("喜马拉雅山雪", 6);
					ByWeight byWeight = new ByWeight();
					int n1 = byWeight.compare(p1, p2);
					int n2 = byWeight.compare(p2, p1);
					int n3 = byWeight.compare(p2, p3);
					System.out.println(n1);
					System.out.println(n2);
					System.out.println(n3);
					}
			}
			/*
			 * 按照商品重量进行自定义比较
			 */
			class ByWeight 
				implements Comparator<Product>{
				public int compare(
						Product o1, Product o2) {
					double val = o1.weight-o2.weight;
					if(val>0){return -1;}
					if(val<0){return 1;}
					return 0;
				}
			}
			class Product{ //产品
				String name;
				double weight;//重量
				public Product(
						String name, double weight) {
					this.name = name;
					this.weight = weight;
				}
				public String toString() {
					return "Product [name=" + name + ", weight=" + weight + "]";
				}
			}

## 自然排序

	/**
	 * 对可以比较大小的对象进行自然排序 
	 */
	public class Demo02 {
		public static void main(String[] args) {
			List<String> list = 
					new ArrayList<String>();
			list.add("Tom");
			list.add("Jerry");
			list.add("Andy");
			list.add("Lee");
			list.add("Mac");
			/*
			 * sort方法只能对List集合进行排序
			 * list集合中的元素需要实现Compatible
			 * 接口包含compareTo方法 
			 */
			Collections.sort(list);
			System.out.println(list); 
			
		}
	}

## 自定义排序

	/**
	 * 自定义比较与自定义排序 
	 *
	 */
	public class Demo03 {
		public static void main(String[] args) {
			Product p1 = 
				new Product("新西兰空气", 5.9);
			Product p2 = 
				new Product("加勒比海海水", 6);
			Product p3 = 
				new Product("喜马拉雅山雪", 6);
			ByWeight byWeight = new ByWeight();
			int n1 = byWeight.compare(p1, p2);
			int n2 = byWeight.compare(p2, p1);
			int n3 = byWeight.compare(p2, p3);
			System.out.println(n1);
			System.out.println(n2);
			System.out.println(n3);
		
			List<Product> list=
				new ArrayList<Product>();
			list.add(p3);
			list.add(p2);
			list.add(p1);
			list.add(new Product(
					"阿拉斯加的土", 2)); 
			//Java中的自定义排序
			//将集合中的元素按照给定的自定义比较器
			//的比较结果进行排序。
			Collections.sort(list, byWeight);
			System.out.println(list);
		}
	}
	/*
	 * 按照商品重量进行自定义比较
	 */
	class ByWeight 
		implements Comparator<Product>{
		public int compare(
				Product o1, Product o2) {
			double val = o1.weight-o2.weight;
			if(val>0){return -1;}
			if(val<0){return 1;}
			return 0;
		}
	}
	class Product{ //产品
		String name;
		double weight;//重量
		public Product(
				String name, double weight) {
			this.name = name;
			this.weight = weight;
		}
		public String toString() {
			return "Product [name=" + name + ", weight=" + weight + "]";
		}
	}

## Queue 队列

Java提供了Queue API，由LinkedList实现，用于处理先进先出的业务问题，如视频缓存队列

操作方法：

1. offer 将数据插入队列
2. peek 检查队列头部元素
3. poll 从队列拉出数据

![](1.png)

案例：
	 
	public class Demo04 {
		public static void main(String[] args) {
			Queue<String> queue = 
				new LinkedList<String>();
			System.out.println(queue);
			//offer将数据追加到队列中
			queue.offer("Tom");
			queue.offer("Jerry");
			queue.offer("Andy");
			System.out.println(queue); 
			//peek检查队首，元素并不出列
			String first = queue.peek();
			System.out.println(first);//Tom
			System.out.println(queue);//不变
			//poll 是拉出一个元素，元素出列
			String element=queue.poll();
			System.out.println(element);//Tom
			System.out.println(queue);
			//拉取队列中全部的数据
			while(! queue.isEmpty()){
				System.out.println(queue.poll());
			}
		}
	}

## Stack 栈

栈是后进先出的数据结构。

Java 利用Deque 接口提供了栈操作方法 push 和 pop，由LinkedList实现了Stack结构：

方法：

1. push 将数据压入栈
2. pop 将数据从栈中弹出 

案例：

	/**
	 * 后进先出的栈结构 
	 */
	public class Demo05 {
		public static void main(String[] args) {
			// Deque 接口中定义了 栈操作方法
			// LinkedList 实现了栈操作方法
			Deque<String> stack = 
				new LinkedList<String>();
			//栈提供了 push方法可以将数据“压”入栈中。
			stack.push("Tom");
			stack.push("Jerry");
			stack.push("Andy");
			//先压入的数据在栈的最底部
			System.out.println(stack);
			//出栈的顺序相反：后进先出
			while(! stack.isEmpty()){
				//利用pop可以从栈中弹出数据
				//弹出顺序与进入顺序相反
				String s = stack.pop();
				System.out.println(s); 
			}
		}
	}

## 查找表Map

Map是专门面向查找而设计的数据结构，其特点是将数据按照Key：Value成对存储起来，按照key来查找Value。 map中的key不可以重复，Value可以重复。

Map的常用实现类HashMap是查找性能最好的数据结构！

Map接口定义了通用的方法：

1. put(key,Value) 将数据添加到map
	- 如果map中没有key，则添加
	- 如果map中已经存在key则替换
2. value = get(key) 从map中查找value
	- 返回查找结果对象
	- 没有找到返回null
3. boolean containsKey(key) 检查map中是否包含key

案例：

	/**
	 * 测试使用查找表
	 */
	public class Demo06 {
		public static void main(String[] args) {
			//创建 map 类型的实例，声明key的类型
			//是String，被查找的Value的类型是Emp
			// 员工信息
			Map<String, Emp> employees =
				new HashMap<String, Emp>();
			//向map添加被查找的数据
			Emp val=employees.put("传奇", 
					new Emp(1, "范传奇"));
			System.out.println(val);
			val=employees.put("范传奇", 
					new Emp(1, "范冰冰"));
			System.out.println(val);
			//当Key相同时候，就发生了替换, 
			//返回值是被替换的原有数据
			val=employees.put("范传奇", 
					new Emp(1, "范传奇"));
			System.out.println(val);
			System.out.println(employees); 
			
			employees.put("克晶", 
					new Emp(2, "王克晶"));
			employees.put("王克晶", 
					new Emp(2, "王克晶"));
			System.out.println(employees);
			
			//调用get方法，利用关键字查找员工信息:
			Emp emp = employees.get("传奇");
			System.out.println(emp);
			//当关键字key对应的Value不存在时候
			//返回null，表示查找没有结果
			emp = employees.get("李洪鹤");
			System.out.println(emp);//null
			
			//containsKey检查 map 中是否包含指定的key
			boolean b = 
				employees.containsKey("克晶");
			System.out.println(b);
			b = employees.containsKey("洪鹤");
			System.out.println(b);
		}
	}
	class Emp{//员工类型
		int id;
		String name;
		public Emp(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public String toString() {
			return "Emp [id=" + id + ", name=" + name + "]";
		}
	}


map的查找性能非常好：
	
	/**
	 * ArrayList 顺序查找和 HashMap散列查找的性能差别
	 * list.indexOf(obj)：在list顺序查找obj对象
	 * 返回对象的索引位置
	 *    
	 * map.get(key) 是散列查找
	 */
	public class Demo07 {
		public static void main(String[] args) {
			List<Integer> list= 
				new ArrayList<Integer>();
			Map<Integer, Integer> map =
				new HashMap<Integer, Integer>();
			for(int i=0; i<800000; i++){
				list.add(i);
				map.put(i, i);
			}
			long t1 = System.nanoTime();
			int idx = list.indexOf(799999);
			long t2 = System.nanoTime();
			int n = map.get(799999);
			long t3 = System.nanoTime();
			System.out.println(idx);//99999
			System.out.println(n);
			System.out.println(
					(t2-t1)+","+(t3-t2));
		}
	}
		
散列表的原理：

	public class Demo08 {
		public static void main(String[] args) {
			//相同等的字符串 hashCode值一样
			System.out.println(
				"传奇".hashCode());
			System.out.println(
				"传奇".hashCode());
			System.out.println(
				"范传奇".hashCode());
			System.out.println(
					"王克晶".hashCode());
			System.out.println(
					"克晶".hashCode());
			System.out.println(
					"洪鹤".hashCode());
			
			String s1 = new String("abc");
			String s2 = new String("abc");
			String s3 = new String("abd");
			System.out.println(s1.hashCode());
			System.out.println(s2.hashCode());
			System.out.println(s3.hashCode());
			
		}
	
	}

![](2.png)

作为散列表Key的类型必须实现hashCode和equals：

	/**
	 * 测试 key对象的 equals 和 hashCode 
	 * 对HashMap的影响 
	 */
	public class Demo09 {
		public static void main(String[] args) {
			//key对象类型如果不重写equals hashCode
			//将对象map集合产生严重影响，照成map
			//工作异常
			Map<Key,String> map =
				new HashMap<Key, String>();
			//没有重新hashCode和equals会出现重复添加
			map.put(new Key(1, "老师"), 
					"范传奇，王克晶，李洪鹤");
			map.put(new Key(1, "老师"), 
					"范老师，王老师，李老师");
			System.out.println(map); 
			//没有重新hashCode和equals会出现查询失败
			String val = 
					map.get(new Key(1, "老师"));
			System.out.println(val); 
			
		 
			
		}
	}
	class Key{
		int id;
		String name;
		public Key(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (id != other.id)
				return false;
			return true;
		}
	
		public String toString() {
			return "Key [id=" + id + ", name=" + name + "]";
		}
	}

## Map的遍历

Map的遍历

1. 利用key的集合遍历map的内容
2. 利用Entry遍历map集合 

案例：
	
	public class Demo10 {
		public static void main(String[] args) {
			Map<String, String> map = 
				new HashMap<String, String>();
			map.put("炸弹", "大王,小王");
			map.put("同花顺", "方块3, 方块4, 方块5, 方块6");
			map.put("拖拉机", "梅花5,红桃5,梅花6,红桃");
			//获取全部key的集合
			Set<String> keySet=map.keySet();
			System.out.println(keySet);
			//遍历集合中全部的Key
			for(String key:keySet){
				System.out.println(key);
				//在迭代期间可以利用get方法获取
				//value的值，性能没有问题
				System.out.println(map.get(key)); 
			}
			
			//利用Entry遍历Map集合
			//entrySet() 可以从map集合中获取全部
			// key:value 条目的集合，每个key:value
			// 对的对象类型是 Entry，而Entry类型上
			// 定义了getKey和getValue方法，可以获取
			// key:value对中的key和Value
			Set<Entry<String,String>> entries=
				map.entrySet();
			for(Entry<String, String> entry:entries){
				String key = entry.getKey();
				String value = entry.getValue();
				System.out.println(key+":"+value);
			}
		}
	}
	


## PM2.5

收集PM2.5信息，方便查找某个区域的PM2.5最大值
PM2.5数据：

	"海淀:180,顾家庄:100,香山:78,驻马店:120,石家庄:125,海淀:156,香山:298,海淀:356"

参考代码：
	
	public class Demo11 {
	
		public static void main(String[] args) {
	//"海淀:180,顾家庄:100,香山:78,驻马店:120,石家庄:125,海淀:156,香山:298,海淀:356"
			
			//1. 解析字符串得到每个地点和其PM2.5值
			//2. 创建散列表 map
			//3. 遍历输入数据
			//4. 如果有地点，取出比较在存入
			//5. 如果没有地点，直接存入
			
			String pm25="海淀:180,顾家庄:100,香山:78,驻马店:120,石家庄:125,"
					+ "海淀:156,香山:298,海淀:356";
			String[] data = pm25.split("[,:]");
			System.out.println(Arrays.toString(data));
			Map<String, Integer> map=
					new LinkedHashMap<String, Integer>();
			for(int i=0; i<data.length; i+=2){
				String loc=data[i];
				String str=data[i+1];
				//System.out.println(loc);
				int val = Integer.parseInt(str);
				if(map.containsKey(loc)){
					int v = map.get(loc);
					if(val>v){
						map.put(loc, val);
					}
	 			}else{
	 				map.put(loc, val);
	 			}
			}
			
			//查询
			int val = map.get("海淀");
			System.out.println(val);
			//输出全部结果？
		}
	}


---------------------

## 作业

请完成SVN中的作业









