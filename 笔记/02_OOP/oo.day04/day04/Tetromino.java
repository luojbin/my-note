package oo.day04;
//四格拼板
public class Tetromino {
	Cell[] cells; //格子数组
	Tetromino(){
		cells = new Cell[4];
	}
	
	void drop(){
		for(int i=0;i<this.cells.length;i++){
			this.cells[i].row++;
		}
	}
	void moveLeft(){
		for(int i=0;i<cells.length;i++){
			cells[i].col--;
		}
	}
	void moveRight(){
		for(int i=0;i<cells.length;i++){
			cells[i].col++;
		}
	}
	void print(){
		for(int i=0;i<this.cells.length;i++){
			String str = this.cells[i].getCellInfo();
			System.out.println(str);
		}
	}
	
}













