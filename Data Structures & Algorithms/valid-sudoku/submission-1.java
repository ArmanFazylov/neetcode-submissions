/*
    Solution using Single pass via map of sets 
    time is still: O(n^2), space though is O(n^2) 
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') continue;
             
                // use Map compute if absent to auto-create set (and return it) if not exists   
                Set<Character> row = rows.computeIfAbsent(r, x -> new HashSet<>());
                if (row.contains(board[r][c])) return false;
                row.add(board[r][c]);

                Set<Character> col = cols.computeIfAbsent(c, x -> new HashSet<>());
                if (col.contains(board[r][c])) return false;
                col.add(board[r][c]);

                // there are 3 box rows and 3 box cols
                // so to identify which box will div by 3
                // i.e. cell at r = 1, will belong to box at box-row 0
                // cell at r = 4,  will belong to box-row 1 etc.
                String boxKey = (r / 3) + "," + (c / 3);
                Set<Character> box = boxes.computeIfAbsent(boxKey, x -> new HashSet<>());
                if (box.contains(board[r][c])) return false;
                box.add(board[r][c]);
            }
        }
        return true;
    }
}
