package offer;

public class FindMatrix_4 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(find(20, arr));
    }

    // 走临近最大的才能让时间复杂度达到O(m+n)
    // 否则可能回退，时间复杂度不达标
    public static boolean find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if(target == array[i][j]){
                return true;
            }else if(target > array[i][j]){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
