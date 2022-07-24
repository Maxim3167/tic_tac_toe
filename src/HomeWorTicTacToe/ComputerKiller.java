package HomeWorTicTacToe;

import java.util.Random;

public class ComputerKiller extends Computer {
    Random rnd = new Random();

    public ComputerKiller(Symbol[][] gameBoard, Symbol playerSymbol) {
        super(gameBoard, playerSymbol);
    }

    @Override
    public void makeStep() {
        int i = 0;
        int j = 0;
        if(checkPosition(gameBoard) != null) {
            String[] array = checkPosition(gameBoard).split(" ");
            i = Integer.parseInt(array[0]);
            j = Integer.parseInt(array[1]);
            int random = rnd.nextInt(2);
            if (random == 0) {
                System.out.println("Действую,как обычный компютер");
                super.makeStep();
            } else {
                System.out.println("Ставлю свой символ");
                gameBoard[i][j] = playerSymbol;
            }
        }
        else super.makeStep();
    }


    public String checkPosition(Symbol[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] != playerSymbol && gameBoard[i][j] != Symbol.EMPTY) {
                    return i + " " + j;
                }
            }
        }
        return null;
    }
}




