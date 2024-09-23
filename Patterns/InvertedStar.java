// package Patterns;

public class InvertedStar {
    public static void main(String[] args) {
        int dept = 4;
        for(int i=0;i<dept;i++){
            for(int j=0;j<dept-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
