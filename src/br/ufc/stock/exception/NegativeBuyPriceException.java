/**
 * pedrofalcao10
 * The NegativeBuyPriceException class represents an exception that is thrown
 * when a negative buy price is provided where it is not permitted.
 */
package br.ufc.stock.exception;

import java.math.BigDecimal;

public class NegativeBuyPriceException extends Exception {
    private BigDecimal buyPrice;

    /**
     * pedrofalcao10
     * Constructs a new NegativeBuyPriceException with the specified buy price.
     *
     * @param buyPrice The negative buy price that caused the exception.
     */
    public NegativeBuyPriceException(BigDecimal buyPrice) {
        super("Negative buy price: " + buyPrice + " isn't permitted.");
        this.buyPrice = buyPrice;
    }

    /**
     * pedrofalcao10
     * Retrieves the negative buy price that caused the exception.
     *
     * @return The negative buy price.
     */
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }
}

