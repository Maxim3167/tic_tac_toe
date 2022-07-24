package HomeWorTicTacToe;

import java.util.Scanner;

public class Game {
    private Symbol[][] gameBoard = new Symbol[3][3];

    public Game() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = Symbol.EMPTY;
            }
        }
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите режим игры");
        System.out.println("1.Человек vs Человек");
        System.out.println("2.Человек vs Компьютер");
        System.out.println("3.Компьютер vs Компьютер");
        System.out.println("4.Компьютер vs Компьютер-убийца");
        System.out.println("5.Человек vs Компьютер-убийца");
        Player player1 = null;
        Player player2 = null;
        int input = sc.nextInt();
        if (input == 1) {
            player1 = new Human(gameBoard, Symbol.x);
            player2 = new Human(gameBoard, Symbol.o);
        } else if (input == 2) {
            player1 = new Human(gameBoard, Symbol.x);
            player2 = new Computer(gameBoard, Symbol.o);
        } else if (input == 3) {
            player1 = new Computer(gameBoard, Symbol.x);
            player2 = new Computer(gameBoard, Symbol.o);
        } else if (input == 4) {
            player1 = new ComputerKiller(gameBoard, Symbol.x);
            player2 = new Computer(gameBoard, Symbol.o);
        } else if (input == 5) {
            player1 = new Human(gameBoard, Symbol.x);
            player2 = new ComputerKiller(gameBoard, Symbol.o);
        }
        Player currentPlayer = player1;
        Player oppositePlayer = player2;

        while (true) {
            System.out.println("Ходят " + currentPlayer.nickName);
            currentPlayer.makeStep();
            printBoard();

            if (checkVerticals(gameBoard, currentPlayer.playerSymbol) ||
                    checkGorizontals(gameBoard,currentPlayer.playerSymbol) || checkDiagonals(gameBoard,currentPlayer.playerSymbol)) {
                printBoard();
                System.out.println("Победили " + currentPlayer.nickName);
                break;
            } else if (checkDraw(gameBoard)) {
                printBoard();
                System.out.println("Ничья");
                break;
            }
            Player temp = currentPlayer;
            currentPlayer = oppositePlayer;
            oppositePlayer = temp;
        }
    }

    public void printBoard() {
        for (Symbol[] raw : gameBoard) {
            for (Symbol xoSymbol : raw) {
                System.out.print(xoSymbol);
            }
            System.out.println();
        }
    }

    public boolean checkGorizontals(Symbol[][] gameBoard,Symbol symbol) {
        if (gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol){
            return true;
        } else if ((gameBoard[1][0] == Symbol.o && gameBoard[1][1] == Symbol.o && gameBoard[1][2] == Symbol.o) ||
                gameBoard[1][0] == Symbol.x && gameBoard[1][1] == Symbol.x && gameBoard[1][2] == Symbol.x) {
            return true;
        } else if ((gameBoard[2][0] == Symbol.o && gameBoard[2][1] == Symbol.o && gameBoard[2][2] == Symbol.o) ||
                gameBoard[2][0] == Symbol.x && gameBoard[2][1] == Symbol.x && gameBoard[2][2] == Symbol.x) {
            return true;
        }
        return false;
    }

    public boolean checkVerticals(Symbol[][] gameBoard, Symbol symbol) {
        if (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) {
            return true;
        } else if (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] ==symbol)  {
            return true;
        } else if (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) {
            return true;
        }
        return false;
    }

    public boolean checkDiagonals(Symbol[][] gameBoard,Symbol symbol) {
        if (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol){
            return true;
        } else if (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol){
            return true;
        }
        return false;
    }

    public boolean checkDraw(Symbol[][] gameBoard){
        int counter = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length ; j++) {
                if(gameBoard[i][j] == Symbol.o || gameBoard[i][j] == Symbol.x){
                    counter++;
                }
            }
        }
        if(counter == 9){
            return true;
        }
        return false;
    }
}


