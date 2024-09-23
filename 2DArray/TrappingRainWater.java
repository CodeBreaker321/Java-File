public class TrappingRainWater {
    public static void main(String[] args) {
        int height[] = {4,2,0,3,2,5};
        int totalwater=0;
        // right most boundary
        int rightmost[] = new int[height.length];
        rightmost[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightmost[i] = Math.max(height[i],rightmost[i+1]);
        }
        // left most boundary
        int leftmost[] = new int[height.length];
        leftmost[0] = height[0];
        for(int i=1;i<height.length;i++){
            leftmost[i] = Math.max(height[i],leftmost[i-1]);
        }
        // total water
        for(int i=0;i<height.length;i++){
            int water = Math.min(leftmost[i], rightmost[i]);
            totalwater += water - height[i];
        }
        System.out.println(totalwater);
        // for(int i=0;i<height.length;i++){
            // System.out.println(rightmost[i]);
            // System.out.println(rightmost[i]);
        // }
    }
}
