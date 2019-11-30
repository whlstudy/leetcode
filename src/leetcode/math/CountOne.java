package leetcode.math;

public class CountOne {
    public static void main(String[] args) {
        System.out.println(count2(20));
    }
    public static int count(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 2;
            num /= 2;
        }
        return sum;
    }

    public static int count1(int num){
        int sum = 0;
        while(num != 0){
            sum += num & 0x01;
            num >>= 1;
        }
        return sum;
    }

    public static int count2(int num){
        int sum = 0;
        while(num != 0){
            num &= (num-1);
            sum++;
        }
        return sum;
    }
}
