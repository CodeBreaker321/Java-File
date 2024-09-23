import java.util.*;
public class decToBin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Give The Decimal Number");
        int num = sc.nextInt();
        int bin = 0;
        int cnt=0;
        while(num>0){
            int ld = num%2;
            bin = bin + (ld*(int)Math.pow(10,cnt++));
            num/=2;
        }
        System.out.println("THe Binary Number Is "+bin);
        sc.close();
    }
}
