package leetcode.dynamic;

public class StoneGame {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,9,4,4};
        System.out.println(stoneGameII(arr));
    }
    public static int stoneGameII(int[] piles) {
        if(piles.length == 1) return piles[0];
        if(piles.length == 2) return piles[0] + piles[1];
        int m = 1;
        return max;
    }
}
