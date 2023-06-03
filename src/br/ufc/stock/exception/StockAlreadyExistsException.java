package br.ufc.stock.exception;

import br.ufc.stock.Stock;

public class StockAlreadyExistsException extends Exception{
    private Stock stock;

    public StockAlreadyExistsException(Stock stock) {
        super("Stock Already Exists: " + stock);
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }
}
