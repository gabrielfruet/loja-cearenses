package br.ufc.stock.seller;

import br.ufc.stock.Item;
import br.ufc.stock.sale.Sale;
import br.ufc.stock.seller.exception.SellerNegativeAmountException;

import java.math.BigDecimal;

public interface Seller {
    Sale sell(int amount) throws SellerNegativeAmountException;
    BigDecimal price(int amount);
    Item getItemType();
}
