package leetcode.dynamic;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}
        };
        System.out.println(exist(board, "eat"));
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col]; // 标志数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, flag, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] flag, String word, int rowIndex, int colIndex, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        }

        if (rowIndex < 0 || rowIndex >= board.length || colIndex < 0 || colIndex >= board[0].length ||
                board[rowIndex][colIndex] != word.charAt(wordIndex) || flag[rowIndex][colIndex]) {
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
