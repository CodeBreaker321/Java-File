import java.util.*;
public class Parity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Give The Number");
        int a=sc.nextInt();
        if(a%2==0){
            System.out.println("Number Is Even");
        }
        else
            System.out.println("Number Is Odd");
        sc.close();
    }
}
