package exam;

import java.util.HashSet;
import java.util.Set;
//Complete
//https://leetcode.com/problems/valid-sudoku/
public class IsValidSudoku {
    public static void main(String[] args) {
       char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                                    ,{'6','.','.','1','9','5','.','.','.'}
                                    ,{'.','9','8','.','.','.','.','6','.'}
                                    ,{'8','.','.','.','6','.','.','.','3'}
                                    ,{'4','.','.','8','.','3','.','.','1'}
                                    ,{'7','.','.','.','2','.','.','.','6'}
                                    ,{'.','6','.','.','.','.','2','8','.'}
                                    ,{'.','.','.','4','1','9','.','.','5'}
                                    ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 =new char[][] {{'8','3','.','.','7','.','.','.','.'}
                                        ,{'6','.','.','1','9','5','.','.','.'}
                                        ,{'.','9','8','.','.','.','.','6','.'}
                                        ,{'8','.','.','.','6','.','.','.','3'}
                                        ,{'4','.','.','8','.','3','.','.','1'}
                                        ,{'7','.','.','.','2','.','.','.','6'}
                                        ,{'.','6','.','.','.','.','2','8','.'}
                                        ,{'.','.','.','4','1','9','.','.','5'}
                                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));


    }

    public static boolean isValidSudoku(char[][] board) {
        boolean answer = true;

//        Valid Check Each Row
        for(int i = 0 ; i < 9 ; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++) {
                if(board[i][j] != '.') {
                    if(set.contains(board[i][j])) return false;
                    else set.add(board[i][j]);
                }

            }
        }

//        Valid Check Each Column
        for(int i = 0 ; i < 9 ; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++) {
                if(board[j][i] != '.') {
                    if(set.contains(board[j][i])) return false;
                    else set.add(board[j][i]);
                }

            }
        }

//        Valid Check Each Sub-boxes of the grid
//        nine sub-boxes
        int[] centerIdx = {1,4,7};
        int[] idxArray = {-1,0,1};

        for(int i = 0; i < centerIdx.length; i++) {
            for(int j = 0 ; j < centerIdx.length; j++) {
                int nowX = centerIdx[i]
                    ,nowY = centerIdx[j];
                Set<Character> set = new HashSet<>();
                for(int ii = 0 ; ii< idxArray.length; ii++) {
                    for(int jj = 0 ; jj < idxArray.length; jj++) {
                        char nowNum = board[nowX + idxArray[ii]][nowY + idxArray[jj]];
                        if(nowNum != '.' && set.contains(nowNum)) return false;
                        set.add(nowNum);
                    }
                }
            }
        }
        return answer;
    }
}
