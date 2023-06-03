package br.ufc.stock.exception;

public class NegativeAmountException extends Exception{
    private int amount;

    public NegativeAmountException(int amount) {
        super("Negative amount: " + amount + " isn't permitted.");
        this.amount = amount;
    }
}
