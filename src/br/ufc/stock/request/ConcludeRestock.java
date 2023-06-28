package br.ufc.stock.request;

import br.ufc.stock.Stock;

public class ConcludeRestock implements Concludable{
    private Stock stock;
    private int amount;
    public ConcludeRestock(Stock stock, int amount){
        this.stock = stock;
        this.amount = amount;
    }
    @Override
    public void conclude() {
        this.stock.increaseAmount(amount);
    }
}
