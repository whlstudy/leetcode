package leetcode.math;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt1(2147395599));
    }

    // 二分法
    public static int mySqrt(int x) {
        if (x == 1) return 1;
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right) / 2;
            if (mid * mid == x || (mid * mid < x && (mid + 1) * (mid + 1) > x)) {
                return (int) mid;
            } else if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return 0;
    }

    static int s;

    public static int mySqrt1(int x){
        s = x;
        if(x == 0) return 0;
        return (int)sqrts(x);
    }


    // 牛顿迭代法
    public static double sqrts(double x) {
        double res = (x + s / x) / 2;
        if(res == x){
            return x;
        }else {
            return sqrts(res);
        }
    }
}
