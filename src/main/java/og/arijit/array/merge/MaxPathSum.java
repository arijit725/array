package og.arijit.array.merge;

/**
 * Given two sorted arrays such the arrays may have some common elements. Find
 * the sum of the maximum sum path to reach from beginning of any array to end
 * of any of the two arrays. We can switch from one array to another array only
 * at common elements. Note that the common elements do not have to be at same
 * indexes
 * 
 * Complexity : O(m+n)
 * @author ARIJIT
 *
 */
public class MaxPathSum {

	public static int findMaxPathSum(int ar1[], int ar2[]) {
		int i = 0;
		int j = 0;
		int sum1 = 0;
		int sum2 = 0;
		int maxSum = 0;
		while (i < ar1.length && j < ar2.length) {
			if (ar1[i] < ar2[j]) {
				sum1 = sum1 + ar1[i++];
			} else if (ar2[j] < ar1[i]) {
				sum2 = sum2 + ar2[j++];
			} else if (ar1[i] == ar2[j]) {
				maxSum = maxSum + Math.max(sum1, sum2) + ar1[i];
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;
			}
		}
		while (i < ar1.length) {
			sum1 = sum1 + ar1[i++];
		}
		while (j < ar2.length) {
			sum2 = sum2 + ar2[j++];
		}
		maxSum = maxSum + Math.max(sum1, sum2);
		return maxSum;
	}

	public static void main(String args[]) {
//		int ar1[]= {2,3,7,10,12,15,30,34};
//		int ar2[]= {1,5,7,8,10,15,16,19};

		int ar1[] = { 10, 12 };
		int ar2[] = { 5, 7, 9 };

		int maxSum = findMaxPathSum(ar1, ar2);
		System.out.println("MaxSum:" + maxSum);
	}
}
