package br.ufc.stock.seller;

import br.ufc.stock.Stock;

import java.math.BigDecimal;

public abstract class BaseSeller implements Seller{
    private Stock stock;
    private BigDecimal price;
}
