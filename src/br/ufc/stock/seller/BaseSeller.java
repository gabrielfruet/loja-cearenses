package br.ufc.stock.seller;

import br.ufc.stock.Item;
import br.ufc.stock.Stock;
import br.ufc.stock.sale.Sale;
import br.ufc.store.StoreRequester;

import java.math.BigDecimal;

public abstract class BaseSeller implements Seller{
    protected Stock stock;
    protected BigDecimal price;
    protected StoreRequester requester;

    public Sale sell(int amount){
        BigDecimal price = this.price(amount);

        //...

        return null;
    }

    public abstract BigDecimal price(int amount);

    @Override
    public Item getItemType() {
        return this.stock.getItemType();
    }
}
