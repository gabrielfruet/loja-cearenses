package br.ufc.stock;

import br.ufc.stock.exception.InsufficientAmountStockException;
import br.ufc.stock.exception.NegativeAmountException;
import br.ufc.stock.exception.NegativeBuyPriceException;
import br.ufc.store.StoreRequester;

import java.io.Serializable;
import java.math.BigDecimal;

public class Stock implements Serializable {
    private Item itemType;
    private int amount;
    private BigDecimal buyPrice;
    private StoreRequester requester;

    private int minimalAmount; /*red zone to restock the itens*/
    private int defaultAmount; /*default amount of itens in the stock*/

    public Stock(Item itemType, int amount, BigDecimal buyPrice, StoreRequester requester)
            throws NegativeAmountException, NegativeBuyPriceException {
        if (amount < 0) {
            throw new NegativeAmountException(this.amount);
        }

        if (buyPrice.compareTo(new BigDecimal(0)) > 0) {
            throw new NegativeBuyPriceException(this.buyPrice); /*?????????*/
        }

        this.itemType = itemType;
        this.buyPrice = buyPrice;
        this.requester = requester;
        this.restock(amount);
    }

    public void decreaseAmount(int amount) throws NegativeAmountException , InsufficientAmountStockException {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }

        if (amount > this.amount) {
            throw new InsufficientAmountStockException(this.amount);
        }

        if (this.amount - amount > minimalAmount){
            this.amount -= amount;
        } else {
            this.amount -= amount;
            restock(defaultAmount - this.amount);
        }
    }

    public void increaseAmount(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException(this.amount);
        }
        this.amount += amount;
    }

    public void restock(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException(this.amount);
        }
        increaseAmount(amount);
    }

    public Item getItemType() {
        return itemType;
    }

    public boolean containsItem(Item item) {
        return itemType.getName().equals(item.getName());
    }

    public int getAmount() {
        return amount;
    }

    public boolean equals(Object o){
        return ((Stock)o)
                .getItemType()
                .getName()
                .equals(
                        this.getItemType()
                                .getName()
                );
    }
}
