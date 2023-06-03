package br.ufc.stock;

import java.util.Optional;
import java.util.Vector;

public class ItemManager {
    private Vector<Item> items;

    public ItemManager(){
        this.items = new Vector<Item>();
    }

    public void register(Item item){
        boolean alreadyExists = false;
        for(Item current : items){
            if(current.getName().equals(item.getName()))
                alreadyExists = true;
        }

        if(!alreadyExists)
            this.items.add(item);

    }

    public Optional<Item> getByName(String name){
        return Optional.empty();
    }

    public Optional<Item> getById(String id){
        return Optional.empty();
    }
}
