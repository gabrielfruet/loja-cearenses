/**
 * pedrofalcao10
 * The Stock class represents a stock of items in a store.
 * It keeps track of the item type, amount, buy price, and requester.
 * It also provides methods for managing the stock, such as decreasing/increasing the amount and restocking.
 */
package br.ufc.stock;

import br.ufc.stock.exception.InsufficientAmountStockException;
import br.ufc.stock.exception.NegativeAmountException;
import br.ufc.stock.exception.NegativeBuyPriceException;
import br.ufc.stock.request.ConcludeRestock;
import br.ufc.stock.request.Request;
import br.ufc.store.StoreRequester;

import java.io.Serializable;
import java.math.BigDecimal;

public class Stock implements Serializable {
    private Item itemType;
    private int amount;
    private BigDecimal buyPrice;
    private StoreRequester requester;

    /**
     * pedrofalcao10
     * */
    private int minimalAmount; // The red zone to restock the items
    private int defaultAmount; // The default amount of items in the stock

    /**
     * pedrofalcao10
     * Constructs a new Stock object with the specified item type, amount, buy price, and requester.
     *
     * @param itemType   The Item object representing the type of item in the stock.
     * @param amount     The initial amount of the item in the stock.
     * @param buyPrice   The buy price of the item.
     * @param requester  The StoreRequester object associated with the stock.
     * @throws NegativeAmountException     if the initial amount is negative.
     * @throws NegativeBuyPriceException   if the buy price is negative.
     */
    public Stock(Item itemType, int amount, BigDecimal buyPrice, StoreRequester requester)
            throws NegativeAmountException, NegativeBuyPriceException {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }

        if (buyPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeBuyPriceException(buyPrice);
        }

        this.itemType = itemType;
        this.buyPrice = buyPrice;
        this.requester = requester;
        this.restock(amount);
    }

    /**
     * pedrofalcao10
     * Decreases the amount of the item in the stock by the specified amount.
     *
     * @param amount The amount to decrease from the stock.
     * @throws NegativeAmountException             if the specified amount is negative.
     * @throws InsufficientAmountStockException    if the stock does not have enough items to decrease.
     */
    public void decreaseAmount(int amount) throws NegativeAmountException, InsufficientAmountStockException {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }

        if (amount > this.amount) {
            throw new InsufficientAmountStockException(this.amount);
        }

        if (this.amount - amount > minimalAmount) {
            this.amount -= amount;
        } else {
            this.amount -= amount;
            restock(defaultAmount - this.amount);
        }
    }

    /**
     * pedrofalcao10
     * Increases the amount of the item in the stock by the specified amount.
     *
     * @param amount The amount to increase the stock.
     * @throws NegativeAmountException if the specified amount is negative.
     */
    public void increaseAmount(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }
        this.amount += amount;
    }

    /**
     * pedrofalcao10
     * Restocks the item in the stock by the specified amount.
     *
     * @param amount The amount to restock the stock.
     * @throws NegativeAmountException if the specified amount is negative.
     */
    public void restock(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }
        Request req  = new Request(
                new ConcludeRestock(this, amount),
                this.priceToBuy(amount)
        );
        this.requester.debit(req);
    }

    public BigDecimal priceToBuy(int amount) throws NegativeAmountException{
        if(amount < 0){
            throw new NegativeAmountException(amount);
        }
        return this.buyPrice.multiply(BigDecimal.valueOf(amount));
    }

    /**
     * pedrofalcao10
     * Retrieves the item type associated with the stock.
     *
     * @return The Item object representing the item type.
     */
    public Item getItemType() { return itemType; }
    public String getItemName(){return itemType.getName();}

    /**
     * pedrofalcao10
     * Checks if the stock contains the specified item.
     *
     * @param item The Item object to check for in the stock.
     * @return true if the stock contains the item, false otherwise.
     */
    public boolean containsItem(Item item) { return itemType.getName().equals(item.getName()); }

    /**
     * pedrofalcao10
     * Retrieves the current amount of the item in the stock.
     *
     * @return The current amount of the item in the stock.
     */
    public int getAmount() { return amount; }

    /**
     * pedrofalcao10
     * Checks if the stock is equal to the specified object.
     * Two stocks are considered equal if they have the same item type.
     *
     * @param o The object to compare with the stock.
     * @return true if the stock is equal to the object, false otherwise.
     */
    public boolean equals(Object o){
        return ((Stock)o)
                .getItemType()
                .getName()
                .equals(
                        this.getItemType()
                                .getName()
                );
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    @Override
    public String toString() {
        return "Estoque de " + itemType.toString()
                + ", com quantidade atual de "
                + this.amount + ", e preco de restoque "
                + this.buyPrice.toString();
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
}
