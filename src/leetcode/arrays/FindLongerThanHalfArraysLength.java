package leetcode.arrays;

/**
 * 面试题
 * 数组中存在一个数出现次数超过数组长度一半，求这个数
 * 要求时间复杂度为O(n)
 */
public class FindLongerThanHalfArraysLength {

    public static void main(String[] args) {
        System.out.println(find(new int[]{4,4,4,4,232,3,2,2,2,2,2,2,2,2,2,2,22,2,2}));
    }

    public static int find(int[] arr){
        int flag = arr[0];
        int count = 1;
        for(int i = 1;i < arr.length;i++){
            if(flag !=arr[i]){
                count--;
                if(count <= 0){
                    flag = arr[i];
                    count = 1;
                }
            }else {
                count++;
            }
        }
        return flag;
    }
}
