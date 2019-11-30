package offer;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * 要求：时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 */
public class DuplicateNumber_3 {
    public static void main(String[] args) {
        int ret = duplicate(new int[]{2, 3, 1, 0, 2, 5});
        System.out.println(ret);
    }

    // 时间复杂度O(n) 空间复杂度O(1)
    public static int duplicate(int[] arr){
        if(arr == null) return -1;
        for(int i = 0;i < arr.length;){
            if(arr[i] != i){
                if(arr[arr[i]] != arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[arr[i]];
                    arr[temp] = temp;
                }else {
                    return arr[i];
                }
            }else {
                i++;
            }
        }
        return -1;
    }
}
