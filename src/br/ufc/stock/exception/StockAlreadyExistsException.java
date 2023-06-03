/**
 * pedrofalcao10
 * The StockAlreadyExistsException class represents an exception that is thrown
 * when attempting to register a stock that already exists.
 */
package br.ufc.stock.exception;

import br.ufc.stock.Stock;

public class StockAlreadyExistsException extends Exception {
    private Stock stock;

    /**
     * pedrofalcao10
     * Constructs a new StockAlreadyExistsException with the specified stock.
     *
     * @param stock The stock that already exists.
     */
    public StockAlreadyExistsException(Stock stock) {
        super("Stock Already Exists: " + stock);
        this.stock = stock;
    }

    /**
     * pedrofalcao10
     * Retrieves the stock that already exists.
     *
     * @return The existing stock.
     */
    public Stock getStock() {
        return stock;
    }
}

