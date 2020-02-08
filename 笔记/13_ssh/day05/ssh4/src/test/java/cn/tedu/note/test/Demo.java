package cn.tedu.note.test;

public class Demo {
	public static void main(String[] args) {
		//Girl girl1 = new Girl();
		//Girl girl2 = new Girl();
		//Girl g = Girl.girl;
		//Girl.girl = null;
		Girl girl1 = Girl.getInstance();
		Girl girl2 = Girl.getInstance();
		Boy boy = Boy.getInstance();
	}
}
//"懒汉式" 按需加载
class Boy{
	private static Boy instance;
	private Boy(){
	}
	public synchronized static Boy getInstance() {
		if(instance == null){
			instance = new Boy();
		}
		return instance;
	}
}

//"饿汉式" 立即加载模式
class Girl{
	private static Girl instance = new Girl();
	private Girl(){
	}
	public static Girl getInstance() {
		return instance;
	} 
}



