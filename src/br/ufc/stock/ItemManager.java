package br.ufc.stock;

import java.util.Optional;
import java.util.Vector;

public class ItemManager {
    private Vector<Item> items;

    public ItemManager(){
        this.items = new Vector<Item>();
    }

    public void register(Item item){

    }

    public Optional<Item> getByName(String name){
        return Optional.empty();
    }

    public Optional<Item> getById(String id){
        return Optional.empty();
    }
}
