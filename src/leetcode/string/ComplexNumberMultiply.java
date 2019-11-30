package leetcode.string;

/**
 *  Given two strings representing two complex numbers.
 *
 * You need to return a leetcode.string representing their multiplication. Note i2 = -1 according to the definition.
 */
public class ComplexNumberMultiply {
    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i","2+-2i"));
    }

    /**
     * notify the + and i
     */
    public static String complexNumberMultiply(String a, String b) {
        int index0 = a.indexOf('+');
        int index1 = a.indexOf('i');
        Integer arg0 = Integer.valueOf(a.substring(0, index0));
        Integer arg1 = Integer.valueOf(a.substring(index0 + 1, index1));

        int index2 = b.indexOf('+');
        int index3 = b.indexOf('i');
        Integer arg2 = Integer.valueOf(b.substring(0, index2));
        Integer arg3 = Integer.valueOf(b.substring(index2 + 1, index3));

        return (arg0*arg2 - arg1*arg3) + "+" + (arg0*arg3+arg1*arg2) + "i";
    }
}
