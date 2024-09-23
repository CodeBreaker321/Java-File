package Array;
public class PairsInArray {
    public static void getPair(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+")");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60,70,80,90};
        getPair(arr);
    }        
}
