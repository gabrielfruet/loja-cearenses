package br.ufc.stock.seller.manager;

import br.ufc.stock.Item;
import br.ufc.stock.seller.Seller;
import br.ufc.stock.seller.manager.exception.ExistentSellerException;

import java.util.Optional;
import java.util.Vector;

public class SellerManager {
    private Vector<Seller> sellers;

    public SellerManager(){
        sellers = new Vector<Seller>();
    }

    public void register(Seller seller) throws ExistentSellerException {
        boolean exists = false;
        for(Seller s : this.sellers){
            if(seller.equals(seller)){
                exists = true;
                break;
            }
        }

        if(exists){
            throw new ExistentSellerException(seller);
        }else{
            this.sellers.add(seller);
        }
    }

    public Optional<Seller> get(String id){
        return Optional.empty();
    }

    public Vector<Item> getProducts(){
        return null;
    }
}
