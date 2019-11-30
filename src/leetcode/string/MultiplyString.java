package leetcode.string;

import java.util.Arrays;


/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a leetcode.string.
 */
public class MultiplyString {
    public static void main(String[] args) {
        System.out.println(multiply("123","123"));
    }

    public static String multiply(String num1, String num2) {
        if((num1.length()==1 && num1.equals("0")) || (num2.length()==1 && num2.equals("0"))) return "0";
        int[] ret = new int[num1.length()+num2.length()];
        Arrays.fill(ret,0);
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int flag = 0;
        for(int i = num2.length()-1;i>=0;i--){
            int index = ret.length-1 - flag;
            for(int j = num1.length()-1;j>=0;j--){
                ret[index--] += (arr2[i] - '0') * (arr1[j] - '0');
            }
            flag++;
        }
        for(int i = ret.length-1;i >= 0;i--){
            if(i-1 >= 0){
                ret[i-1] += ret[i] / 10;
            }
            ret[i] %= 10;
        }
        int i = 0;
        if(ret[0] == 0) i++;
        StringBuilder sb = new StringBuilder();
        for(;i < ret.length;i++){
            sb.append(ret[i]);
        }
        return sb.toString();
    }
}
