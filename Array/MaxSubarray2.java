package Array;
public class MaxSubarray2 {
    public static void main(String[] args) {
        int arr[] = {1,-2,6,-1,3};
        // int range1 = 2;
        // int range2 = 4;
        int max_sum = Integer.MIN_VALUE;
        int prefixsum[] = new int[arr.length];
        prefixsum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixsum[i]=prefixsum[i-1]+arr[i];
        }
        // int sum = prefixsum[range2] - prefixsum[range1-1];
        // System.out.println("The Sum IS "+sum);
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){

                int sum = i==0 ? prefixsum[j] : prefixsum[j] - prefixsum[i-1];
                if(sum > max_sum){
                    max_sum=sum;
                }
            }
        }
        System.out.println("The Greatest Number Is "+ max_sum);
    }
}
