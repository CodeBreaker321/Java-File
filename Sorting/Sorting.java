package Sorting;
public class Sorting {
    public static void bubblesort(int arr[]){
        for(int turn = 0 ; turn<arr.length-1; turn++){
            for(int j = 0 ; j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void selectionsort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int mini = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[mini]){
                    mini = j;
                }
            }
            //swapping
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionsort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length-1;j++){

            }
        }
    }
    public static void mergesort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergesort(arr,si,mid);
        mergesort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }

        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for(int b=0,a=si;b<temp.length;b++,a++){
            arr[a] = temp[b];
        }
    }
    public static void printarr(int arr[]) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quicksort(int arr[],int si,int ei){
        if(si >= ei){
            return;
        }
        int pixd = partition(arr, si, ei);
        quicksort(arr, si, pixd-1);
        quicksort(arr, pixd+1, ei);
    }
    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i = si-1;

        for(int j=si;j<ei;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }
    public static int sortedRotatedArr(int arr[],int target,int si,int ei){
        if(si > ei){
            return -1;
        }
        int mid = si + (ei-si)/2;
        
        if(arr[mid] == target){
            return mid;
        }
        if(arr[si] <= arr[mid]){
            if(arr[si]<=target && target<=arr[mid]){
                return sortedRotatedArr(arr, target, si, mid-1);
            }
            else{
                return sortedRotatedArr(arr, target, mid+1, ei);
            }
        }
        else{
            if(arr[mid]<=target && target<=arr[ei]){
                return sortedRotatedArr(arr, target, mid+1, ei);
            }
            else{
                return sortedRotatedArr(arr, target, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        // int arr[] = {5,3,1,4,2};
        // selectionsort(arr);
        // quicksort(arr, 0, 4);
        int arr[] = {4,5,6,7,0,1,2};
        int idx=sortedRotatedArr(arr, 0, 0, arr.length-1);;
        // printarr(arr);\
        System.out.println(idx);
    }
}