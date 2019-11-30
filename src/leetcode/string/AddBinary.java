package leetcode.string;

/**
 * Given two binary strings, return their sum (also a binary leetcode.string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary1("111", "1"));
    }

    /**
     * faster than 72% , Memory usage: less than 100%
     * <p>
     * 使用了函数调用增加时间开销
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int temp = 0;
        while (lenA > 0 && lenB > 0) {
            int a1 = parse(a.charAt(lenA - 1));
            int b1 = parse(b.charAt(lenB - 1));
            if (a1 + b1 + temp == 2) {
                sb.append(0);
                temp = 1;
            } else if (a1 + b1 + temp == 3) {
                sb.append(1);
                temp = 1;
            } else {
                sb.append(a1 + b1 + temp);
                temp = 0;
            }
            lenA--;
            lenB--;
        }
        while (lenA > 0) {
            int a1 = parse(a.charAt(lenA - 1));
            if (a1 + temp == 2) {
                sb.append(0);
                temp = 1;
            } else {
                sb.append(a1 + temp);
                temp = 0;
            }
            lenA--;
        }

        while (lenB > 0) {
            int b1 = parse(b.charAt(lenB - 1));
            if (b1 + temp == 2) {
                sb.append(0);
                temp = 1;
            } else {
                sb.append(b1 + temp);
                temp = 0;
            }
            lenB--;
        }

        if (temp == 1) {
            sb.append(temp);
        }

        return sb.reverse().toString();
    }

    public static int parse(char ch) {
        if (ch == '1') return 1;
        else return 0;
    }

    /**
    * faster than 100% , Memory usage: less than 100%
    */
    public static String addBinary1(String a, String b) {
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();

        while (lenA > 0 || lenB > 0) {
            int sum = temp;
            if (lenA > 0) sum += a.charAt(lenA-- - 1) - '0';
            if (lenB > 0) sum += a.charAt(lenB-- - 1) - '0';
            sb.append(sum % 2);
            temp = sum / 2;
        }
        if(temp > 0) sb.append(temp);
        return sb.reverse().toString();
    }
}
