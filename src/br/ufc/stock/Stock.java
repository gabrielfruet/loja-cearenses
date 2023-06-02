package br.ufc.stock;

import br.ufc.store.StoreRequester;

import java.io.Serializable;
import java.math.BigDecimal;

public class Stock implements Serializable {
    private Item itemType;
    private int amount;
    private BigDecimal buyPrice;
    private StoreRequester requester;

    public Stock(Item itemType, int amount, BigDecimal buyPrice, StoreRequester requester){
        this.itemType = itemType;
        this.buyPrice = buyPrice;
        this.requester = requester;
        this.restock(amount);
    }

    public void decreaseAmount(int amount){
        /*
            Calls restock if the stock is in red.
         */

    }

    public void increaseAmount(int amount){

    }

    public void restock(int amount){
        /*
            Decide if restock will call automatically or will be asked to the user.
         */

    }

    public Item getItemType() {
        return itemType;
    }

    public int getAmount() {
        return amount;
    }

    @Override
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
