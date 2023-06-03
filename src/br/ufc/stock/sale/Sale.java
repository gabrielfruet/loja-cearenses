package br.ufc.stock.sale;

import br.ufc.stock.Item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Sale implements Serializable {
    Item itemType;
    int amount;
    BigDecimal totalPrice;
    LocalDate date;

    public Sale(Item itemType, int amount, BigDecimal totalPrice, LocalDate date){
        this.itemType = itemType;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public Item getItemType() {
        return itemType;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

}
