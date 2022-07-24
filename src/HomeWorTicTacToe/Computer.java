package HomeWorTicTacToe;

import java.util.Random;

public class Computer extends Player {
    private Random rnd = new Random();

    public Computer(Symbol[][] gameBoard, Symbol playerSymbol) {
        super(gameBoard, playerSymbol);
    }

    @Override
    public void makeStep() {

        //если row col существуют, если ячейка в них свободна, то вставляем символ
        //пока это условие не выполнено, крутим цикл
        int row = 0;
        int col = 0;
        while (true) {
            row = rnd.nextInt(gameBoard.length);
            col = rnd.nextInt(gameBoard.length);
            if (gameBoard[row][col] != Symbol.EMPTY) {
                continue;
            }
            else gameBoard[row][col] = playerSymbol;
            break;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
