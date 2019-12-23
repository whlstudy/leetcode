package leetcode.arrays;


/**
 * @author whl
 * @date 2019/12/23 2:32 下午
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * 简单题，只需要注意有可能比原来数组多产生一个首位（最高位）。
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(new PlusOne().plusOne(new int[]{9, 9, 9, 9}));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1]++;
        for (int i = len - 1; i > 0; i--) {
            if (digits[i] / 10 != 0) {
                digits[i - 1] += digits[i] / 10;
                digits[i] %= 10;
            } else {
                break;
            }
        }
        if (digits[0] / 10 != 0) {
            int[] ret = new int[len + 1];
            System.arraycopy(digits, 0, ret, 1, len);
            ret[0] = ret[1] / 10;
            ret[1] %= 10;
            return ret;
        } else {
            return digits;
        }
    }
}
