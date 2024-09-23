package Recursion;
public class Recursion {
    public static void backcounting(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n+" ");
        backcounting(n-1);

    }
    public static void counting(int i,int n){
        if(i==n){
            System.out.println(n);
            return;
        }
        System.out.println(i+" ");
        counting(++i,n);
    }
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial((n-1));
    }
    public static int summision(int n){
        if(n==1){
            return 1;
        }
        return n+summision(n-1);
    }
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);

    }
    public static int getIndex(int arr[],int key,int i){
        if(i==0){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return getIndex(arr, key, --i);
    }
    public static int xToPowerN(int x,int n){
        if(n==0){
            return 1;
        }
        return x*xToPowerN(x, n-1);
    }
    public static int aToPowerb(int a,int b){
        if(b==0){
            return 1;
        }
        if(b%2==0)
            return aToPowerb(a, b/2) * aToPowerb(a, b/2);
        
        else
            return aToPowerb(a, b/2) * aToPowerb(a, b/2) * a;
    }
    public static void main(String[] args) {
        // backcounting(5);
        // counting(1, 10);
        // System.out.println(factorial(7));
        // System.out.println(summision(10));
        // System.out.println(fibonacci(7));
        // int arr[] = {8,1,4,3,2,5,4,8,1,9};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(getIndex(arr, 1, 9));
        System.out.println(aToPowerb(3, 5));
    }
}
