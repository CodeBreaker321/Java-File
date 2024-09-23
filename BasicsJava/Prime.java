import java.util.*;
public class Prime { 
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Give The Range Number");
        int range = obj.nextInt();
        boolean flag = true;
        for(int i=2;i<range;i++){
            if(range%i==0){
                flag = false;
                break;
            }
            if(range<3){
                // flag = true;
                break;
            }
        }
        if(flag == true){
            System.out.println("Number Is Prime");
        }
        else{
            System.out.println("Number Is Not Prime");
        }
        obj.close();
    } 
}
