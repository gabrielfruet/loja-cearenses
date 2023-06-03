/**
 * pedrofalcao10
 * The NegativeAmountException class represents an exception that is thrown
 * when a negative amount is provided where it is not permitted.
 */
package br.ufc.stock.exception;

public class NegativeAmountException extends Exception {
    private int amount;

    /**
     * pedrofalcao10
     * Constructs a new NegativeAmountException with the specified amount.
     *
     * @param amount The negative amount that caused the exception.
     */
    public NegativeAmountException(int amount) {
        super("Negative amount: " + amount + " isn't permitted.");
        this.amount = amount;
    }
}
