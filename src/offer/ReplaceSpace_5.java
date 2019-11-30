package offer;

public class ReplaceSpace_5 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }

    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }
}
