package leetcode.string;


/**
 * 实现toLowerCase()函数
 *
 * 时间复杂度为O(n)
 */
public class ToLowerCase {
    public static void main(String[] args){
        System.out.println(toLowerCase("AaAaAa12123123SSDADSNDAJD"));
    }

    public static String toLowerCase(String str){
        StringBuilder sb = new StringBuilder(str.length());
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) <= 'z' && str.charAt(i) >= 'a'){
                sb.append(str.charAt(i));
            }else {
                if(str.charAt(i) <= 'Z' && str.charAt(i) >= 'A'){
                    sb.append((char)(str.charAt(i)+32));
                }else {
                    sb.append(str.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
