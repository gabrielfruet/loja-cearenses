package br.ufc.stock.exception;

public class InsufficientAmountStockException extends Exception{
    private int amount;

    public InsufficientAmountStockException(int amount) {
        super("Insufficient Amount in Stock: " + amount);
        this.amount = amount;
    }
}