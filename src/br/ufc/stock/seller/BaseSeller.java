package br.ufc.stock.seller;

import br.ufc.stock.Item;
import br.ufc.stock.exception.InsufficientAmountStockException;
import br.ufc.stock.exception.NegativeAmountException;
import br.ufc.stock.request.Request;
import br.ufc.stock.Stock;
import br.ufc.stock.sale.Sale;
import br.ufc.stock.seller.exception.CreditRequestException;
import br.ufc.stock.seller.exception.SellerNegativeAmountException;
import br.ufc.store.StoreRequester;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * An abstract base class for implementing sellers.
 *
 * @author Gabriel Fruet
 */
public abstract class BaseSeller implements Seller {
    protected Stock stock;
    protected BigDecimal price;
    protected StoreRequester requester;

    /**
     * Sells a specified amount of items.
     *
     * @param amount the amount of items to sell
     * @return a Sale object representing the sale
     * @throws SellerNegativeAmountException if the amount is negative
     * @throws CreditRequestException        if the credit request is not concluded
     */
    public Sale sell(int amount) throws SellerNegativeAmountException, NegativeAmountException, InsufficientAmountStockException {
        if (amount < 0) {
            throw new SellerNegativeAmountException(amount);
        }

        BigDecimal totalPrice = this.price(amount);
        this.requester.credit(totalPrice);
        stock.decreaseAmount(amount);

        return new Sale(
                this.getItemType(),
                amount,
                totalPrice,
                LocalDate.now()
        );
    }

    /**
     * Calculates the price for a specified amount of items.
     *
     * @param amount the amount of items
     * @return the price for the specified amount of items
     * @throws SellerNegativeAmountException if the amount is negative
     */
    public abstract BigDecimal price(int amount) throws SellerNegativeAmountException;

    @Override
    public Item getItemType() {
        return this.stock.getItemType();
    }

    @Override
    public boolean equals(Object o) {
        return ((Seller) o).getItemType().equals(this.getItemType());
    }
}
