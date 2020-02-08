# Java API

## Java File

Java 程序中如何操作文件、文件夹：

1. 创建File对象代表文件夹、文件
2. 利用File对象提供方法操作文件夹、文件
3. File 对象提供的方法:
	- 属性方法
		- 是否存在 
		- 是否是文件
		- 是否是文件夹
		- 文件的长度，文件中包含的字节数量
		- 文件（文件夹）的读写属性
		- 文件夹、文件是否隐藏
		- 文件的创建时间
	- 操作方法
		- 删除文件夹、文件
		- 创建文件夹，创建系列文件夹
		- 创建文件
		- 文件夹、文件的改名
	- 查询方法
		- 列文件夹的内容

### File	构造器

创建File对象可以代表文件或者文件夹

1. new File(文件路径名)
2. new File(父文件夹，文件名)

> 利用构造器创建file对象以后就可以调用File 提供的API方法了

案例：
	
	/**
	 * 创建file对象，代表某个文件夹中的某个文件 
	 */
	public class Demo06 {
		public static void main(String[] args) {
			//创建file对象代表文件夹
			File dir=new File("test");
			//创建file对象代表 文件夹中的文件
			File file=new File(dir, "demo.txt");
			//如上file代表 test文件夹中的demo.txt
			//文件
			boolean b = file.exists();
			System.out.println(b); 
		}
	}


### 删除文件 API 方法

案例：

	/**
	 * File API 的使用
	 *
	 */
	public class Demo01 {
		public static void main(String[] args) {
			//创建file 对象，代表硬盘上的文件
			File file=new File("demo/test.txt");
			//有了file对象后就可以利用File类
			//提供的API方法操作 demo/test.txt文件
			//delete：删除file所代表的硬盘文件
			boolean success = file.delete();
			System.out.println(success);
			//当删除成功时候返回 true，
			//删除失败时候返回false
			success = file.delete();
			System.out.println(success); 
		}	
	}

### File 对象可以代表文件或文件夹
	
	/**
	 * File 可以代表文件夹 
	 */
	public class Demo04 {
		public static void main(String[] args) {
			//dir 就代表硬盘上的一个文件夹
			File dir=new File("demo");
			//File API 提供了检查是否是文件夹的方法
			//isDirectory 返回true是文件夹
			boolean b = dir.isDirectory();
			System.out.println(b); //true
			//删除文件夹！只能删除空文件夹！
			dir.delete();
			//此时file对象，没有被代表的文件、文件夹
			//这时候 file对象：不是文件，不是文件夹
			// 也不存在
			b = dir.isDirectory();
			System.out.println(b); 
		}
	}


### 检查文件是否存在

new File（） 用于创建内存对象，并不是创建文件或者文件夹，甚至并不一定有对应的磁盘文件，Java File 提供了exists用于检查对应的磁盘文件（文件夹）是否存在：

	/**
	 * 检查磁盘文件是否存在 
	 */
	public class Demo02 {
		public static void main(String[] args) {
			File file=new File("demo/hello.txt");
			//exists: 检查file对象代表的硬盘文件
			//是否存在，如果存在则true，否则false
			boolean b = file.exists();
			System.out.println(b);//true
			file.delete();
			//删除以后磁盘文件就不存在了，但是内存对象还在
			b = file.exists();
			System.out.println(b);//false
		}
	}

### 文件分隔符
	
	/**
	 * 文件分隔符问题：
	 * 1. Windows 的文件分隔符 ：\
	 * 	  - D:\demo\test.txt
	 *    - demo\test.txt
	 *    - File.separator = \
	 * 2. Linux 的文件分隔符 ：/
	 *	  - /home/soft01/demo/test.txt
	 *    - demo/test.txt
	 *    - File.separator = /
	 * 3. File 类提供了自动适应操作系统的文件分隔符
	 * 变量File.separator或随着操作系统自动变化，
	 * 可以利用这变量，编写跨系统的程序：
	 * 	  - "demo"+File.separator+"test.txt"
	 * 4. 当使用 “/” 时候 Java 会自动使用所有操作
	 *    系统，这样更加方便！
	 */
	public class Demo03 {
		public static void main(String[] args) {
			String path= "demo"+File.separator+
					"test.txt";
			File file = new File(path);
			boolean b = file.exists();
			System.out.println(b);//false
		}
	}

### 不能删除非空文件夹

delete()方法可以删除文件或者空文件夹，但是不能删除非空文件夹！！


案例:

	/**
	 * 不能删除非空文件夹 
	 * 首先准备实验素材：test/demo.txt
	 */
	public class Demo05 {
		public static void main(String[] args) {
			//创建file对象代表文件夹
			File dir=new File("test");
			boolean b=dir.isDirectory();
			System.out.println(b);//true
			boolean success=dir.delete();
			System.out.println(success);//false
			//test 文件夹中包含文件，这时
			//不能直接删除。delete()返回false
		}
	}
	
	
