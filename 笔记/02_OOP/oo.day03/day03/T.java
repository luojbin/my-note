package oo.day03;
//T型
public class T extends Tetromino {
	T(){
		this(0,0);
	}
	T(int row,int col){
		super(); //调用父类的无参构造--默认的
		super.cells[0] = new Cell(row,col); //创建格子对象
		super.cells[1] = new Cell(row,col+1);
		super.cells[2] = new Cell(row,col+2);
		super.cells[3] = new Cell(row+1,col+1);
		
	}
}
















