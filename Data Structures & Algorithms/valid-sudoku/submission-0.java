
/*
    Brute force solution 
    Time: O(1) [or O(N^2) if generalized for an N x N grid]
    Space: O(1) always 9 elements set
*/


class Solution {


    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) 
            if (!isValidRow(board, r)) return false;
        for (int c = 0; c < 9; c++) 
            if (!isValidCol(board, c)) return false;
        for (int r = 0; r < 9; r = r + 3) {
            for (int c = 0; c < 9; c = c + 3) {
                if (!isValidBox(board, r, c)) return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int r) {
        Set<Integer> set = new HashSet<>();
        for (int c = 0; c < 9; c++) {
            if (board[r][c] != '.') {
                Integer v = Integer.parseInt(String.valueOf(board[r][c]));
                if (set.contains(v)) return false;
                set.add(v);
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int c) {
        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            if (board[r][c] != '.') {
                Integer v = Integer.parseInt(String.valueOf(board[r][c]));
                if (set.contains(v)) return false;
                set.add(v);
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int r, int c) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r + i][c + j] != '.') {
                    Integer v = Integer.parseInt(String.valueOf(board[r + i][c + j]));
                    if (set.contains(v)) return false;
                    set.add(v);
                }
            }
        }
        return true;
    }
}