> 删除非空文件夹可以利用后面的递归删除方法实现！


### 读取文件的属性

File API 提供了读取文件（文件夹）属性的方法

	/**
	 * 读取一个文件夹、文件的全部属性
	 * 素材：test/demo.txt 
	 */
	public class Demo07 {
		public static void main(String[] args) {
			File dir=new File("test");
			File file=new File(dir, "demo.txt");
			//dir代表一个文件夹
			//file 代表一个文件
			//检查是否是文件
			System.out.println(dir.isFile());
			System.out.println(file.isFile());
			//检查文件的长度
			long length = file.length();
			System.out.println(length); 
			//检查文件的最后修改时间
			long time = file.lastModified();
			Date date = new Date(time);
			System.out.println(date);
			//检查文件的读写属性
			boolean read=file.canRead();
			boolean write=file.canWrite();
			boolean hidden = file.isHidden();
			
			System.out.println(read);
			System.out.println(write);
			System.out.println(hidden);
		}
	
	}

> 文件夹的长度是没有意义的数据！！

### 创建文件夹

	/**
	 * 创建文件夹 
	 */
	public class Demo08 {
		public static void main(String[] args) {
			File file = new File("abc");
			//mkdir()用于创建文件夹，如果成功
			//创建文件夹，则返回true，否则false
			boolean b = file.mkdir();
			System.out.println(b);//true
			//创建系列文件夹
			File file2=new File("def/demo/test");
			//mkdirs 用于创建一系列父子文件夹
			b = file2.mkdirs();
			System.out.println(b); 
			//使用绝对路径创建文件夹
			File file3=new File("d:/demo/test");
			//new File("/home/soft01/demo/test");
			file3.mkdirs();
		}
	}
	
### 创建文件


	/**
	 * 利用File API 创建文件
	 * 
	 */
	public class Demo09 {
		public static void main(String[] args) 
			throws Exception{
			File file = new File("test/abc.txt");
			//调用file对象的API方法
			//create:创建
			//createNewFile: 创建新文件
			//如果创建成功返回true，创建失败
			//返回false，如果没有写入权限，则
			//出现异常！！
			boolean b = file.createNewFile();
			System.out.println(b);//true
			//使用绝对路径创建文件
		}
	}

### 文件（文件夹）改名

	/**
	 * 文件的改名操作
	 * 素材： test/abc.txt  没有 test/def.txt
	 */
	public class Demo10 {
		public static void main(String[] args) {
			File file1=new File("test/abc.txt");
			File file2=new File("test/def.txt");
			//file1 是存在的文件，
			//file2 是一个不存在的文件
			//将file1的名字改名为file2对应的名字
			boolean b = file1.renameTo(file2);
			//改名之后：file1就不存在了（abc.txt）
			//          file2存在(def.txt)
			System.out.println(b);//true
		}
	}
	
### 列出文件夹的内容

	
	/**
	 * 列文件夹的内容 
	 */
	public class Demo11 {
		public static void main(String[] args) {
			//创建file对象代表test文件夹
			// new File("D:/");
			// new File("/home/soft01/");
			File dir=new File("test");
			//查询 test文件夹的内容列表
			//返回值是File类型的数组，有的是
			//文件有的是文件夹
			File[] files=dir.listFiles();
			//在控制台输出文件夹中全部的内容
			for(File file:files){
				//文件夹显示为： [文件夹名]
				if(file.isDirectory()){
					System.out.println(
							"["+file.getName()+"]"); 
				}else{
					System.out.println(
							file.getName());
				}
			}
		}
	}
	
### 递归删除文件夹的内容

	
	/**
	 * 删除一个包含文件的文件夹 
	 */
	public class Demo12 {
		public static void main(String[] args) {
			File file = new File("abc");
			boolean b=delete(file);
			System.out.println(b); 
		}
		// 删除一个包含文件的文件夹 
		public static boolean delete(File dir){
			//删除一个文件夹的步骤：
			//1. 列出文件夹的全部内容
			//2. 遍历每个文件，并且调用文件的detete()
			//3. 删除文件夹
			//4. 返回删除的结果
			if(! dir.exists()){
				return false;
			}
			File[] files=dir.listFiles();
			for(File file:files){
				if(file.isDirectory()){
					//删除子文件夹
					//删除子文件的算法与删除当前
					//文件夹的算法是一致的。利用
					//递归删除子文件夹
					delete(file);
				}else{
					file.delete();
				}
			}
			return dir.delete();
		}
	}
	
