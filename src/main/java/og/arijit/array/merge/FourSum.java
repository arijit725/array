package og.arijit.array.merge;

import java.util.Arrays;
import java.util.Comparator;

public class FourSum {

	
	
	public static void main(String args[]) {
		int[] array = {10, 2, 3, 4, 5, 9, 7, 8}; 
	    int X = 23 ;
	    
	    findFoursome(array, X);
	}
	public static class Pair {
		int x;
		int y;
		int sum;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
			this.sum = x + y;
		}
	}

	public static void findFoursome(int arr[], int target) {
		int pairArraySize = arr.length * (arr.length - 1) / 2; // nC2
		Pair pairArray[] = new Pair[pairArraySize];
		int k = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				Pair p = new Pair(arr[i], arr[j]);
				pairArray[k] = p;
				k++;
			}
		}
	
		Arrays.sort(pairArray, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.sum - o2.sum;
			}
		});

		int start = 0;
		int end = pairArray.length - 1;
		while (start < end) {
			int sum = pairArray[start].sum + pairArray[end].sum;
			if (sum == target) {
				System.out.println(
						"Foursome: " + pairArray[start].x + " " + pairArray[start].y + " " + pairArray[end].x + " " + pairArray[end].y);
				end--;				
			}
			else if (sum > target)
				end--;
			else
				start++;
		}
	}
}
