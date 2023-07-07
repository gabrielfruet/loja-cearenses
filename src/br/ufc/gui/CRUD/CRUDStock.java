package br.ufc.gui.CRUD;

import br.ufc.stock.manager.StockManager;
import br.ufc.stock.seller.Seller;

import javax.swing.*;
import java.awt.*;

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
    protected void loadElements()
    {
    }

}
