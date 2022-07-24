package HomeWorTicTacToe;

public enum Symbol {
    x("|x|"),o("|o|"),EMPTY("|_|");
    private String name;

    Symbol(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
