package br.ufc.stock.seller;

import br.ufc.stock.Stock;
import br.ufc.stock.seller.exception.SellerNegativeAmountException;
import br.ufc.store.StoreRequester;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A type of seller representing a discount seller.
 *
 * @author Gabriel Fruet
 */
public class DiscountSeller extends BaseSeller implements Serializable {
    /**
     * Constructs a DiscountSeller with the specified stock, price, and store requester.
     *
     * @param stock     the stock associated with the seller
     * @param price     the price of the items sold by the seller
     * @param requester the store requester used for credit requests
     */
    public DiscountSeller(Stock stock, BigDecimal price, StoreRequester requester) {
        this.stock = stock;
        this.price = price;
        this.requester = requester;
    }

    /**
     * Calculates the price for a specified amount of items with discounts based on the amount.
     *
     * @param amount the amount of items
     * @return the price for the specified amount of items with discounts applied
     * @throws SellerNegativeAmountException if the amount is negative
     */
    @Override
    public BigDecimal price(int amount) throws SellerNegativeAmountException {
        if (amount < 0) {
            throw new SellerNegativeAmountException(amount);
        }

        BigDecimal discount = BigDecimal.ZERO;
        if (amount >= 30) {
            discount = new BigDecimal("0.3");
        } else if (amount >= 20) {
            discount = new BigDecimal("0.2");
        } else if (amount >= 10) {
            discount = new BigDecimal("0.1");
        }

        return this.price.multiply(new BigDecimal(amount))
                .multiply(BigDecimal.ONE.add(discount));
    }
}
