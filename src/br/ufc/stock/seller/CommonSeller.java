package br.ufc.stock.seller;

import br.ufc.stock.Stock;
import br.ufc.stock.seller.exception.SellerNegativeAmountException;
import br.ufc.store.StoreRequester;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A type of seller representing a common seller.
 *
 * @author Gabriel Fruet
 */
public class CommonSeller extends BaseSeller implements Serializable {
    /**
     * Constructs a CommonSeller with the specified stock, price, and store requester.
     *
     * @param stock     the stock associated with the seller
     * @param price     the price of the items sold by the seller
     * @param requester the store requester used for credit requests
     */
    public CommonSeller(Stock stock, BigDecimal price, StoreRequester requester) {
        this.stock = stock;
        this.price = price;
        this.requester = requester;
    }

    /**
     * Calculates the price for a specified amount of items.
     *
     * @param amount the amount of items
     * @return the price for the specified amount of items
     * @throws SellerNegativeAmountException if the amount is negative
     */
    @Override
    public BigDecimal price(int amount) throws SellerNegativeAmountException {
        if (amount < 0) {
            throw new SellerNegativeAmountException(amount);
        }
        return this.price.multiply(
                new BigDecimal(amount)
        );
    }
}
