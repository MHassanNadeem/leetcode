package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/* #419. Battleships in a Board
 * href: https://leetcode.com/problems/battleships-in-a-board/description/ */
public class CountBattleships {
    
    public static int solve(char[][] board){
        int count = 0;
        final int iSize = board.length;
        final int jSize = board[0].length;
        
        for(int i=0; i<iSize; i++){
            for(int j=0; j<jSize; j++){
                if(board[i][j] == 'X'){
                    count++;
                    if(i+1<iSize && board[i+1][j] == 'X') count--; // this boat will be discovered when next row is scanned
                    while(j<jSize && board[i][j] == 'X') j++; // skip horizontally placed ships
                }
            }
        }
        
        return count;
    }

    
    @Test
    public void test(){
        char[][] board_1 = new char[][] {
            {'X','.','.','X'},
            {'.','.','.','X'},
            {'.','.','.','X'},
        };
        assertEquals(2, solve(board_1));
        
        char[][] board_2 = new char[][] {
            {'X','.','.','X'},
            {'X','.','.','X'},
            {'X','.','.','X'},
        };
        assertEquals(2, solve(board_2));
        
        char[][] board_3 = new char[][] {
            {'X','.','.','X'},
            {'X','.','.','X'},
            {'.','X','.','X'},
        };
        assertEquals(3, solve(board_3));
        
        char[][] board_4 = new char[][] {
            {'X','X','X','X'},
            {'.','.','.','.'},
            {'.','X','.','X'},
        };
        assertEquals(3, solve(board_4));
        
        char[][] board_5 = new char[][] {
            {'X','.','X','X'},
            {'.','.','.','.'},
            {'.','X','.','X'},
        };
        assertEquals(4, solve(board_5));
    }
}
