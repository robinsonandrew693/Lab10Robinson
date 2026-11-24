import java.util.Scanner;

public class TicTacToe {
    //Make game board here so it can be accessed by all methods
    private static String[][] board = new String[3][3];


    //main method - game simulated here
    public static void main(String[] args) {
        //Variables you might want to make
        Scanner scan = new Scanner(System.in);
        String player1 = "X";
        String player2 = "O";
        int p1row;
        int p1col;
        int p2row;
        int p2col;
        boolean player1Valid = false;
        boolean player2Valid = false;
        boolean gameOver = false;
        String playAgain = "";

        do {

            clearBoard(board);
            System.out.println();
            displayBoard(board);

            do {

                do {

                    gameOver = false;

                    p1row = InputHelper.getRangedInt(scan, "Player 1: What row do you choose? [1-3]", 1, 3);
                    p1row = p1row - 1;
                    p1col = InputHelper.getRangedInt(scan, "Player 1: What column do you choose? [1-3]", 1, 3);
                    System.out.println();
                    p1col = p1col - 1;
                    if (isValidMove(p1row, p1col)) {
                        player1Valid = true;
                        board[p1row][p1col] = "X";
                    }
                    else {
                        player1Valid = false;
                        System.out.println("Invalid move. Spot already taken. Try again.");
                    }
                } while (!player1Valid);


                if (isWin(player1)) {
                    System.out.println("Player 1 wins!");
                    System.out.println();
                    gameOver = true;
                    displayBoard(board);
                    break;
                }

                if (isTie(player1, player2)) {
                    System.out.println("It is a tie!");
                    System.out.println();
                    gameOver = true;
                    displayBoard(board);
                    break;
                }

                do {
                    p2row = InputHelper.getRangedInt(scan, "Player 2: What row do you choose? [1-3]", 1, 3);
                    p2row = p2row - 1;
                    p2col = InputHelper.getRangedInt(scan, "Player 2: What column do you choose? [1-3]", 1, 3);
                    p2col = p2col - 1;
                    System.out.println();
                    if (isValidMove(p2row, p2col)) {
                        player2Valid = true;
                        board[p2row][p2col] = "O";
                    }
                    else {
                        player2Valid = false;
                        System.out.println("Invalid move. Spot already taken. Try again.");
                    }
                } while (!player2Valid);

                if (isWin(player2)) {
                    System.out.println("Player 2 wins!");
                    System.out.println();
                    gameOver = true;
                    displayBoard(board);
                    break;
                }

                if (isTie(player1, player2)) {
                    System.out.println("It is a tie!");
                    System.out.println();
                    gameOver = true;
                    displayBoard(board);
                    break;
                }

                displayBoard(board);

            } while (!gameOver);

            playAgain = InputHelper.getYNConfirm(scan, "Do you want to play again? Enter Y/N.");

        } while (playAgain.equalsIgnoreCase("Y"));
    }

    private static void clearBoard(String[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = "-";
            }
        }
    }
    private static void displayBoard(String[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static boolean isValidMove(int row, int col) {
        if (board[row][col].equals("-")) {
            return true;
        }
        else {
            return false;
        }
    }
    private static boolean isWin(String player) {
        if (isColWin(player)) {
            return true;
        }
        else if (isRowWin(player)) {
            return true;
        }
        else if (isDiagonalWin(player)) {
            return true;
        }
        else {
            return false;
        }
    }
    private static boolean isColWin(String player) {
        String firstSpot = "";
        String secondSpot = "";
        String thirdSpot = "";
        boolean didWin = false;
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 0; r < board.length; r++) {
                if (r == 0) {
                    firstSpot = board[r][c];
                }
                else if (r == 1) {
                    secondSpot = board[r][c];
                }
                else if (r == 2) {
                    thirdSpot = board[r][c];
                }
            }
            if (player.equals(firstSpot) && player.equals(secondSpot) && player.equals(thirdSpot)) {
                didWin = true;
            }
        }
        return didWin;
    }
    private static boolean isRowWin(String player) {
        String firstSpot = "";
        String secondSpot = "";
        String thirdSpot = "";
        boolean didWin = false;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (col == 0) {
                    firstSpot = board[row][col];
                }
                else if (col == 1) {
                    secondSpot = board[row][col];
                }
                else if (col == 2) {
                    thirdSpot = board[row][col];

                }
            }
            if (player.equals(firstSpot) && player.equals(secondSpot) && player.equals(thirdSpot)) {
                didWin = true;
            }
        }
        return didWin;
    }
    private static boolean isDiagonalWin(String player) {
        String corner1 = board[0][0];
        String corner2 = board[0][2];
        String corner3 = board[2][0];
        String corner4 = board[2][2];
        String middle = board [1][1];
        if (player.equals(corner1) && player.equals(middle) && player.equals(corner4)) {
            return true;
        }
        else if (player.equals(corner2) && player.equals(middle) && player.equals(corner3)) {
            return true;
        }
        else {
            return false;
        }
    }
    private static boolean isTie(String player1, String player2) {
        int freeSpot = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c].equals("-")) {
                    freeSpot++;
                }
            }
        }
        if (freeSpot > 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
