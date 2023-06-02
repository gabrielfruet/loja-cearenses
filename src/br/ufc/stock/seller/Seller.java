package br.ufc.stock.seller;

import br.ufc.stock.Item;
import br.ufc.stock.sale.Sale;

import java.math.BigDecimal;

public interface Seller {
    Sale sell(int amount);
    BigDecimal price(int amount);
    Item getItemType();
}
