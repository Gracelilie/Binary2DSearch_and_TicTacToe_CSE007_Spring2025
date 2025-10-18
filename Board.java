/**
*@author Grace-lilie Acheampong
*@since April 14, 2025 
*@class CSE 007, Homework 6
*@IDE Java, VS Code
*@Descr:  manages all characteristics of game board
*/
public class Board {

    private String[][] board = new String[3][3]; // creating 3X3 array
    private static int count = 1;



    public Board(){  //constructor to initialize elements in array
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = Integer.toString(count);
                count++;
            }
        }

    }
    
    public void printBoard(){ // prints array
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    System.out.print(" " + board[row][col] + " ");
                }
                System.out.println(); // move to next line after each row
            }
    }
    
    /**
    * function that updates a specific position on the board with the player's symbol ("X" or "O").
    * 
    * @param pos  The position to update with new char
    * @param play The player's symbol
    */
    public void changePosition(String pos, String play){
        int val = Integer.parseInt(pos);
        int row = (val - 1) / 3;
        int col = (val - 1) % 3;
        board[row][col] = play;
    }

    /**
     * Checks if a winning condition is met (3 in a row, column, or diagonal).
     * 
     * @param pos The last position played (not used here, but can be helpful in optimization)
     * @return true if a player has won; false otherwise
     */
    
    public boolean checkWin(String pos){
        // Check rows and columns
        for (int row = 0; row < 3; row++) {
            // Check row
            if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) {
                return true;
            }
            // Check column
            if (board[0][row].equals(board[1][row]) && board[1][row].equals(board[2][row])) {
                return true;
            }
    }

    // Check diagonals
    if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
        return true;
    }
    if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
        return true;
    }

    return false;
    }
    
    /**
     * Checks if a given position is valid and not already taken.
     * 
     * @param pos The position entered by the player
     * @return true if the space is valid and free; false otherwise
     */
    public boolean checkSpace(String pos) {
        if (pos.length() == 1 && Character.isDigit(pos.charAt(0))) {
            int val = pos.charAt(0) - '0';
            if (val >= 1 && val <= 9) {
                int row = (val - 1) / 3;
                int col = (val - 1) % 3;
                return !board[row][col].equals("X") && !board[row][col].equals("O");
            }
        }
        return false;
    }
    



}
