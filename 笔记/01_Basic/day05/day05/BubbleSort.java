package day05;
//冒泡排序
public class BubbleSort {
	public static void main(String[] args){
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		for(int i=0;i<arr.length-1;i++){ //控制轮数
			for(int j=0;j<arr.length-1-i;j++){ //控制次数
				if(arr[j]>arr[j+1]){ //每一次都和它的下一个元素比
					int t=arr[j];  //若满足则交换
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		System.out.println("排序后:");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
