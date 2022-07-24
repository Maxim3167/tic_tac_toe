package HomeWorTicTacToe;

import java.util.Scanner;

public class Human extends Player {
    private Scanner sc = new Scanner(System.in);

    public Human(Symbol[][] gameBoard, Symbol playerSymbol) {
        super(gameBoard, playerSymbol);
    }

    @Override
    public void makeStep() {
        int row = 0;
        int col = 0;
        while (true) {
            System.out.println("Input row");
            row = sc.nextInt();
            System.out.println("Input col");
            col = sc.nextInt();
            if(gameBoard[row][col] == Symbol.o || gameBoard[row][col] == Symbol.x){
                System.out.println("Позиция занята, введите другую");
                continue;
            }
            if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && gameBoard[row][col] == Symbol.EMPTY) {
                gameBoard[row][col] = playerSymbol;
                break;
            }
        }
    }
}
