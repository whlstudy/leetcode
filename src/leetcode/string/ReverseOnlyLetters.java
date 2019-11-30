package leetcode.string;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public static String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (isChar(S.charAt(i)))
                sb.append(S.charAt(i));
        }
        StringBuilder ret = new StringBuilder();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (isChar(S.charAt(i))) {
                ret.append(sb.charAt(i - count));
            } else {
                ret.append(S.charAt(i));
                count++;
            }
        }
        return ret.toString();
    }
    static boolean isChar(char ch){
        return (ch <= 'Z' && ch >= 'A') || (ch <= 'z' && ch >= 'a');
    }
}
