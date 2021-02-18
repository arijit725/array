package og.arijit.array.optimization;

public class SubarrayWithLeastAvg {

    public static void main(String args[]){
        int arr[] = {3, 7, 90, 20, 10, 50, 40};
        int k = 3;
        findLeastAvg(arr,k);
    }

    public  static  void findLeastAvg(int[] array, int k){
        if(array==null || array.length<k)
            return;
        int start = 0;
        int end =0;
        int sum = 0;
        int avgSoFar = Integer.MAX_VALUE;
        int pos1=0;
        int pos2=0;
        int i=0;
        while(end<array.length){

            if(i<k){
                sum = sum+array[end];
                i++;
                end++;
            }
            else{
                int avg = sum/k;
                if(avg<avgSoFar){
                    avgSoFar = avg;
                    pos1 = start;
                    pos2=end-1;
                }
                sum = sum-array[start];
                start++;
                i--;
            }

        }
        System.out.println("Least Average: "+avgSoFar+" start: "+pos1+" end: "+pos2);
    }
}
