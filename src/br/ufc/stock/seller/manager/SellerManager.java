package br.ufc.stock.seller.manager;

import br.ufc.stock.Item;
import br.ufc.stock.seller.Seller;

import java.util.Optional;
import java.util.Vector;

public class SellerManager {
    private Vector<Seller> sellers;

    public SellerManager(){
        sellers = new Vector<Seller>();
    }

    public void register(Seller seller){

    }

    public Optional<Seller> get(String id){
        return Optional.empty();
    }

    public Vector<Item> getProducts(){
        return null;
    }
}
