package String;
// import java.util.*;
public class StringFunction {
    public static void displayCharacter(String str) {
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
    }
    public static boolean pallindrom(String str){
        int start = 0;
        int end = str.length()-1;
        boolean flag = true;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                flag = false;
                return false;
            }
            ++start;
            --end;
        }
        if(flag == true){
            return true;
        }
        else{
            return false;
        }
    }
    public static double getShortestPath(String str){
        double x=0;
        double y=0;
        for(int i=0;i<str.length();i++){
            char dir = str.charAt(i);
            // North
            if(dir == 'N'){
                x++;
            }
            else if(dir == 'S'){
                x--;
            }
            else if(dir == 'E'){
                y++;
            }
            else{
                y--;
            }
        }
        return Math.sqrt(x*x+y*y);
    }
    public static String subStr(String str,int si,int ei){
        String substr = "";
        for(int i=si;i<ei;i++){
            substr+=str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        // String str = "Gaurav Singh";
        // Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        // System.out.println(s.length());
        // displayCharacter(str);
        // System.out.println(pallindrom("racecar"));
        // System.out.println(getShortestPath("WNEENESENNN"));
        String str="GauravSingh";
        System.out.println(subStr(str, 0, 6));


    }
}