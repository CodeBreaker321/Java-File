package Array;
public class MaxSubarraySum {
    public static void main(String[] args) {
        int prevsum = 0;
        int arr[] = {10,20,30,40,50};
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                System.out.println(sum);
                if(sum>prevsum){
                    prevsum=sum;
                }
            }
            System.out.println();
        }
        System.out.println("The Maximum Sum Is "+prevsum);
    }
}
