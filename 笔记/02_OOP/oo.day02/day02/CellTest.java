package oo.day02;
//格子类的测试类
public class CellTest {
	public static void main(String[] args) {
		/*
		Cell c = new Cell();
		c.row = 2;
		c.col = 5;
		c.drop(); //下落一格
		c.drop(3); //下落三格
		c.moveLeft(); //左移一格
		c.moveLeft(2); //左移两格
		printWall(c);
		*/
		
		Cell c1 = new Cell(); //调无参
		Cell c2 = new Cell(3); //调一个参数
		c2.drop();
		Cell c3 = new Cell(2,5); //调两个参数
		
		printWall(c2);
		
		
	}
	//打墙+打格
	public static void printWall(Cell cc){
		for(int i=0;i<20;i++){ //行
			for(int j=0;j<10;j++){ //列
				if(i==cc.row && j==cc.col){ //行列匹配
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println(); //换行
		}
	}
}














