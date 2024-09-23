package BitManipulation;
public class BitManipulation {
    public static boolean parity(int n){
        int bitmask = 1;
        if((n & bitmask) == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static int getIthBit (int i,int n){
        int bitmask = 1<<i;
        if((bitmask & n)==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int setIthBit(int i,int n){
        int bitmask = 1<<i;
        return (n | bitmask);
    }
    public static boolean poweroftwo(int n){
        return ((n&n-1))==0;
    }
    public static int countsetbit(int n){
        int cnt=0;
        while(n>0){
            if((n&1)==1){
                cnt++;
            }
            n=n>>1;
        }
        return cnt;
    }
    public static void main(String[] args) {
        // System.out.println(parity(4));
        // System.out.println(parity(5));
        // System.out.println(getIthBit(3, 10));
        // System.out.println(setIthBit(4,1));
        // System.out.println(poweroftwo(10));
        System.out.println(countsetbit(7));
    }
}
