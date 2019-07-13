package com.company;

import java.util.Scanner;

public class ConnectFour {

    // creates the "board"
    public static String[][] createConnectBoardPattern() {

        // There are 15 columns (post, space) for each row
        // 7 rows
        String[][] board = new String[7][15];
        for (int col = 0;col < board.length;col++) {
            for (int row = 0;row < board[col].length;row++) {
                // create post for every other column
                if (row % 2 == 0)
                    board[col][row] ="|";
                else
                    board[col][row] = " ";

                // on the "base" row use dashes
                if (col == 6)
                    board[col][row]= "-";
            }
        }
        return board;
    }

    // Prints out the saved pattern that was created in createConnectBoardPattern()
    public static void printBoardPattern(String[][] board) {
        for (String[] strings : board) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public static void dropPattern(String[][] board, String color) {
        StringBuilder strColor = new StringBuilder();
        if (color.equals("Y")) {
            strColor.append("yellow");
        } else {
            strColor.append("red");
        }

        String message = "Drop a " + strColor + " disk at column (0-6): ";

        Scanner scan = new Scanner (System.in);
        System.out.println(message);
        int col = 2 * scan.nextInt() + 1;

        // check every row from the ground up for the free column (" "), if it's free, replace it with an 'R'
        for (int row = 5;row >= 0;row--) {
            if (board[row][col].equals(" ")) {
                board[row][col] = (color.equals("R") ? "R" : "Y");
                break;
            }
        }
    }

    public static String checkWinner(String[][] board) {
        for (int col = 0;col < 6;col++) {
            for (int row = 0;row < 7;row += 2) {
                if ((board[col][row + 1] != " ")
                        && (board[col][row + 3] != " ")
                        && (board[col][row + 5] != " ")
                        && (board[col][row + 7] != " ")
                        && ((board[col][row + 1] == board[col][row + 3])
                        && (board[col][row + 3] == board[col][row + 5])
                        && (board[col][row + 5] == board[col][row + 7]))
                )
                    return board[col][row + 1];
            }
        }
        for (int col = 1;col < 15;col += 2) {
            for (int row = 0;row < 3;row++) {
                if((board[row][col] != " ")
                        && (board[row + 1][col] != " ")
                        && (board[row + 2][col] != " ")
                        && (board[row + 3][col] != " ")
                        && ((board[row][col] == board[row + 1][col])
                        && (board[row + 1][col] == board[row + 2][col])
                        && (board[row + 2][col] == board[row + 3][col]))
                )
                    return board[row][col];
            }
        }

        for (int col = 0;col < 3;col++) {
            for (int row = 1;row < 9;row += 2) {
                if((board[col][row] != " ")
                        && (board[col + 1][row + 2] != " ")
                        && (board[col + 2][row + 4] != " ")
                        && (board[col + 3][row + 6] != " ")
                        && ((board[col][row] == board[col + 1][row + 2])
                        && (board[col + 1][row + 2] == board[col + 2][row + 4])
                        && (board[col + 2][row + 4] == board[col+3][row + 6])))
                    return board[col][row];
            }
        }

        for (int col = 0;col < 3;col++) {
            for (int row = 7;row < 15;row += 2) {
                if((board[col][row] != " ")
                        && (board[col + 1][row - 2] != " ")
                        && (board[col + 2][row - 4] != " ")
                        && (board[col + 3][row - 6] != " ")
                        && ((board[col][row] == board[col + 1][row - 2])
                        && (board[col + 1][row - 2] == board[col + 2][row - 4])
                        && (board[col + 2][row - 4] == board[col + 3][row - 6])))
                    return board[col][row];
            }
        }
        return null;
    }
}
