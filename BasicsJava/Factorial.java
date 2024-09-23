import java.util.*;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give The Number To Find Its Factorial");
        int number = sc.nextInt();
        int factorial = 1;
        for(int i=1;i<=number;i++){
            factorial *=i; 
        }
        System.out.println("Factorial Of Given Number Is "+factorial);
        sc.close();
    }    
}
