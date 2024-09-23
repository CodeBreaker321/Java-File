package Array;

public class LinearSearch {
    public static int linearSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60,70};
        int key = 40;
        int idx = linearSearch(arr, key);
        if(idx!=-1){
            System.out.println("Item Is At " + idx + "rd Index");
        }
        else{
            System.out.println("Item Is Not Found");
        }
    }
}
