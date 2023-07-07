/**
 * The StockManager class manages a collection of stocks.
 * It allows registering and retrieving stocks based on different criteria.
 */
package br.ufc.stock.manager;

import br.ufc.stock.Item;
import br.ufc.stock.Stock;
import br.ufc.stock.exception.NegativeAmountException;
import br.ufc.stock.exception.StockAlreadyExistsException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class StockManager implements Serializable {
    private Vector<Stock> stocksVector;

    /**
     * pedrofalcao10
     * Constructs a new StockManager object.
     * Initializes the internal collection of stocks.
     */
    public StockManager() {
        stocksVector = new Vector<>();
    }

    /**
     * pedrofalcao10
     * Registers a stock by directly adding it to the collection of stocks.
     *
     * @param stock The Stock object to be registered.
     * @throws StockAlreadyExistsException if a stock with the same content already exists in the collection.
     */
    public void registerByStock(Stock stock) throws StockAlreadyExistsException {
        if(stocksVector.contains(stock)){
            throw new StockAlreadyExistsException(stock);
        }
        stocksVector.add(stock);
    }

    /**
     * pedrofalcao10
     * Registers a stock by item type.
     * Checks if a stock with the same item type already exists before adding it to the collection.
     *
     * @param stock The Stock object to be registered.
     * @throws StockAlreadyExistsException if a stock with the same item type already exists in the collection.
     */
    public void registerByItem(Stock stock) throws StockAlreadyExistsException {
        Optional<Stock> existingStock = get(stock.getItemType());

        if (existingStock.isPresent()) {
            throw new StockAlreadyExistsException(existingStock.get());
        }

        stocksVector.add(stock);
    }

    /**
     * pedrofalcao10
     * Retrieves a stock that contains the specified item.
     *
     * @param item The Item object to search for in the stocks.
     * @return An Optional containing the found Stock, or an empty Optional if no stock contains the item.
     */
    public Optional<Stock> get(Item item){
        for (Stock stock : stocksVector) {
            if (stock.containsItem(item)) {
                return Optional.of(stock);
            }
        }
        return Optional.empty();
    }

    /**
     * Retrieves all the stocks managed by the StockManager.
     *
     * @return A list of all the stocks.
     *
     * @author fruet
     */
    public List<Stock> getStocks() {
        return new Vector<Stock>(stocksVector);
    }
}

