package Array;
public class BinarySearch {
    public static int getBS(int arr[],int key){
        int low=0;
        int high=arr.length-1;
        while(low<=high){

            int mid = (high+low)/2;
            
            if(key == arr[mid]){
                return mid;
            }
            else if(key>arr[mid]){
                low=mid+1;
            }
            else if(key<arr[mid]){
                high=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60,70,80};
        int key=70;
        int idx = getBS(arr, key);
        if(idx!=-1){
            System.out.println("Number Is At "+idx+" Index");
        }
        else{
            System.out.println("Number Does'nt Exist");
        }

    }
}
