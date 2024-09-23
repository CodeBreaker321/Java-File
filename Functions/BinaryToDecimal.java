import java.util.*;
public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Please Give Me Binary Number");
        int bin = obj.nextInt();
        int cnt=0;
        int dec=0;
        while(bin>0){
            int ld = bin%10;
            dec = (int) (dec + (Math.pow(2.0, cnt++))*ld);
            bin/=10;
        }
        System.out.println("Decimal Is "+dec);
        obj.close();
    }
}
