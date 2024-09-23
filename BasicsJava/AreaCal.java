import java.util.*;
public class AreaCal{
    public static void main(String arg[]){
        System.out.println("Please Give Me The Radius");
        Scanner obj = new Scanner(System.in);
        int radius = obj.nextInt();
        System.out.println(3.14*radius*radius);
        obj.close();
    }
}