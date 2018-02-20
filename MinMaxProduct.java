import java.util.Collections;
import java.util.PriorityQueue;

public class MinMaxProduct {
	
	public static int findMinMax(int[] arr, int start, int end, boolean minFlag){
		if(end == start){
			return arr[end];
		}
		int mid = (start + end)/ 2;
		if(minFlag == true){
			return Math.min(findMinMax(arr,start,mid,minFlag), findMinMax(arr,mid + 1, end, minFlag));
		}
		else{
			return Math.max(findMinMax(arr,start,mid,minFlag), findMinMax(arr,mid + 1, end, minFlag));
		}
	}
	
	// the logic here is like how winner is selected in a Wimbledon tournament, I am sure many numbers are not happy with the fixtures 
	public static int tournamentProductCalculation(int[] arr1, int[] arr2){
		System.out.println("Am I really not coming here??");
		return  findMinMax(arr1,0,arr1.length - 1, false) * findMinMax(arr2,0,arr2.length - 1, true) ;
	}
	
	// If somebody likes heaps like me
		public static int heapProductCalculation(int[] arr1, int[] arr2){
			PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>();
			for(int item : arr2){
				pqMin.add(item);
			}
			
			PriorityQueue<Integer> pqMax = new PriorityQueue<>(10, Collections.reverseOrder());
			for(int item : arr1){
				pqMax.add(item);
			}
			
			return pqMin.peek() * pqMax.peek();
		}
	
	
	// many like it simple
	public static int simpleProductCalculation(int[] arr1, int[] arr2){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int item: arr1){
			if(item > max){
				max = item;
			}
		}
		for(int item: arr2){
			if(item < min){
				min = item;
			}
		}
		return min * max;
	}
	
	public static int findProduct(int[] arr1, int[] arr2){
		int fate = (int) (Math.random() * 100) ;
		fate = fate % 3;
		int result = 0;
		
		// Sometimes people are crazy
		if(arr1.length == 0 || arr2.length == 0){
			return 0;
		}
		
		switch(fate + 1){
		case 1: result = simpleProductCalculation(arr1, arr2);
				break;
		case 2: result = heapProductCalculation(arr1, arr2);
				break;
		case 3: result = tournamentProductCalculation(arr1, arr2);
				break;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {3,10, -6, 0, -8, 10};
		int[] arr2 = {1,1,1,1,1,1,1,1,1,1,1,1,1,0,-1,-1,-5};
		
		int[] arr3 = {0};
		int[] arr4 = {0};
		
		int[] arr5 = {};
		int[] arr6 = {};
		
		System.out.println(findProduct(arr5, arr6));
	}

}
