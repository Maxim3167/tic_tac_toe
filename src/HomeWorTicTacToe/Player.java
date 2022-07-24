package HomeWorTicTacToe;

public class Player {
    protected Symbol[][] gameBoard;
    protected Symbol playerSymbol;
    protected String nickName;

    public Player(Symbol[][] gameBoard, Symbol playerSymbol) {
        this.gameBoard = gameBoard;
        this.playerSymbol = playerSymbol;
        if(playerSymbol == Symbol.x){
            nickName = "Крестики";
        }else{
            nickName = "Нолики";
        }
    }

    public void makeStep(){

    }
}
