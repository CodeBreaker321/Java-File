package ArrayList;
import java.util.*;
    public class Arraylist{
        public static int maximumNumber(ArrayList<Integer> list){
            int maxi = Integer.MIN_VALUE;
            for(int i=0;i<list.size();i++){
                if(list.get(i)>maxi){
                    maxi = list.get(i);
                }
            }  
            return -1;
        }
        public static void printArr(ArrayList<Integer> list){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
        public static void printRevArr(ArrayList<Integer> list){
            for(int i=list.size()-1;i>=0;i--){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
        public static void swap(ArrayList<Integer> list, int idx1, int idx2){
            int temp = list.get(idx1);
            list.set(idx1,list.get(idx2));
            list.set(idx2,temp);
        }
        public static boolean pairSum(ArrayList<Integer> list,int key){
            int leftptr = 0;
            int rightptr = list.size()-1;
            while(rightptr>leftptr){
                if (list.get(leftptr)+list.get(rightptr)==key) {
                    return true;
                }
                else if(list.get(leftptr)+list.get(rightptr)>key){
                    rightptr--;
                }
                else{
                    leftptr++;
                }
            }
            return false;
        }
        public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        // System.out.println(list);
        // //Get Element
        // System.out.println(list.get(2));
        // //Remove Element
        // list.remove(2);
        // System.out.println(list);
        // list.set(5, 80);
        // System.out.println(list);
        // //Contains
        // System.out.println(list.contains(20));
        // System.out.println(list.contains(90));
        // swap(list,0,6);
        // printArr(list);
        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);
            System.out.println(pairSum(list, 50));
    }
    }
