import java.util.Scanner;

public class Elseif {
    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        System.out.println("Please Tell Your Income");
        int Income = obj.nextInt();
        if(Income<500000){
            System.out.println("Your Tax Is 0");
        }
        else if(Income>500000 && Income<1000000){
            System.out.println("YOur Tax Is 20%");
        }
        else{
            System.out.println("Your Tax Is 30%");
        }
        obj.close();
    }
}