### 递归统计文件夹的大小

	/**
	 * 统计一个文件夹中全部文件的总长度 
	 */
	public class Demo13 {
		public static void main(String[] args) {
			File dir = new File("abc");
			long n = count(dir);
			System.out.println(n); 
		}
		//统计dir对应的文件夹中文件的总大小
		public static long count(File dir){
			//1. 查找dir的全部内容
			//2. 遍历每个文件，累加文件的大小
			//3. 返回统计结果
			if(! dir.exists()){	return 0;}
			if(dir.isFile()){return dir.length();}
			File[] files=dir.listFiles();
			long sum = 0;
			for(File file:files){
				if(file.isDirectory()){
					//统计子文件夹的总大小:
					//统计子文件夹时候和统计当前
					//文件夹的算法是一样的！
					long l = count(file);
					sum += l;
				}else{
					//统计一个文件
					sum+=file.length();	
				}
			}
			return sum;
		}
	}

### 有条件列目录


	/**
	 * 设置文件的过滤条件
	 * File： 文件
	 * Filter: 过滤器
	 */
	public class Demo14 {
		public static void main(String[] args) {
			//FileFilter 是一个接口
			//new FileFilter(){} 创建匿名内部类
			FileFilter filter = 
				new FileFilter(){
				//accept 方法是在FileFilter中定义
				//的抽象方法。
				//accept: 接受，测试文件是否
				//被接受
				public boolean accept(File file){
					//接受一个文件的名是以.txt
					//为结尾的。
					String name=file.getName();
					return name.endsWith(".txt"); 
				}
			};
			
			File file1 = new File("abc/demo1.txt");
			File file2 = new File("abc/test.dat");
			//检查 file1 使用以 .txt 为结尾
			System.out.println(
					filter.accept(file1));//true
			//检查 file2 使用以 .txt 为结尾
			System.out.println(
					filter.accept(file2));//false
			
			//listFiles 重载方法，与filter配合
			//可以过滤文件夹内容列表，列出满足
			//条件的文件
			
			File dir=new File("abc");
			//满足过滤条件的全部文件（或文件夹）
			File[] files=dir.listFiles(filter);
			for(File file:files){
				System.out.println(file.getName());
			}
			//有过滤条件的列目录方法
			//listFiles(过滤条件);
		}
	}


## RandomAccessFile

RandomAccessFile 简称 RAF，Java是提供的API，可以从文件的任意一个位置开始访问文件的内容。

Random： 随机，任意位置
Access： 访问，读写

> 任何文件都是一个长长的byte数据序列。

### RAF 写文件


	/**
	 * RAF 写出文件 
	 */
	public class Demo15 {
		public static void main(String[] args) 
			throws Exception{
			String file="abc/demo.txt";
			//创建RAF对象，以读写方式创建对象时候
			//如果文件不存在，则在磁盘上自动创建
			//文件，文件默认的指针位置在0
			//如果文件与文件夹同名或者不能写文件
			//则抛出异常
			RandomAccessFile raf=
				new RandomAccessFile(file, "rw");
			//检查文件的读写指针位置
			long p=raf.getFilePointer();
			System.out.println(p);//0
			//将数据写到文件中
			raf.write(65); //有效范围：0~255
			p = raf.getFilePointer();
			System.out.println(p);
			
			raf.write(66);
			p = raf.getFilePointer();
			System.out.println(p);
			
			long l = raf.length();//检查文件的长度
			System.out.println(l); 
			
			raf.close();//raf必须关闭
		}
	
	}


		
### RAF 读取文件

	/**
	 * RAF 读取文件
	 *
	 */
	public class Demo16 {
		public static void main(String[] args) 
			throws Exception {
			//以只读访问打开文件
			String file = "abc/demo.txt";
			RandomAccessFile raf=
				new RandomAccessFile(file, "r");
			//刚刚打开的文件读写指针位置是0
			long p=raf.getFilePointer();
			System.out.println(p);//0
			//读取0位置上的数据(65)
			int b = raf.read();//将byte填充到int
			//占用int： 0~255 范围
			System.out.println(b);//65
			//读取以后，文件指针位置自动移动一下
			//检查文件指针位置
			p = raf.getFilePointer();
			System.out.println(p);//1
			//读取下一个byte数据: 66
			b = raf.read(); 
			System.out.println(b);//66
			//文件指针位置：
			p = raf.getFilePointer();
			System.out.println(p);//2
			//在文件末尾时候调用raf.read()
			//返回一个特殊值：-1 表示读取到文件末尾了
			b = raf.read();
			System.out.println(b);//-1
			p = raf.getFilePointer();
			System.out.println(p);//2
			raf.close();
		}
	}






