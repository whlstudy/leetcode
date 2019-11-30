package leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        List<String> ret = findWords(board,words);
        System.out.println(ret);

    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (exits(board, word))
                ret.add(word);
        }
        return ret;
    }

    private static boolean exits(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, flag, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] flag, String word, int rowIndex, int colIndex, int wordIndex) {
        if(wordIndex == word.length())
            return true;
        if(rowIndex < 0 || rowIndex >= board.length || colIndex < 0 || colIndex >= board[0].length ||
                flag[rowIndex][colIndex] || board[rowIndex][colIndex] != word.charAt(wordIndex)){
            return false;
        }

        flag[rowIndex][colIndex] = true;
        boolean res = dfs(board, flag, word, rowIndex - 1, colIndex, wordIndex + 1) ||
                dfs(board, flag, word, rowIndex + 1, colIndex, wordIndex + 1) ||
                dfs(board, flag, word, rowIndex, colIndex - 1, wordIndex + 1) ||
                dfs(board, flag, word, rowIndex, colIndex + 1, wordIndex + 1);
        flag[rowIndex][colIndex] = false;
        return res;
    }
}
