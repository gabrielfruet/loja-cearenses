package br.ufc.gui.CRUD;

import br.ufc.stock.Item;
import br.ufc.stock.Stock;
import br.ufc.stock.manager.StockManager;
import br.ufc.stock.seller.Seller;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class CRUDStock extends CRUDAbstract<Seller>
{
    private final StockManager stocks;

    public CRUDStock(StockManager stocks){
        super();
        add(new JLabel("CRUD Stock"), BorderLayout.NORTH);
        this.stocks = stocks;
    }

    public void addElement(){

    }
    public void editElement(){

    }
    protected void loadElements() {
        List<Stock> elems = this.stocks.getStocks();
        for (Stock current : elems) {
            listModel.addElement(current.toString());
        }
    }

}
