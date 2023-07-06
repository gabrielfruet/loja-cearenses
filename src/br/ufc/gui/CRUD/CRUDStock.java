package br.ufc.gui.CRUD;

import br.ufc.stock.seller.Seller;

import javax.swing.*;
import java.awt.*;

public class CRUDStock extends CRUDAbstract<Seller>
{
    public CRUDStock(){
        super();
        add(new JLabel("CRUD Stock"), BorderLayout.NORTH);
    }

    public void addElement(){

    }
    protected void loadElements()
    {

    }
}
