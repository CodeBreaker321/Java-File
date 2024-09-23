import java.util.*;
public class TwoDimenArray {
    public static void display(int arr[][],int r,int c) {
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean search(int arr[][],int r,int c,int key) {
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]==key){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int mat[][] = new int[3][3];
        int r=mat.length;
        int c=mat[0].length;
        System.out.println("Please Give The Array");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j] = obj.nextInt();
            }
        }
        display(mat, r, c);
        System.out.println(search(mat, r, c, 7));
        obj.close();
    }

}
