package br.ufc.stock.sale.manager;

import br.ufc.stock.sale.Sale;

import java.io.Serializable;
import java.util.Vector;

/**
 * The SaleManager class manages the registration of sales.
 * It keeps track of a collection of sales and provides a method to register new sales.
 *
 * @author Kelvin Leandro
 */
public class SaleManager implements Serializable {
    private Vector<Sale> sales;

    /**
     * Constructs a SaleManager object with an empty collection of sales.
     */
    public SaleManager() {
        this.sales = new Vector<Sale>();
    }

    /**
     * Registers a sale in the sale manager if it does not already exist.
     *
     * @param sale The sale to be registered.
     */
    public void register(Sale sale) {
        if (!sales.contains(sale))
            sales.add(sale);
    }
}
