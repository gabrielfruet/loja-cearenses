package br.ufc.stock.seller;

import br.ufc.stock.Stock;
import br.ufc.store.StoreRequester;

import java.io.Serializable;
import java.math.BigDecimal;

public class DiscountSeller extends BaseSeller implements Serializable {
    public DiscountSeller(Stock stock, BigDecimal price, StoreRequester requester){
        this.stock = stock;
        this.price = price;
        this.requester = requester;
    }

    @Override
    public BigDecimal price(int amount) {
        return null;
    }

}
