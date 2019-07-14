package com.company;

public class TesterClass {

    public static void main (String[] args) {
        String[][] f = ConnectFour.createConnectBoardPattern();

        boolean done = false;
        int turn = 0;
        ConnectFour.printBoardPattern(f);
        while(!done) {
            if (turn % 2 == 0)
                ConnectFour.dropPattern(f, "R");
            else
                ConnectFour.dropPattern(f, "Y");
            turn++;
            ConnectFour.printBoardPattern(f);

            if (ConnectFour.checkWinner(f) != null) {
                if (ConnectFour.checkWinner(f) == "R")
                    System.out.println("The red player won.");
                else if (ConnectFour.checkWinner(f)== "Y")
                    System.out.println("The yello player won.");
                done = true;
            }
        }
    }
}
