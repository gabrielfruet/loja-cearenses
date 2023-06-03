package br.ufc.stock.seller;

import br.ufc.stock.Item;
import br.ufc.stock.sale.Sale;
import br.ufc.stock.seller.exception.SellerNegativeAmountException;

import java.math.BigDecimal;

/**
 * Represents a seller.
 *
 * @author Gabriel Fruet
 */
public interface Seller {
    /**
     * Sells a specified amount of items.
     *
     * @param amount the amount of items to sell
     * @return a Sale object representing the sale
     * @throws SellerNegativeAmountException if the amount is negative
     */
    Sale sell(int amount) throws SellerNegativeAmountException;

    /**
     * Calculates the price for a specified amount of items.
     *
     * @param amount the amount of items
     * @return the price for the specified amount of items
     * @throws SellerNegativeAmountException if the amount is negative
     */
    BigDecimal price(int amount) throws SellerNegativeAmountException;

    /**
     * Retrieves the item type associated with the seller.
     *
     * @return the item type
     */
    Item getItemType();
}
