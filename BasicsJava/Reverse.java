import java.util.*;
public class Reverse {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Please Give The Number For Reversing");
        int num=obj.nextInt();
        int rev=0;
        while(num>0){
            int ld = num%10;
            rev=rev*10+ld;
            num/=10;
        }
        System.out.println("Your Reversed Number Is "+rev);
        obj.close();
    }
}
