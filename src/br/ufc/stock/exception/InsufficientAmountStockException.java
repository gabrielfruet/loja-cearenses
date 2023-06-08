/**
 * pedrofalcao10
 * The InsufficientAmountStockException class represents an exception that is thrown
 * when there is an insufficient amount of items in a stock to perform an operation.
 */
package br.ufc.stock.exception;

public class InsufficientAmountStockException extends Exception {
    private int amount;

    /**
     * pedrofalcao10
     * Constructs a new InsufficientAmountStockException with the specified amount.
     *
     * @param amount The amount of items that caused the exception.
     */
    public InsufficientAmountStockException(int amount) {
        super("Insufficient Amount in Stock: " + amount);
        this.amount = amount;
    }
}