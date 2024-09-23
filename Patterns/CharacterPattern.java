public class CharacterPattern {
    public static void main(String[] args) {
        char alpha ='A';
        for(int i=0;i<4;i++){
            for(int j=0;j<=i;j++){
                System.out.print(alpha);
                alpha++;
            }
            System.out.println();
        }
    }    
}
