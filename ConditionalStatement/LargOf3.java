import java.util.*;
public class LargOf3 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Give The First Number");
        int a=obj.nextInt();
        System.out.println("Please Give Second Number");
        int b=obj.nextInt();
        System.out.println("Please Give The Third Number");
        int c=obj.nextInt();
        if(a>b){
            if(a>c){
                System.out.println("First Is Greater");
            }
            else{
                System.out.println("Third Is Greater");
            }
        }
        else{
            if(b>c){
                System.out.println("Second IS Greater");
            }
            else{
                System.out.println("Third Is Greater");
            }
        }
        obj.close();
    }
}
