package College;
public class Experiment1{
    public static int linearSearch(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        else{
            return linearSearch(arr, key, i+1);
        }
    }
    public static int binarySearch(int arr[],int key,int si,int ei){
        int mid = si + (ei-si)/2;
        if(si > ei){
            return -1;
        }
        if(arr[mid]==key){
            return mid;
        }
        if(arr[mid]>key){
            return binarySearch(arr, key, si, mid-1);
        }
        else{
            return binarySearch(arr, key, mid+1, ei);
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60,70};
        System.out.println(binarySearch(arr, 30, 0,6));
    }
}