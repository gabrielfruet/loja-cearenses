package br.ufc.gui.CRUD;

import br.ufc.stock.Item;
import br.ufc.stock.Stock;
import br.ufc.stock.seller.Seller;

import javax.swing.*;
import java.awt.*;

public class CRUDSeller extends CRUDAbstract<Seller>{

    public CRUDSeller(){
        super();
        add(new JLabel("CRUD Seller"), BorderLayout.NORTH);
    }
    public void addElement(){

    }
    protected void loadElements()
    {

    }
}
