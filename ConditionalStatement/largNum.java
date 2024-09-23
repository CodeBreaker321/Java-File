import java.util.*;
public class largNum{
    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        System.out.println("Please Give The First Number");
        int a=obj.nextInt();
        System.out.println("Please Give The Second Number");
        int b=obj.nextInt();
        if(a>b){
            System.out.println("First Number Is Greater");
        }
        else{
            System.out.println("Other Is Greater");
        }
        obj.close();
    }
}