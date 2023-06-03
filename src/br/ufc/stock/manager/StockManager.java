package br.ufc.stock.manager;

import br.ufc.stock.Item;
import br.ufc.stock.Stock;
import br.ufc.stock.exception.NegativeAmountException;
import br.ufc.stock.exception.StockAlreadyExistsException;

import java.util.Optional;
import java.util.Vector;

public class StockManager {
    private Vector<Stock> stocksVector;

    public StockManager() {
        stocksVector = new Vector<>();
    }

    public void registerByStock(Stock stock) throws StockAlreadyExistsException {
        if(stocksVector.contains(stock)){
            throw new StockAlreadyExistsException(stock);
        }
        stocksVector.add(stock);
    }

    public void registerByItem(Stock stock) throws StockAlreadyExistsException {
        Optional<Stock> existingStock = get(stock.getItemType());

        if (existingStock.isPresent()) {
            throw new StockAlreadyExistsException(existingStock.get());
        }

        stocksVector.add(stock);
    }

    public Optional<Stock> get(Item item){
        for (Stock stock : stocksVector) {
            if (stock.containsItem(item)) {
                return Optional.of(stock);
            }
        }
        return Optional.empty();
    }
}
