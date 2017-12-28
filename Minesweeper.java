package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

/* #529. Minesweeper
 * href: https://leetcode.com/problems/minesweeper/description/ */
public class Minesweeper {
    
    public static ArrayList<Point> getAdjacentBlocks(char[][] board, int x, int y){
        ArrayList<Point> list = new ArrayList<>();
        final int x_max = board.length;
        final int y_max = board[0].length;
        
        /* Upper Row */
        if(x-1 >= 0){
            if(y-1 >= 0) list.add(new Point(x-1, y-1));
            list.add(new Point(x-1, y));
            if(y+1 < y_max) list.add(new Point(x-1, y+1));
        }
        
        /* Current row */
        if(y-1 >= 0) list.add(new Point(x, y-1));
        if(y+1 < y_max) list.add(new Point(x, y+1));
        
        /* Bottom Row */
        if(x+1 < x_max){
            if(y-1 >= 0) list.add(new Point(x+1, y-1));
            list.add(new Point(x+1, y));
            if(y+1 < y_max) list.add(new Point(x+1, y+1));
        }
        
        return list;
    }
    
    public static int countAdjacentMines(char[][] board, ArrayList<Point> list){
        int count = 0;
        
        for(Point p:list){
            if(board[p.x][p.y] == 'M') count++;
        }
        
        return count;
    }
    
    public static char[][] solve(char[][] board, int[] click){
        final int x = click[0];
        final int y = click[1];
        
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        
        if(board[x][y] == 'E'){
            ArrayList<Point> list = getAdjacentBlocks(board, x, y);
            int mineCount = countAdjacentMines(board, list);
            if(mineCount == 0){
                board[x][y] = 'B';
                for(Point p:list){
                    solve(board, new int[]{p.x, p.y});
                }
            }else{
                board[x][y] = (char) ('0' + mineCount);
            }
        }
        
        return board;
    }

    
    @Test
    public void test(){
        char[][] board_1 = {
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'}
        };
        
        char[][] expected_1 = {
            {'B', '1', 'E', '1', 'B'},
            {'B', '1', 'M', '1', 'B'},
            {'B', '1', '1', '1', 'B'},
            {'B', 'B', 'B', 'B', 'B'}
        };
        
        test(expected_1, board_1, new int[]{3,0});
    }
    
    public void test(char[][] expected, char[][] board, int[] click){
        char[][] actual = solve(board, click);
        
        for(int i=0; i<actual.length; i++){
            assertArrayEquals(expected[i], actual[i]);
        }
    }
}
