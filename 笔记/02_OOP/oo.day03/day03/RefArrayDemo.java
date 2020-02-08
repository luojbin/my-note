package oo.day03;
//引用类型数组的演示
public class RefArrayDemo {
	public static void main(String[] args) {
		Cell[] cells = new Cell[4]; //创建Cell格子数组对象
		cells[0] = new Cell(2,5); //创建Cell格子对象
		cells[1] = new Cell(2,6);
		cells[2] = new Cell(2,7);
		cells[3] = new Cell(3,6);
		
		Cell[] cs = new Cell[]{
				new Cell(2,5),
				new Cell(2,6),
				new Cell(2,7),
				new Cell(3,6)
		};
		
		int[][] arr = new int[3][];
		arr[0] = new int[2];
		arr[1] = new int[3];
		arr[2] = new int[2];
		arr[1][0] = 100;
		
		int[][] as = new int[3][4]; //3行4列
		for(int i=0;i<as.length;i++){
			for(int j=0;j<as[i].length;j++){
				as[i][j] = 100;
			}
		}
		
	}
}













