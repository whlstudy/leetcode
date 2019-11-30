package leetcode.arrays;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        int x = 0;
        for(int i = 0;i < nums.length;i++){
            x ^= nums[i];
        }
        return x;
    }
}
