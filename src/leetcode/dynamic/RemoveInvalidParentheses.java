package leetcode.dynamic;

import java.util.*;

/**
 * @author whl
 * @date 2019/11/11 4:16 下午
 * <p>
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * 因为需要找到所有可能的最小解，所以只可能是深度优先搜索或者广度优先搜索
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(dfsResolve("()())()"));
    }
    // dfs
    public static List<String> dfsResolve(String s) {
        int leftToRem = 0, rightToRem = 0;
        // 计算删除左右括号数，作为递归返回条件
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftToRem++;
            } else if (ch == ')') {
                if (leftToRem > 0)
                    leftToRem--;
                else
                    rightToRem++;
            }
        }

        List<String> ret = new LinkedList<>();
        dfs(ret, new StringBuilder(), s, leftToRem, rightToRem, 0, 0);

        return ret;
    }

    private static void dfs(List<String> ret, StringBuilder sb, String s, int leftToRem, int rightToRem, int open, int curPos) {
        if (curPos == s.length() && rightToRem == 0 && leftToRem == 0 && open == 0) {
            ret.add(sb.toString());
        }
        if (leftToRem < 0 || rightToRem < 0 || open < 0 || curPos >= s.length()) return;
        int curLen = sb.length();
        char ch = s.charAt(curPos);
        boolean skip = curLen > 0 && sb.charAt(curLen - 1) == ch; // 连续相同的只删除第一个，为了去重
        if (ch == '(') {
            if(!skip) dfs(ret, sb, s, leftToRem - 1, rightToRem, open, curPos + 1);
            dfs(ret, sb.append(ch), s, leftToRem, rightToRem, open + 1, curPos + 1);
        } else if (ch == ')') {
            if(!skip) dfs(ret, sb, s, leftToRem, rightToRem - 1, open, curPos + 1);
            dfs(ret, sb.append(ch), s, leftToRem, rightToRem, open - 1, curPos + 1);
        } else {
            dfs(ret, sb.append(ch), s, leftToRem, rightToRem, open, curPos + 1);
        }

        sb.setLength(curLen); // 因为可能添加也可能没有添加元素所以是有这个函数，如果添加就删除，如果没添加就不变
    }


    // bfs
    // 计算了，小于等于最小删除个数的所有情况
    private List<String> bfsResolver(String s){
        Queue<String> bfsQ = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> result = new LinkedList<>();
        int resLen = -1;
        visited.add(s);
        bfsQ.add(s);
        while(!bfsQ.isEmpty()){
            String curS = bfsQ.poll();
            if(resLen != -1 && curS.length() < resLen) break;
            if(isValid(curS)){
                resLen = curS.length();
                result.add(curS);
            }

            for(int i = 0;i < curS.length();i++){
                if( i > 0 && curS.charAt(i) == curS.charAt(i-1)) continue;
                String nextS = curS.substring(0,i) + curS.substring(i+1);
                if(visited.contains(nextS)) continue;
                visited.add(nextS);
                bfsQ.add(nextS);
            }
        }
        return result;
    }

    private boolean isValid(String str){
        int count = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == '(') count++;
            else if(str.charAt(i) == ')') {
                if(count > 0)
                    count--;
                else
                    return false;
            }
        }
        return count == 0;
    }
}
