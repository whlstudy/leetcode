package leetcode.string;

public class CountAndSay {

    public static void main(String[] args){
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(1);
        while(n-- > 1){
            char temp = sb1.charAt(0);
            int j = 1;
            for(int i = 1;i < sb1.length();i++){
                if(temp == sb1.charAt(i)){
                    j++;
                }else {
                    sb2.append(j).append(temp);
                    temp = sb1.charAt(i);
                    j = 1;
                }
            }
            sb2.append(j).append(temp);
            sb1.delete(0,sb1.length());
            sb1.append(sb2);
            sb2.delete(0,sb2.length());
        }
        return sb1.toString();
    }
}
