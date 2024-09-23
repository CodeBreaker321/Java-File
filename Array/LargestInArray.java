package Array;
public class LargestInArray {
    public static int largest(int arr[]){
        int lar = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>lar){
                lar=arr[i];
            }
        }
        return lar;
    }
        public static void main(String[] args) {
            int arr[] = {10,14,22,42,43,53,13,42,88,98,34,54,65,76,88,46,86,46};
            int idx = largest(arr);
            System.out.println("The Largest Element Among Array Is "+idx);
        }
}
