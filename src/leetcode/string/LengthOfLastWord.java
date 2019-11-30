package leetcode.string;

import sun.jvm.hotspot.memory.PlaceholderEntry;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World     "));
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length()-1;
        while(i >= 0 && s.charAt(i) == ' ') i--;
        while(i >= 0) {
            if(s.charAt(i) != ' '){
                i--;
                len++;
            }else {
                break;
            }

        }
        return len;
    }
}
